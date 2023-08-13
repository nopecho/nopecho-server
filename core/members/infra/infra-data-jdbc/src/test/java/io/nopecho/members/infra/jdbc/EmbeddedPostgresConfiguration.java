package io.nopecho.members.infra.jdbc;

import io.zonky.test.db.provider.postgres.PostgreSQLContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class EmbeddedPostgresConfiguration {

    @Bean
    public PostgreSQLContainerCustomizer postgresContainerCustomizer() {
        return container -> container
                .withStartupTimeout(Duration.ofSeconds(60L))
                .setDockerImageName("postgres:13-alpine");
    }
}