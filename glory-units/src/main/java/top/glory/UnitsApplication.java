package top.glory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UnitsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UnitsApplication.class);
    }
}
