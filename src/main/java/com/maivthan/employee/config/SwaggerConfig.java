package com.maivthan.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
   
	
	
	@Bean
	public Docket API() {
	    return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(APIInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.maivthan.employee.controller"))
				.paths(PathSelectors.any())
	        .build();	    
	}
	
	private ApiInfo APIInfo() {
		return new ApiInfoBuilder().title("Employee Micro Service" )				
				.description("Maivthan Global Retail ")
				.license("Project:Maivthan Retail")
				.version("1.0").build();
	}		
	
}
