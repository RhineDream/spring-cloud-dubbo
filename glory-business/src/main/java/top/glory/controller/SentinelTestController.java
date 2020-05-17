package top.glory.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelTestController {

    int flag = 0;

    @RequestMapping("/test/msg1")
    public String msg1() throws InterruptedException {
//        Thread.sleep(10);
        flag ++ ;
        if(flag % 3 == 0){
            throw new RuntimeException();
        }
        return "this is msg one!";
    }

    @RequestMapping("/test/msg2")
    public String msg2(){
        return "this is msg one2";
    }

    @RequestMapping("/test/msg3")
    @SentinelResource("message3")//注意这里必须使用这个注解标识,热点规则不生效
    public String msg3(String name ,Integer age){
        return "姓名："+name+"--年龄："+age;
    }

}
