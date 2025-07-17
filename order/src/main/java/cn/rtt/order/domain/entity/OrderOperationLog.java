package cn.rtt.order.domain.entity;

import cn.rtt.core.mybatis.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author rtt
 * @date 2025/6/13 15:26
 */
@TableName("order_operation_log")
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderOperationLog extends BaseEntity {

    private Long orderId;
    private String operator;
    private String action;
    private String note;

}
