package cn.rtt.order.dao;

import cn.rtt.core.mybatis.dao.BaseRepository;
import cn.rtt.order.domain.entity.Order;
import cn.rtt.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 * @author rtt
 * @date 2025/6/13 14:12
 */
@Service
public class OrderRepository extends BaseRepository<OrderMapper, Order> {
}
