package cn.rtt.scg.flux.route.predicate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

/**
 * @author rtt
 * @date 2025/7/4 10:44
 */
public class AuthRoutePredicateFactory implements RoutePredicateFactory<AuthRoutePredicateFactory.Config> {

    private static final Log log = LogFactory.getLog(AuthRoutePredicateFactory.class);

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return null;
    }

    public static class Config {

    }
}
