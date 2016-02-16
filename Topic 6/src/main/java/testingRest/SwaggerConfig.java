package testingRest;

import springfox.documentation.spi.DocumentationType;


import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket userApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("usersAPI")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/usersAPI.*"))
				.build();
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Spring REST user API")
				.description("Simple Spring REST user registration using Spring Data with mongoDB")
				.termsOfServiceUrl("")
				.contact("xelimaSw")
				.license("")
				.licenseUrl("")
				.version("0.0.1-SNAPSHOT")
				.build();
	}
}