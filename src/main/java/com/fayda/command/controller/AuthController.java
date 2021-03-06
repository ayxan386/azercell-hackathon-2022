package com.fayda.command.controller;

import com.fayda.command.dto.GenericResponse;
import com.fayda.command.dto.login.EmailLoginRequestDTO;
import com.fayda.command.dto.register.JwtResponseDTO;
import com.fayda.command.dto.register.RegisterRequestDTO;
import com.fayda.command.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<GenericResponse<JwtResponseDTO>> register(@Valid @RequestBody RegisterRequestDTO req) {
    log.info("Trying to register new user {}", req.getEmail());
    final var response = userService.register(req);
    log.info("Registering new user {} was successful", req.getEmail());

    return ResponseEntity.status(CREATED.value()).body(GenericResponse.success(response));
  }

  @PostMapping("/login/email")
  public ResponseEntity<GenericResponse<JwtResponseDTO>> login(@Valid @RequestBody EmailLoginRequestDTO req) {
    log.info("Trying to login user {}", req.getEmail());
    JwtResponseDTO response = userService.login(req);
    log.info("Signing in user {} was successful", req.getEmail());

    return ResponseEntity.status(OK.value()).body(GenericResponse.success(response));
  }

}
