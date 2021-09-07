package se.ifmo.pepe.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .build()
        .apiInfo(metadata())
        .useDefaultResponseMessages(false)
        .tags(new Tag("users", "Operations about users"))
        .genericModelSubstitutes(Optional.class);

  }

  private ApiInfo metadata() {
    return new ApiInfoBuilder()
        .title("PEPEHENDS")
        .description("POMOGNTE")
        .version("1.0.0")
        .build();
  }

}
