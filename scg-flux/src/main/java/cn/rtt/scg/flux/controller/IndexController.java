package cn.rtt.scg.flux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author rtt
 * @date 2025/7/18 09:32
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/test")
    public Mono<String> test() {
        return Mono.just("Ok");
    }
}
