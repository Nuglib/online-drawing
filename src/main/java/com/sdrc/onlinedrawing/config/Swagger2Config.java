package com.sdrc.onlinedrawing.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        List<Parameter> pars = new ArrayList<Parameter>();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线编辑图片 RESTful API")
                .description("展示先做基础功能，后面再添加业务")
//                .termsOfServiceUrl("https://www.cnblogs.com/xiebq/")
                .version("1.0")
                .build();
    }

    public static Docket initDocket() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<springfox.documentation.service.Parameter> parameters = new ArrayList<>();
        parameterBuilder.name("Authorization").description("token").modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();
        parameters.add(parameterBuilder.build());

        Docket docket = new Docket(DocumentationType.SWAGGER_2).select()

                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build()
                .globalOperationParameters(parameters);
        return docket;
    }
}
