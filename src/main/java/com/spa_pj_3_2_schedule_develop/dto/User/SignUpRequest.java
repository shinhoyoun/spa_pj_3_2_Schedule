package com.spa_pj_3_2_schedule_develop.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * id
 * username
 * email
 * password
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Email
    @Size(max=50)
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min=8, max=50)
    private String password;
}
