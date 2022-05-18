package ru.itis.kurguskina.internet.service;


import ru.itis.kurguskina.internet.dto.UserDto;
import ru.itis.kurguskina.internet.dto.SignUpForm;
import ru.itis.kurguskina.internet.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void signUp(SignUpForm form);
    void updateState(String confirmCode);
    List<UserDto> getAllUsers();
    void deleteUser(Long id);
    void update(UserDto userDto, String email);
    Optional<UserDto> getUsersByEmail(String email);
    void saveUser(User user);
    User getUserById(Long id);
    UserDto getUserByEmail(String email);
}
