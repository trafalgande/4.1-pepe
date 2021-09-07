package se.ifmo.pepe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ifmo.pepe.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  void deleteByUsername(String username);
}
