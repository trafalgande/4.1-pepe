package se.ifmo.pepe.domain.plot;

import org.springframework.stereotype.Component;
import se.ifmo.pepe.domain.Point;

@Component
public class Plot {
    public boolean check(double x, double y, double r) {
        boolean triangle = x <= 0 && y >= 0 && y <= x / 2 + r / 2;
        boolean square = x >= -r && x <= 0 && y >= -r / 2 && y <= 0;
        boolean sector = x >= 0 && y <= 0 && (x * x + y * y) <= (r / 2 * r / 2);
        return triangle || square || sector;
    }

    public boolean check(Point point) {
        return check(point.getX(), point.getY(), point.getR());
    }
}

