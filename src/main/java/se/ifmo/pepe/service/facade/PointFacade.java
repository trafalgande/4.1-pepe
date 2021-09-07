package se.ifmo.pepe.service.facade;

import se.ifmo.pepe.domain.Point;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PointFacade {
    void addPoint(HttpServletRequest req, Point point);

    List<Point> showAllPoints();

    List<Point> showPointsDedicatedToCurrentUser(HttpServletRequest req);

    List<Point> updatePoints(HttpServletRequest req, Double r);
}
