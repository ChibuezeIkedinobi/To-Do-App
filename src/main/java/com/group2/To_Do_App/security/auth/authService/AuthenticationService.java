package com.group2.To_Do_App.security.auth.authService;

import com.group2.To_Do_App.enums.Role;
import com.group2.To_Do_App.exception.customException.InvalidInputException;
import com.group2.To_Do_App.exception.customException.ResourceNotFoundException;
import com.group2.To_Do_App.model.User;
import com.group2.To_Do_App.repository.UserRepository;
import com.group2.To_Do_App.security.auth.authPayload.login.AuthorizationResponse;
import com.group2.To_Do_App.security.auth.authPayload.login.LoginInfo;
import com.group2.To_Do_App.security.auth.authPayload.login.LoginRequest;
import com.group2.To_Do_App.security.auth.authPayload.mail.EmailDetails;
import com.group2.To_Do_App.security.auth.authPayload.mail.EmailService;
import com.group2.To_Do_App.security.auth.authPayload.register.AuthenticationResponse;
import com.group2.To_Do_App.security.auth.authPayload.register.RegisterRequest;
import com.group2.To_Do_App.security.auth.authPayload.register.RegistrationInfo;
import com.group2.To_Do_App.security.config.JwtService;
import com.group2.To_Do_App.security.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        if (!isValidEmail(request.getEmail())) {
            throw new InvalidInputException("🚨🚨Invalid email format: " + request.getEmail() + "🚨🚨");
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new InvalidInputException("🚨🚨User with the email "+request.getEmail()+" already exists🚨🚨");
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new InvalidInputException("🚨🚨Passwords do not match🚨🚨");
        }


        User user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(Role.USER)
                .build();
        User saveNewUser = userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(saveNewUser.getEmail())
                .subject("ACCOUNT CREATED✅✅✅✅")
                .messageBody("CONGRATULATIONS!!! Your account has been successfully created💥💥\n TOKEN: "+ jwtToken)
                .build();
        emailService.sendEmailAlert(emailDetails);

        return AuthenticationResponse.builder()
                .responseCode(Util.ACCOUNT_CREATION_SUCCESS_CODE)
                .responseMessage(Util.ACCOUNT_CREATION_SUCCESS_MESSAGE)
                .registrationInfo(RegistrationInfo.builder()
                        .firstName(saveNewUser.getFirstName())
                        .lastName(saveNewUser.getLastName())
                        .email(saveNewUser.getEmail())
                        .token(jwtToken)
                        .build())
                .build();
    }

    public AuthorizationResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            return AuthorizationResponse.builder()
                    .responseCode(Util.LOGIN_FAILURE_CODE)
                    .responseMessage(Util.LOGIN_FAILURE_MESSAGE)
                    .build();
        }
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.getEmail()));

        var jwtToken = jwtService.generateToken(user);
        return AuthorizationResponse.builder()
                .responseCode(Util.LOGIN_SUCCESS_CODE)
                .responseMessage(Util.LOGIN_SUCCESS_MESSAGE)
                .loginInfo(LoginInfo.builder()
                        .email(user.getEmail())
                        .token(jwtToken)
                        .build())
                .build();
    }

    public AuthorizationResponse logout(String token) {
        String actualToken = token.replace("Bearer ", "");
        jwtService.invalidateToken(actualToken);

        return AuthorizationResponse.builder()
                .responseCode(Util.LOGOUT_SUCCESS_CODE)
                .responseMessage(Util.LOGOUT_SUCCESS_MESSAGE)
                .build();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }
}
