package se.ifmo.pepe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ifmo.pepe.model.Point;
import se.ifmo.pepe.model.User;

import java.util.List;

public interface PointRepository extends JpaRepository<Point, Integer> {
    List<Point> findAllByUser (User user);
}
