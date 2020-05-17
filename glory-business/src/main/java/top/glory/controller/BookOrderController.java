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
public class BookOrderController {

    @Reference
    private BooKService booKService;
    @Resource
    private OrderService orderService;


    //RocketMQ
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    //买一本书
    @GetMapping("/book/order/{bookId}")
    public Order order(@PathVariable("bookId") Integer bookId) {

        Book book = booKService.getBookById(bookId);
        if(book == null){
            Order order = new Order();
            order.setBookname("下单失败");
            return order;
        }
        log.info("图书信息:" + new Gson().toJson(book));

        Order order = new Order();
        order.setId(1);
        order.setUsername("测试用户");
        order.setUserid(1);
        order.setBookid(book.getId());
        order.setBookname(book.getBookname());
        order.setPrice(book.getPrice());
        order.setBooknum(1);
        Order orderResult = orderService.saveOrderInfo(order);
        System.out.println(orderResult);
        //下单成功之后,将消息放到mq中
        rocketMQTemplate.convertAndSend("book-order-topic", order);

        return order;

    }
}
