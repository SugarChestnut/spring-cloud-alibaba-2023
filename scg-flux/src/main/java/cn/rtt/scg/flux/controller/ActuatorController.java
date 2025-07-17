package cn.rtt.scg.flux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rtt
 * @date 2025/7/1 15:27
 */
@RestController
@RequestMapping("/actuator")
public class ActuatorController {

    @RequestMapping
    public String actuator() {
        return "ok";
    }
}
