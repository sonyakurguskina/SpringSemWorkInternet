package ru.itis.kurguskina.internet.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.kurguskina.internet.dto.UserDto;
import ru.itis.kurguskina.internet.dto.SignUpForm;
import ru.itis.kurguskina.internet.helper.exceptions.AccountNotExistsException;
import ru.itis.kurguskina.internet.models.User;
import ru.itis.kurguskina.internet.repositories.UserRepository;
import ru.itis.kurguskina.internet.service.UserService;
import ru.itis.kurguskina.internet.utils.EmailUtil;


import java.util.*;

import static ru.itis.kurguskina.internet.dto.UserDto.from;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.port}")
    String userDto;

    @Transactional
    @Override
    public void signUp(SignUpForm signUpForm) {
        User newUser = User.builder()
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .email(signUpForm.getEmail().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .state(User.State.NOT_CONFIRMED)
                .role(User.Role.USER)
                .build();
        userRepository.save(newUser);

        HashMap<String, String> data = new HashMap<>();
        data.put("confirm_code", newUser.getConfirmCode());
        data.put("first_name", newUser.getFirstName());
        data.put("port", userDto);
        emailUtil.sendMail(newUser.getEmail(), "confirm", "mails/confirm_mail.ftlh",
                data);
    }

    @Override
    public void updateState(String confirmCode) {
        User user = userRepository.findAllByConfirmCode(confirmCode);
        if (user == null) {
            throw new AccountNotExistsException();
        }
        user.setState(User.State.CONFIRMED);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return from(userRepository.findAllByState(User.State.CONFIRMED));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public void update(UserDto userDto, String email) {
        userRepository.updateUser(userDto.getFirstName(), userDto.getLastName(), passwordEncoder.encode(userDto.getPassword()), email);
    }

    @Override
    public Optional<UserDto> getUsersByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if (user == null) {
            return Optional.empty();
        } else {
            return Optional.of(UserDto.from(user.get()));
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserDto getUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.getUserByEmail(email);

        return optionalUser.map(UserDto::from).orElse(null);
    }


}


