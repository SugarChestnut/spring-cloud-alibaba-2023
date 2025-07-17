package cn.rtt.scg.flux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.InMemoryRouteDefinitionRepository;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author rtt
 * @date 2025/6/12 13:59
 */
@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    private final InMemoryRouteDefinitionRepository repository;

    @RequestMapping("/list")
    public Flux<String> getRoutes() {
        return repository.getRouteDefinitions()
                .flatMap(r -> Mono.just(r.toString()));
    }

    @RequestMapping("/add")
    public Mono<Void> addRoute() {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId("test");
        routeDefinition.setUri(URI.create("http://www.baidu.com"));
//        routeDefinition.setMetadata();

        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName("Path");
        predicateDefinition.setArgs(new HashMap<>(){{ put(NameUtils.generateName(1), "/baidu");}});
        routeDefinition.getPredicates().add(predicateDefinition);

        FilterDefinition filterDefinition = new FilterDefinition("StripPrefix=1");
        routeDefinition.getFilters().add(filterDefinition);

        return repository.save(Mono.just(routeDefinition));
    }
}
