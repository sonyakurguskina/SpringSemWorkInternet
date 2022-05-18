package ru.itis.kurguskina.springsemworkinternet.helper;

import lombok.RequiredArgsConstructor;
import ru.itis.kurguskina.springsemworkinternet.models.User;
import ru.itis.kurguskina.springsemworkinternet.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private final UserRepository userRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<User> account = userRepository.findUserByEmail(value);
        if (account.isPresent()) {
            return false;
        }
        return true;
    }
}
