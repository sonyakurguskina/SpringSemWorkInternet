package ru.itis.kurguskina.internet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.kurguskina.internet.helper.ValidEmail;
import ru.itis.kurguskina.internet.helper.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {

    @NotBlank
    @Size(min = 2, max = 12)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @Validator
    private String password;

    @Email
    @ValidEmail
    @NotBlank
    private String email;


}
