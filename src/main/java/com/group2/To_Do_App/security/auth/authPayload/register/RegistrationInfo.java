package com.group2.To_Do_App.security.auth.authPayload.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationInfo {

    private String firstName;
    private String lastName;
    private String email;
    private String token;
}
