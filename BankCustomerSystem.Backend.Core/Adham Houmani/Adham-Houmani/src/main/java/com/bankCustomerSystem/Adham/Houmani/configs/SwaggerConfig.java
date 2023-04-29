//package com.bankCustomerSystem.Adham.Houmani.configs;
//
//import com.fasterxml.classmate.TypeResolver;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.AlternateTypeRules;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.time.LocalDate;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket apiDocket() {
//        TypeResolver typeResolver = new TypeResolver();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .alternateTypeRules(AlternateTypeRules.newRule(LocalDate.class, Date.class))
//                .alternateTypeRules(AlternateTypeRules.newRule(
//                        typeResolver.resolve(List.class, LocalDate.class),
//                        typeResolver.resolve(List.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.bankCustomerSystem.Adham.Houmani"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(getApiInfo());
//        return docket;
//    }
//
//
//    private ApiInfo getApiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Docca",
//                "Doctor Management System",
//                "1.0",
//                "Terms of Service",
//                null,
//                "",
//                "",
//                Collections.emptyList());
//        return apiInfo;
//    }
//
//
//}
//
