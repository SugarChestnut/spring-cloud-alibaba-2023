package cn.rtt.scg.flux.domain.entity;

import cn.rtt.core.mybatis.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author rtt
 * @date 2025/7/11 15:30
 */
@Data
@TableName("route_info")
@EqualsAndHashCode(callSuper = true)
public class RouteInfo extends BaseEntity implements Serializable {

    private String routeId;

    private String uri;

    private Integer order = 0;

    private Map<String, Object> metadata;

    private List<String> predicates;

    private List<String> filters;

}
