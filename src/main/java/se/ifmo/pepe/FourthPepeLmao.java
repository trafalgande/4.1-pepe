package se.ifmo.pepe;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import se.ifmo.pepe.model.Role;
import se.ifmo.pepe.model.User;
import se.ifmo.pepe.service.UserService;

@SpringBootApplication
public class FourthPepeLmao {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(FourthPepeLmao.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
