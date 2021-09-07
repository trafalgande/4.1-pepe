package se.ifmo.pepe.dto

import io.swagger.annotations.ApiModelProperty
import se.ifmo.pepe.domain.Role

data class UserResponseDTO(
    @ApiModelProperty(position = 0)
    val id: Int,
    @ApiModelProperty(position = 1)
    val username: String,
    @ApiModelProperty(position = 2)
    val roles: List<Role>
)
