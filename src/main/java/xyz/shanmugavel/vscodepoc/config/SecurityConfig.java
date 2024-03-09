package xyz.shanmugavel.vscodepoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import xyz.shanmugavel.vscodepoc.config.security.JwtAuthConverter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    public SecurityConfig(@NonNull JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf( csrf -> csrf.disable())
            .authorizeHttpRequests(authz -> authz
                                            .anyRequest()
                                            .authenticated());
               
        http
            .oauth2ResourceServer( oauth2RS -> oauth2RS.jwt( jwtCustomizer -> jwtCustomizer.jwtAuthenticationConverter(jwtAuthConverter)));
               
        http
            .sessionManagement( sessionManagementCustomizer -> sessionManagementCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

}
