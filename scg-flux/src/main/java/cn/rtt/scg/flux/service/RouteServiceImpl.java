package cn.rtt.scg.flux.service;

import cn.rtt.scg.flux.domain.entity.RouteInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rtt
 * @date 2025/7/11 15:29
 */
@Service
public class RouteServiceImpl implements RouteService{

    @Override
    public List<RouteInfo> load() {
        RouteInfo routeInfo = new RouteInfo();
        routeInfo.setRouteId("tg");
        routeInfo.setUri("https://www.stats.gov.cn/");
        List<String> predicates = new ArrayList<>();
        predicates.add("Path=/tg");
        routeInfo.setPredicates(predicates);
        List<String> filters = new ArrayList<>();
        filters.add("StripPrefix=1");
        routeInfo.setFilters(filters);
        return List.of(routeInfo);
    }
}
