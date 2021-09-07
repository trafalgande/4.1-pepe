package se.ifmo.pepe.service.facade;

import org.springframework.http.ResponseEntity;
import se.ifmo.pepe.dto.TokenDTO;
import se.ifmo.pepe.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface UserFacade {
    ResponseEntity<TokenDTO> signin(String username, String password);

    ResponseEntity<TokenDTO> signup(User user);

    void delete(String username);

    User search(String username);

    User whoami(HttpServletRequest req);

    String refresh(String username);
}
