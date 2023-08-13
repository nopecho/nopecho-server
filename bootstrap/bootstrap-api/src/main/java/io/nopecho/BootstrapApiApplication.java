package io.nopecho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.nopecho")
public class BootstrapApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootstrapApiApplication.class, args);
    }
}
