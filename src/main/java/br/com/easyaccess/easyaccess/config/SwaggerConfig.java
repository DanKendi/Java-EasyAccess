package br.com.easyaccess.easyaccess.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "EasyAccess",
                description = "API EasyAccess v2"
        ),
        servers = {@Server(url = "http://localhost:8080",description = "LOCAL"),}
)

public class SwaggerConfig {
}