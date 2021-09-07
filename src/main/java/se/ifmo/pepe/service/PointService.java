package se.ifmo.pepe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.ifmo.pepe.model.Point;
import se.ifmo.pepe.plot.Plot;
import se.ifmo.pepe.repository.PointRepository;
import se.ifmo.pepe.repository.UserRepository;
import se.ifmo.pepe.configuration.security.JwtTokenProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {
    private final UserRepository userRepository;
    private final PointRepository pointRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final Plot plot;


   public void addPoint(HttpServletRequest req, Point point){
        point.setResult(plot.check(point));
        point.setUser(userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))));
        pointRepository.save(point);
    }

    public List<Point> showAllPoints() {
       return pointRepository.findAll();
    }

    public List<Point> showPointsDedicatedToCurrentUser(HttpServletRequest req) {
       return pointRepository.findAllByUser(userRepository
               .findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))));
    }

    public List<Point> updatePoints(HttpServletRequest req, Double r) {
        List<Point> prev = pointRepository.findAllByUser(userRepository
                .findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))));
        for (Point p:
             prev) {
            p.setR(r);
            p.setResult(plot.check(p.getX(),p.getY(),p.getR()));
            pointRepository.save(p);
        }
        return prev;
    }


}
