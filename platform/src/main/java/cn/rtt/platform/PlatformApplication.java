package cn.rtt.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author rtt
 * @date 2025/6/24 10:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class);
    }
}
