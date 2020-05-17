package top.glory.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.glory.entity.Book;
import top.glory.service.BooKService;

@RestController
public class TestController {

    @Reference
    private BooKService booKService;

    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }


    @RequestMapping("/testDubbo")
    public Book testDubbo(){
        Book book = booKService.getBookById(2);
        return book;
    }
}
