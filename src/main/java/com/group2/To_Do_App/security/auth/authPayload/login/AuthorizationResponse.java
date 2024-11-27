package com.group2.To_Do_App.security.auth.authPayload.login;

import com.group2.To_Do_App.security.auth.authPayload.register.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {

    private String responseCode;
    private String responseMessage;
    private LoginInfo loginInfo;
}
