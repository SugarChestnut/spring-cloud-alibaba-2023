package cn.rtt.scg.flux.route;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 * @author rtt
 * @date 2025/6/17 09:03
 */
//@Configuration
public class RouteConfiguration {

    /**
     * {@link org.springframework.cloud.gateway.route.RouteDefinitionRouteLocator}
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("xx", r -> r.host("").and().uri(""))
                .build();
    }
}
