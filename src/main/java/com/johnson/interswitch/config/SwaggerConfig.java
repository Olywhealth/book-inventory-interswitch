package com.johnson.interswitch.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Johnson on 16/12/2023
 */
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.johnson.interswitch.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Book Library API")
            .description("API documentation for the Book Inventory application")
            .version("1.0")
            .build();
  }


  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
