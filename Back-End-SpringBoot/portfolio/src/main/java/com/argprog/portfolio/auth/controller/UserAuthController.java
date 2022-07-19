package com.argprog.portfolio.auth.controller;


import com.argprog.portfolio.auth.dto.AuthenticationRequest;
import com.argprog.portfolio.auth.dto.AuthenticationResponse;
import com.argprog.portfolio.auth.dto.UserDTO;
import com.argprog.portfolio.auth.service.JwtUtils;
import com.argprog.portfolio.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserAuthController {

    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    @Autowired
    public UserAuthController(UserDetailsCustomService userDetailsService,
                              AuthenticationManager authenticationManager,
                              JwtUtils jwtUtils){
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/singup")
    public ResponseEntity<AuthenticationResponse> singUp(@Valid @RequestBody UserDTO userDTO) throws Exception{
        this.userDetailsService.save(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        UserDetails userDetails;

        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );

            userDetails = (UserDetails) auth.getPrincipal();
        }catch (BadCredentialsException ex){
            throw new Exception("Incorrect username or password", ex);
        }

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
