package top.glory.controller;


import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.glory.entity.Book;
import top.glory.entity.Order;
import top.glory.service.BooKService;
import top.glory.service.OrderService;

import javax.annotation.Resource;

@Slf4j
@RestController
public class BookOrderController2 {


    @Resource
    private OrderService orderService;

    //买一本书
    @GetMapping("/book/order2/{bookId}")
    public Order order(@PathVariable("bookId") Integer bookId) {
        Order order = orderService.saveOrderInfo2(bookId);
        return order;
    }
}
