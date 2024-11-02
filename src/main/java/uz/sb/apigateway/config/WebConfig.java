package uz.sb.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Barcha so'rovlar uchun
                .allowedOrigins("http://localhost:3001", "http://localhost:3000", "http://159.65.119.240:8080") // Faqat belgilangan manzilardan kelgan so'rovlar
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Qabul qilinadigan HTTP usullari
                .allowedHeaders("*"); // Qabul qilinadigan sarlavhalar
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(List.of("http://localhost:3000", "http://159.65.119.240:8080","http://localhost:3001")); // AWS domainini qo'shing
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));  // Ruxsat etilgan metodlar
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept"));  // Ruxsat etilgan sarlavhalar
        corsConfiguration.setExposedHeaders(List.of("Authorization"));  // Javob sarlavhalarini expose qilish
        corsConfiguration.setAllowCredentials(true);  // Cookie yoki auth ma'lumotlarini uzatishga ruxsat

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", corsConfiguration);
        return source;
    }
}