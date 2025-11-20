package com.spa_pj_3_2_schedule_develop.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    @Email
    @Size(max=50)
    private String email;

    @NotBlank
    @Size(min=8, max=50)
    private String password;
}
