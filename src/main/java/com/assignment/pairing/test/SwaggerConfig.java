//package com.assignment.pairing.test;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.google.common.base.Predicate;
//
//import springfox.documentation.RequestHandler;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//	@SuppressWarnings("unchecked")
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis((Predicate<RequestHandler>) RequestHandlerSelectors
//						.basePackage("com.assignment.pairing.test.controller"))
//				.paths((Predicate<String>) PathSelectors.any()).build().apiInfo(apiInfo());
//	}
//
//	@SuppressWarnings("deprecation")
//	private ApiInfo apiInfo() {
//	     ApiInfo apiInfo = new ApiInfo(
//	                "My Apps API Title",
//	                "My Apps API Description",
//	                "My Apps API Version",
//	                "My Apps API terms of service",
//	                "My Apps API Contact Email",
//	                "My Apps API Licence Type",
//	                "My Apps API License URL"
//	        );
//	        return apiInfo;
//	    }
//	}
//	
