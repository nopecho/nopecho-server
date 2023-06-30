package io.nopecho.auth.adapters.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperty {

    private List<String> ignorePaths;

    public String[] getIgnorePathArray() {
        return this.ignorePaths.toArray(new String[0]);
    }
}
