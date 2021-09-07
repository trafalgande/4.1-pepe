package se.ifmo.pepe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.ifmo.pepe.configuration.security.JwtTokenProvider;
import se.ifmo.pepe.domain.Role;
import se.ifmo.pepe.domain.User;
import se.ifmo.pepe.dto.TokenDTO;
import se.ifmo.pepe.exception.CustomException;
import se.ifmo.pepe.repository.UserRepository;
import se.ifmo.pepe.service.facade.UserFacade;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;

  @Override
  public ResponseEntity<TokenDTO> signin(String username, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      String token = jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
      return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @Override
  public ResponseEntity<TokenDTO> signup(User user) {
    if (!userRepository.existsByUsername(user.getUsername())) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRoles(new ArrayList<>(Collections.singletonList(Role.ROLE_CLIENT)));
      userRepository.save(user);
      String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
      return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @Override
  public void delete(String username) {
    userRepository.deleteByUsername(username);
  }

  @Override
  public User search(String username) {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return user;
  }

  @Override
  public User whoami(HttpServletRequest req) {
    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  @Override
  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
  }
}