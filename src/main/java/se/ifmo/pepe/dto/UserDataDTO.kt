package se.ifmo.pepe.dto

import io.swagger.annotations.ApiModelProperty
import se.ifmo.pepe.domain.Role

data class UserDataDTO(
    @ApiModelProperty(position = 0)
    val username: String,
    @ApiModelProperty(position = 1)
    val password: String,
    @ApiModelProperty(position = 2)
    val roles: List<Role>
)
