package cn.rtt.order.domain.entity;

import cn.rtt.core.mybatis.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author rtt
 * @date 2025/6/13 15:24
 */
@TableName("order_item")
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderItem extends BaseEntity {

    private Long orderId;
    private String orderNo;
    private Long productId;
    private String productName;
    private String productImage;
    private Long skuId;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;

}
