package se.ifmo.pepe.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


@Data
public class PointDataDTO {
    @ApiModelProperty(position = 0)
    private Double x;
    @ApiModelProperty(position = 1)
    private Double y;
    @ApiModelProperty(position = 2)
    private Double r;
}

