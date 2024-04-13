package org.example.demo.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Schema(description = "Запит на реєстрацію")
public class SignUpRequest {

    @Schema(description = "Ім'я користувача", example = "Jon")
    @Size(min = 5, max = 50, message = "Ім'я користувача повинно містити від 5 до 50 символів")
    @NotBlank(message = "Ім'я користувача не може бути порожнім")
    private String username;

    @Schema(description = "Адреса електронної пошти", example = "jondoe@gmail.com")
    @Size(min = 5, max = 255, message = "Адреса електронної пошти повинна містити від 5 до 255 символів")
    @NotBlank(message = "Адреса електронної пошти не може бути порожньою")
    @Email(message = "Email адреса повинна бути у форматі user@example.com")
    private String email;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 255, message = "Довжина пароля повинна бути не більше 255 символів")
    private String password;
}