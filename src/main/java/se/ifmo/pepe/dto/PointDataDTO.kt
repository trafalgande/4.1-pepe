package se.ifmo.pepe.dto

import io.swagger.annotations.ApiModelProperty

data class PointDataDTO(
    @ApiModelProperty(position = 0)
    val x: Double,
    @ApiModelProperty(position = 1)
    val y: Double,
    @ApiModelProperty(position = 2)
    val r: Double
)
