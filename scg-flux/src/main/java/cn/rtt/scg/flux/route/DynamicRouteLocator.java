package cn.rtt.scg.flux.route;

import cn.rtt.scg.flux.domain.entity.RouteInfo;
import cn.rtt.scg.flux.service.RouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author rtt
 * @date 2025/7/11 15:20
 */
//@Component
@AllArgsConstructor
public class DynamicRouteLocator implements RouteLocator {

    private final RouteService routeService;

    private final List<RoutePredicateFactory> predicates;

    private final List<GatewayFilterFactory> gatewayFilterFactories;

    private final ObjectMapper objectMapper;

    @Override
    public Flux<Route> getRoutes() {
        List<RouteInfo> routeInfos = routeService.load();
        return Flux.fromIterable(routeInfos)
                .map(this::convertToRoute);
    }

    private Route convertToRoute(RouteInfo routeInfo) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(routeInfo.getRouteId());
        routeDefinition.setUri(URI.create(routeInfo.getUri()));
        routeDefinition.setMetadata(routeInfo.getMetadata());
        routeDefinition.setOrder(routeInfo.getOrder());

        List<String> pl = routeInfo.getPredicates();
        for (String p : pl) {
            try {
                PredicateDefinition predicateDefinition = objectMapper.readValue(p, PredicateDefinition.class);

            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("xx");
            }
        }

        return Route.async(routeDefinition)
                .asyncPredicate(AsyncPredicate.from(exchange -> true))
                .replaceFilters(new ArrayList<>()).build();
    }
}
