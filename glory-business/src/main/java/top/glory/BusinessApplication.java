package top.glory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //注册到注册中心
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class);
    }
}
