package com.group2.To_Do_App.security.auth.authPayload.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {

    private String email;
    private String token;
}
