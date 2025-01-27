package com.iremkoc.user_management_system.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iremkoc.user_management_system.business.abstracts.AuthenticateService;
import com.iremkoc.user_management_system.business.requests.LoginRequest;
import com.iremkoc.user_management_system.business.requests.RegisterRequest;
import com.iremkoc.user_management_system.config.concretes.JwtService;
import com.iremkoc.user_management_system.core.utilities.exceptions.BusinessException;
import com.iremkoc.user_management_system.dataAccess.abstracts.UserRepository;
import com.iremkoc.user_management_system.entities.concretes.Response;
import com.iremkoc.user_management_system.entities.concretes.User;

@Service
public class AuthenticateManager implements AuthenticateService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response register(RegisterRequest registerRequest) {
        Response response = new Response();
        try {
            if (registerRequest.getRole() == null || registerRequest.getRole().isBlank()) {
                registerRequest.setRole("USER");
            }
            if (userRepository.existsByEmail(registerRequest.getEmail())) {
                throw new BusinessException(registerRequest.getEmail() + " already exists");
            }
            userRepository.save(User.builder().email(registerRequest.getEmail())
                    .password(passwordEncoder.encode(registerRequest.getPassword())).role(registerRequest.getRole())
                    .username(registerRequest.getUsername()).build());
            response.setStatusCode(200);
            response.setMessage("Successfully registered");
        } catch (BusinessException e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error occured during user registration " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        Response response = new Response();
        try {
            authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
            User user = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new BusinessException("User not found"));
            var jwt = jwtService.generateToken(user.getEmail());
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(user.getRole());
            response.setUser(user);
            response.setStatusCode(200);
            response.setMessage("Successfully logged in");
        } catch (BusinessException e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error occured during user registration " + e.getMessage());
        }
        return response;
    }

}
