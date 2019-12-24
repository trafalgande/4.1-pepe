package se.ifmo.pepe.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import se.ifmo.pepe.model.Role;
@Data
public class UserDataDTO {
  
  @ApiModelProperty(position = 0)
  private String username;
  @ApiModelProperty(position = 1)
  private String password;
  @ApiModelProperty(position = 2)
  List<Role> roles;

}
