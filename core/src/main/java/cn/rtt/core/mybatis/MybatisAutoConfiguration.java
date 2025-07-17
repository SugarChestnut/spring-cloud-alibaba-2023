package cn.rtt.core.mybatis;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusInnerInterceptorAutoConfiguration;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * @author rtt
 * @date 2025/6/13 10:27
 */
@AutoConfiguration(
        before = {
                MybatisPlusInnerInterceptorAutoConfiguration.class
        }
)
public class MybatisAutoConfiguration {

    /**
     * 通用字段自动填充配置
     */
    @Bean
    @ConditionalOnClass({MetaObjectHandler.class})
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                this.strictInsertFill(metaObject, "gmtCreate", Date.class, new Date());
                this.strictInsertFill(metaObject, "gmtModified", Date.class, new Date());
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.strictUpdateFill(metaObject, "gmtModified", Date.class, new Date());
            }
        };
    }

    /**
     * 插件配置
     */
    @Bean
    @ConditionalOnClass({PaginationInnerInterceptor.class, MybatisPlusInterceptor.class})
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
