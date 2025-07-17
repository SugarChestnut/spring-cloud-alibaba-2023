package cn.rtt.order.dao;

import cn.rtt.core.mybatis.dao.BaseRepository;
import cn.rtt.order.domain.entity.OrderItem;
import cn.rtt.order.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

/**
 * @author rtt
 * @date 2025/6/13 15:27
 */
@Service
public class OrderItemRepository extends BaseRepository<OrderItemMapper, OrderItem> {
}
