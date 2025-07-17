package cn.rtt.order.domain.entity;

import cn.rtt.core.mybatis.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author rtt
 * @date 2025/6/13 14:06
 */
@Data
@TableName("`order`")
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity implements Serializable {

    private String orderNo;
    private Long userId;
//    @Version
    private BigDecimal totalAmount;
    private BigDecimal payAmount;
    private BigDecimal discountAmount;
    private Long couponId;
    private Integer status;
    private Date payTime;
    private Date deliveryTime;
    private Date completeTime;
    private String remark;
}
