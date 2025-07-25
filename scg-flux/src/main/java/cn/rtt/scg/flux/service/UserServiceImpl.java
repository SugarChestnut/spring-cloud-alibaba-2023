package cn.rtt.scg.flux.service;

import cn.rtt.scg.flux.domain.pojo.SysUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author rtt
 * @date 2025/7/24 11:18
 */
public class UserServiceImpl implements UserService{

    private final Scheduler scheduler = Schedulers.boundedElastic();

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.just(username).subscribeOn(scheduler).map(this::getUser);
    }

    @Override
    public UserDetails getUser(String username) {
        SysUserDetails sysUserDetails = new SysUserDetails();
        sysUserDetails.setUsername(username);
        sysUserDetails.setPassword("$2a$12$i5W2ctnny6DA/CGvSZTwAOHCgzKzLtCPJsfMDzEfzfQilkAP96bdq");
        return sysUserDetails;
    }
}
