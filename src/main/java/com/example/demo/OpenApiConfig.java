package com.example.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.PathItem;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("HYPHEN 펌뱅킹 API")
                        .description("하이픈 코퍼레이션 펌뱅킹 Open API 입니다")
                        .version("1.0.0"));
    }

    @Bean
    public OpenApiCustomizer tagsOrderCustomizer() {
        return openApi -> {
            List<Tag> tags = Arrays.asList(
                    new Tag().name("펌뱅킹 API").description("펌뱅킹 api 입니다"),
                    new Tag().name("송금대행 API").description("송금대행 api 입니다"),
                    new Tag().name("ARS API").description("ARS api 입니다"),
                    new Tag().name("기타 API").description("기타 api 입니다")
            );
            openApi.setTags(tags);
        };
    }

    @Bean
    public OpenApiCustomizer pathsOrderCustomizer() {
        return openApi -> {
            Paths paths = openApi.getPaths();
            if (paths != null) {
                // 펌뱅킹 API 경로 정렬
                Map<String, PathItem> sortedPaths = new LinkedHashMap<>();
                sortedPaths.put("/rfb/bankstart", paths.remove("/rfb/bankstart"));
                sortedPaths.put("/rfb/deposit", paths.remove("/rfb/deposit"));
                sortedPaths.put("/rfb/withdraw", paths.remove("/rfb/withdraw"));
                sortedPaths.put("/rfb/account/registration", paths.remove("/rfb/account/registration"));
                sortedPaths.put("/rfb/account/accountname", paths.remove("/rfb/account/accountname"));
                sortedPaths.put("/rfb/inquiry/summary", paths.remove("/rfb/inquiry/summary"));
                sortedPaths.put("/rfb/inquiry/transfer", paths.remove("/rfb/inquiry/transfer"));
                sortedPaths.put("/rfb/inquiry/balance", paths.remove("/rfb/inquiry/balance"));


                // 송금대행 API 경로 정렬
                sortedPaths.put("/rfb/retail/deposit", paths.remove("/rfb/retail/deposit"));
                sortedPaths.put("/rfb/retail/account/accountname", paths.remove("/rfb/retail/account/accountname"));
                sortedPaths.put("/rfb/retail/inquiry/transfer", paths.remove("/rfb/retail/inquiry/transfer"));
                sortedPaths.put("/rfb/retail/inquiry/range/transfer", paths.remove("/rfb/retail/inquiry/range/transfer"));
                sortedPaths.put("/rfb/retail/inquiry/balance", paths.remove("/rfb/retail/inquiry/balance"));

                // ARS API 경로 정렬
                sortedPaths.put("/ksnet/auth/account", paths.remove("/ksnet/auth/account"));
                sortedPaths.put("/ksnet/auth/ars1", paths.remove("/ksnet/auth/ars1"));
                sortedPaths.put("/ksnet/auth/ars1_2", paths.remove("/ksnet/auth/ars1_2"));
                sortedPaths.put("/ksnet/auth/ars2", paths.remove("/ksnet/auth/ars2"));
                sortedPaths.put("/ksnet/auth/ars3", paths.remove("/ksnet/auth/ars3"));
                sortedPaths.put("/ksnet/auth/ars3_2", paths.remove("/ksnet/auth/ars3_2"));
                sortedPaths.put("/ksnet/auth/ars4", paths.remove("/ksnet/auth/ars4"));
                sortedPaths.put("/ksnet/auth/ars/prf", paths.remove("/ksnet/auth/ars/prf"));
                sortedPaths.put("/ksnet/auth/ars/prf/inquiry", paths.remove("/ksnet/auth/ars/prf/inquiry"));

                sortedPaths.put("/etc/parse", paths.remove("/etc/parse"));
                sortedPaths.put("/etc/jtom", paths.remove("/etc/jtom"));


                paths.forEach(sortedPaths::putIfAbsent);

                Paths newPaths = new Paths();
                sortedPaths.forEach(newPaths::addPathItem);

                openApi.setPaths(newPaths);
            }
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/static/swagger-ui.html");
        registry.addResourceHandler("/swagger-custom.css")
                .addResourceLocations("classpath:/static/swagger-custom.css");
    }
}

