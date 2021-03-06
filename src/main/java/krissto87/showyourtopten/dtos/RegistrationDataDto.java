package krissto87.showyourtopten.dtos;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class RegistrationDataDto {

    @NotBlank
    @Size(min = 3, max = 12)
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 4, max = 12)
    private String password;
    @NotBlank
    @Size(min = 4, max = 12)
    private String rePassword;
    @NotNull
    @AssertTrue
    private Boolean termsAcceptance;
}
