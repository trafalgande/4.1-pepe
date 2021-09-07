package se.ifmo.pepe;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import se.ifmo.pepe.service.UserFacadeImpl;

@SpringBootApplication
public class FourthPepeLmao {

    @Autowired
    UserFacadeImpl userFacadeImpl;

    public static void main(String[] args) {
        SpringApplication.run(FourthPepeLmao.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
