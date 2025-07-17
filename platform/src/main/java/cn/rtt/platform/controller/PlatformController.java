package cn.rtt.platform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rtt
 * @date 2025/6/24 11:03
 */
@RestController
@RequestMapping("/platform")
public class PlatformController {

    @RequestMapping("/version")
    public String version() {
        return "1.0";
    }

}
