package com.jit.boot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import java.util.Collections;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(basePackage("com.jit.boot.controller"))
				.paths(regex("/rest.*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("WELCOME TO APP", // title
				"SAMPLE DESCRIPTION", // description
				"3.0", // version
				"http://nareshit.in", // URL
				new Contact("JITENDRA", "http://codersbuzz.in", "jitendra@gmail.com"), // developer  information
				"Jit Licence", "http://codersbuzz.in",
				// company information
				Collections.EMPTY_LIST); // clients information
	}
}
