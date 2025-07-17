package cn.rtt.scg.flux.route.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;

/**
 * @author rtt
 * @date 2025/7/4 10:45
 */
public class AuthGatewayFilterFactory implements GatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    public static class Config {

    }
}
