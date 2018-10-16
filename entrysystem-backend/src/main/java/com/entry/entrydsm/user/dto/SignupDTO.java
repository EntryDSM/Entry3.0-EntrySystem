package com.entry.entrydsm.user.dto;

import com.entry.entrydsm.user.domain.tempuser.TempUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class SignupDTO {
    @NotNull
    @Email(regexp = "([\\w-.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$")
    private String password;

    public TempUser toTempUser(PasswordEncoder passwordEncoder) {
        return new TempUser(email, passwordEncoder.encode(password));
    }

    public SignupDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
