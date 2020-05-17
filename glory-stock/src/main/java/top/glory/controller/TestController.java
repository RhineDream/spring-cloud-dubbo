package top.glory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/stock/api1/demo1")
    public String demo1() {
        return "demo1";
    }

    @RequestMapping("/stock/api1/demo2")
    public String demo2() {
        return "demo2";
    }

    @RequestMapping("/stock/api2/demo1")
    public String demo3() {
        return "demo3";
    }

    @RequestMapping("/stock/api2/demo2")
    public String demo4() {
        return "demo4";
    }

    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }
}
