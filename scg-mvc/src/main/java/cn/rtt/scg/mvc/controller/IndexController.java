package cn.rtt.scg.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rtt
 * @date 2025/7/18 15:02
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/test")
    public String test() {
        return "Ok";
    }
}
