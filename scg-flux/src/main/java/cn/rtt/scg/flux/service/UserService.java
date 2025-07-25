package cn.rtt.scg.flux.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author rtt
 * @date 2025/7/24 11:18
 */
public interface UserService extends ReactiveUserDetailsService {

    UserDetails getUser(String username);
}
