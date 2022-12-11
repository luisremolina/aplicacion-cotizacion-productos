package com.cotizacion.aplicacioncotizacionproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AplicacionCotizacionProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AplicacionCotizacionProductosApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/usuarios/**")
                 .allowedOrigins("http://localhost:63342")
                 .allowedMethods("GET", "POST", "PUT", "ELETE")
                 .maxAge(3600);
                 }
                 };
                 }

}
