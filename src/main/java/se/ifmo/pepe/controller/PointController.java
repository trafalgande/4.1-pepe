package se.ifmo.pepe.controller;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.ifmo.pepe.dto.PointDataDTO;
import se.ifmo.pepe.exception.CustomException;
import se.ifmo.pepe.domain.Point;
import se.ifmo.pepe.service.PointFacade;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "/points")
@RequiredArgsConstructor
public class PointController {
    private final PointFacade pointFacade;
    private final ModelMapper modelMapper;

    @CrossOrigin
    @PostMapping
    public String addPoint(HttpServletRequest req, @RequestBody PointDataDTO point) {
        try {
            pointFacade.addPoint(req, modelMapper.map(point, Point.class));
            return "Your point was added";
        } catch (Exception e) {
            throw new CustomException("Invalid data supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @CrossOrigin
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Point> showAllPoints() {
        return pointFacade.showAllPoints();
    }

    @CrossOrigin
    @GetMapping("/currentpoints")
    public List<Point> showPointsDedicatedToCurrentUser(HttpServletRequest req){
        return pointFacade.showPointsDedicatedToCurrentUser(req);
    }

    @CrossOrigin
    @PostMapping("/update")
    public List<Point> updatePoints(HttpServletRequest req, Double r) {
        return pointFacade.updatePoints(req,r);
    }
}
