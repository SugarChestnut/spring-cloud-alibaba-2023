package cn.rtt.scg.flux.configuration;

import org.checkerframework.checker.units.qual.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManagerAdapter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author rtt
 * @date 2025/7/22 11:30
 */
@Import(AuthenticationConfiguration.class)
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http,
                                                         ReactiveAuthenticationManager authenticationManager) {

        // 认证
        http.authenticationManager(authenticationManager);

        // 授权
        http.authorizeExchange(authorizeExchangeSpec -> {
            authorizeExchangeSpec.pathMatchers("/index/test").permitAll();
            // 添加自定义认证管理器
            authorizeExchangeSpec.anyExchange().access(new CustomReactiveAuthorizationManager());
        });

        http.exceptionHandling(exceptionHandlingSpec -> {
            exceptionHandlingSpec.accessDeniedHandler(new ServerAccessDeniedHandler() {
                @Override
                public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException denied) {
                    return null;
                }
            });
            exceptionHandlingSpec.authenticationEntryPoint();
        });

        // 配置http基础认证
        http.httpBasic(httpBasicSpec -> {});

        http.formLogin(formLoginSpec -> {});

        http.cors(corsSpec -> corsSpec.configurationSource(exchange -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
            corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
            corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
            return corsConfiguration;
        }));

        http.csrf(ServerHttpSecurity.CsrfSpec::disable);

        return http.build();
    }

    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager(AuthenticationManager authenticationManager) {
        // 里面切换了执行线程，适用于如数据库等耗时的操作，防止阻塞
        return new ReactiveAuthenticationManagerAdapter(authenticationManager);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * 实际在使用时，DelegatingPasswordEncoder 也是默认使用的这个
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
