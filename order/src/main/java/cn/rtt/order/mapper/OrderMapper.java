package cn.rtt.order.mapper;

import cn.rtt.order.domain.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author rtt
 * @date 2025/6/13 14:10
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
