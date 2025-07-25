//package cn.rtt.scg.mvc.route;
//
//import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
//import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.RouterFunctions;
//import org.springframework.web.servlet.function.ServerResponse;
//
///**
// * @author rtt
// * @date 2025/6/17 10:06
// */
//public class RouteConfiguration {
//
//    @Bean
//    public RouterFunction<ServerResponse> getRoute() {
//        /*
//            如果 http() 中不设置uri，那么从请求头中获取，org.springframework.cloud.gateway.server.mvc.common.MvcUtils.GATEWAY_REQUEST_URL_ATTR
//            如果设置了 uri，那么将 uri 设置到请求头中
//         */
//        return RouterFunctions.route()
//                .GET("/demo", HandlerFunctions.http("http://localhost:8080/"))
//                .before(BeforeFilterFunctions.requestHeaderToRequestUri(""))
//                .build();
//    }
//}
