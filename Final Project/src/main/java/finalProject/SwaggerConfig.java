package finalProject;

import springfox.documentation.spi.DocumentationType;


import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket userApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("FinalProject")
				.apiInfo(apiInfo())
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.framework.boot")))
				.paths(regex("/.*"))
				.build();
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Spring REST Shop Cart API")
				.description("Simple Spring REST Shop Cart using Spring Data with mongoDB")				
				.contact("mjimenez789@gmail.com")								
				.version("0.0.1-SNAPSHOT")
				.build();
	}
}
