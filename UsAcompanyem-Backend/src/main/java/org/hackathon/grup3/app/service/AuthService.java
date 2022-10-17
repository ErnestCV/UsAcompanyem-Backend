package org.hackathon.grup3.app.service;

import org.hackathon.grup3.app.model.ERole;
import org.hackathon.grup3.app.model.Role;
import org.hackathon.grup3.app.model.User;
import org.hackathon.grup3.app.payload.request.LoginRequest;
import org.hackathon.grup3.app.payload.request.SignupRequest;
import org.hackathon.grup3.app.payload.response.JwtResponse;
import org.hackathon.grup3.app.payload.response.MessageResponse;
import org.hackathon.grup3.app.payload.response.MessageResponseWrapper;
import org.hackathon.grup3.app.repository.RoleRepository;
import org.hackathon.grup3.app.repository.UserRepository;
import org.hackathon.grup3.app.security.jwt.JwtUtils;
import org.hackathon.grup3.app.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    //Mètode login
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        //Obtenim autenticació, actualitzem el context i generem el token JWT
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        //Obtenim UserDetails i retornem resposta de l'usuari amb els seus rols
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
    }

    //Mètode signup
    public MessageResponseWrapper registerUser(SignupRequest signupRequest) {
        //Validem username i email
        if (!signupRequest.getUsername().equals("ANÒNIM") && userRepository.existsByUsername(signupRequest.getUsername())) {
            return new MessageResponseWrapper(HttpStatus.BAD_REQUEST, new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return new MessageResponseWrapper(HttpStatus.BAD_REQUEST, new MessageResponse("Error: Email is already in use!"));
        }
        //Create new user account
        createUserAccount(signupRequest);

        return new MessageResponseWrapper(HttpStatus.OK, new MessageResponse("User registered successfully!"));
    }

    //MongoDB
    private void createUserAccount(SignupRequest signupRequest) {
        //Nou usuari amb contrasenya encriptada
        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));
        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        //Si no té rol determinat, se li assigna USER per defecte
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
    }
}
