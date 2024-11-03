package uz.sb.apigateway.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(Environment environment) throws UnknownHostException, UnknownHostException {

        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        String port = environment.getProperty("local.server.port", "8080"); // 8080 - standart port agar topilmasa

        String gatewayUrl = "http://" + hostAddress + ":" + port + "/api";

        return new OpenAPI()
                .addServersItem(new Server().url(gatewayUrl));
    }
}