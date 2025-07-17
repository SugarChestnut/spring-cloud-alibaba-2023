package cn.rtt.scg.flux.service;

import cn.rtt.scg.flux.domain.entity.RouteInfo;

import java.util.List;

/**
 * @author rtt
 * @date 2025/7/11 15:29
 */
public interface RouteService {

    List<RouteInfo> load();
}
