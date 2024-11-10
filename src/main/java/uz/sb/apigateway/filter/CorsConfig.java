package uz.sb.apigateway.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("*"); // All origins are allowed
        config.addAllowedHeader("*"); // All headers are allowed
        config.addAllowedMethod("*"); // All HTTP methods are allowed

        source.registerCorsConfiguration("/**", config); // Apply CORS configuration to all paths
        return new CorsFilter(source);
    }
}
