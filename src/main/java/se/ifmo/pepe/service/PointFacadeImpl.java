package se.ifmo.pepe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.ifmo.pepe.configuration.security.JwtTokenProvider;
import se.ifmo.pepe.domain.Point;
import se.ifmo.pepe.domain.plot.Plot;
import se.ifmo.pepe.repository.PointRepository;
import se.ifmo.pepe.repository.UserRepository;
import se.ifmo.pepe.service.facade.PointFacade;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointFacadeImpl implements PointFacade {
    private final UserRepository userRepository;
    private final PointRepository pointRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final Plot plot;

    @Override
    public void addPoint(HttpServletRequest req, Point point) {
        point.setResult(plot.check(point));
        point.setUser(userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))));
        pointRepository.save(point);
    }

    @Override
    public List<Point> showAllPoints() {
        return pointRepository.findAll();
    }

    @Override
    public List<Point> showPointsDedicatedToCurrentUser(HttpServletRequest req) {
        return pointRepository.findAllByUser(userRepository
                .findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))));
    }

    @Override
    public List<Point> updatePoints(HttpServletRequest req, Double r) {
        List<Point> prev = pointRepository.findAllByUser(userRepository
                .findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))));
        for (Point p : prev) {
            p.setR(r);
            p.setResult(plot.check(p.getX(), p.getY(), p.getR()));
            pointRepository.save(p);
        }
        return prev;
    }
}
