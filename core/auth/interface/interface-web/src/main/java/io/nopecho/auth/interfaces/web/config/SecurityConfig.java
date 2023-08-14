package io.nopecho.auth.interfaces.web.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final SecurityProperty securityProperty;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        requestFilter(http);
        oauth2Filter(http);

        disable(http);
        return http.build();
    }

    private void requestFilter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                        .requestMatchers(securityProperty.getIgnorePathArray())
                        .permitAll()
                        .anyRequest()
                .authenticated());
    }

    private void oauth2Filter(HttpSecurity http) throws Exception {
        http.oauth2Login(oath2 -> oath2
                .loginPage("/login/oauth2/fallback")
                .authorizationEndpoint(authorization -> authorization
                        .baseUri("/login/oauth2/authorization")));
    }

    private void disable(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable);
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }
}