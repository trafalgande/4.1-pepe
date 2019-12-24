package se.ifmo.pepe.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Double x;
    @Column(nullable = false)
    private Double y;
    @Column(nullable = false)
    private Double r;
    @Column(nullable = false)
    private Boolean result;

    @ManyToOne(cascade=CascadeType.ALL)
    User user;

}

