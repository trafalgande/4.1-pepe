package se.ifmo.pepe.plot;

import org.springframework.stereotype.Component;
import se.ifmo.pepe.model.Point;

@Component
public class Plot {
    public boolean check(double x, double y, double r) {
        boolean triangle = x <= 0 && y >= 0 && y <= (x + r) / 2;
        boolean square = x >= 0 && y >= 0 && x <= r && y <= r / 2;
        boolean sector = x >= 0 && y <= 0 && Math.sqrt(x * x + y * y) <= r / 2;
        return triangle || square || sector;
    }

    public boolean check(Point point) {
        return check(point.getX(), point.getY(), point.getR());
    }
}

