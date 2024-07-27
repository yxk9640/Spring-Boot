package com.restv2.rest_v2;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

//Config
@Configuration
//Enable -> Swagger 3 does not require this
public class SwaggerConfig {

    // Description for your Custom API
    public static final Contact DEFAULT_CONTACT = new Contact().name("Rest Project")
            .url("www.restproject.com")
            .email("yog2797@gmail.com");

    public static final Info DEFAULT_API_INFO = new Info()
            .title("Rest Project Custom API Documentation")
            .description("API Description")
            .version("1.0.0")
            .contact(DEFAULT_CONTACT)
            .license(new License()
                    .name("Apache 2.0")
                    .url("https://www.apache.org/licenses/LICENSE-2.0"));




    @Bean
    public OpenAPI myApi(){
        return new OpenAPI().info(DEFAULT_API_INFO);
    }


}
