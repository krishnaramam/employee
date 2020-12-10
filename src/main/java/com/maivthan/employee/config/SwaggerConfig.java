package com.maivthan.employee.config;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${SPRING_PROFILES_ACTIVE}")
	private String region_env;
	

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
				.license("Region Env:"+region_env)
				.version("1.0").build();
	}		
	
	public String getRegion_env() {
		return region_env;
	}

	public void setRegion_env(String region_env) {
		this.region_env = region_env;
	}

	
	
}
