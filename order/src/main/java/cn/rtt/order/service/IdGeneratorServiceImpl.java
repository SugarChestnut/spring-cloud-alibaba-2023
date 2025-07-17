package cn.rtt.order.service;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * @author rtt
 * @date 2025/6/13 16:38
 */
@Service
public class IdGeneratorServiceImpl implements IdGeneratorService {

    /**
     * 前13位，前几位为递增序列
     * 比如说：
     * 前几位每天递增1
     * 中间几位再包含一些其他特征信息
     *
     * @param userId 用户id
     * @return 订单id
     */
    @Override
    public String generate(long userId) {
        // 前5位为某一时间点的到现在的天数
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        Date time = calendar.getTime();
        long day = (new Date().getTime() - time.getTime()) / (24 * 60 * 60 * 1000);
        return fillZero(day, 5) + "0000000001" + fillZero(userId, 5);
    }

    private String fillZero(long d, int len) {
        String s = String.valueOf(d);
        if (s.length() < len) return StrUtil.fillBefore(s, '0', len - s.length());
        return s.substring(s.length() - 5);
    }
}
