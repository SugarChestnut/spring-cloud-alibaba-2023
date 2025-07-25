package cn.rtt.scg.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

/**
 * @author rtt
 * @date 2025/6/11 14:30
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableWebFluxSecurity
public class GatewayFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayFluxApplication.class);
    }
}
