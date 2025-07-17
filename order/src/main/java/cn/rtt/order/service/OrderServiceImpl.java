package cn.rtt.order.service;

import cn.hutool.core.util.RandomUtil;
import cn.rtt.order.dao.OrderOperationLogRepository;
import cn.rtt.order.dao.OrderRepository;
import cn.rtt.order.domain.entity.Order;
import cn.rtt.order.domain.entity.OrderOperationLog;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author rtt
 * @date 2025/6/13 15:31
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final OrderOperationLogRepository orderOperationLogRepository;

    private final IdGeneratorService idGeneratorService;

    @Override
    @Transactional
    public void placeOrder() {
        long userId = RandomUtil.randomInt();
        Order order = new Order();
        order.setOrderNo(idGeneratorService.generate(userId));
        order.setUserId(userId);
        order.setTotalAmount(BigDecimal.valueOf(100));
        order.setDiscountAmount(BigDecimal.valueOf(10));
        order.setPayAmount(BigDecimal.valueOf(90));
        order.setCouponId(1314L);
        order.setStatus(1);
        order.setPayTime(new Date());
        order.setDeliveryTime(new Date());
        order.setCompleteTime(new Date());
        orderRepository.save(order);
        log(order.getId());
    }

    private void log(Long orderId) {
        OrderOperationLog orderOperationLog = new OrderOperationLog();
        orderOperationLog.setOrderId(orderId);
        orderOperationLog.setOperator("用户");
        orderOperationLog.setAction("下单");
        orderOperationLog.setNote("无");
        orderOperationLogRepository.save(orderOperationLog);
        throw new RuntimeException("test");
    }
}
