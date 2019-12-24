package se.ifmo.pepe.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import se.ifmo.pepe.model.Role;

@Data
public class UserResponseDTO {

  @ApiModelProperty(position = 0)
  private Integer id;
  @ApiModelProperty(position = 1)
  private String username;
  @ApiModelProperty(position = 2)
  List<Role> roles;


}
