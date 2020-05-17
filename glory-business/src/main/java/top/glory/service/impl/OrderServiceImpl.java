package top.glory.service.impl;

import com.google.gson.Gson;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import top.glory.dao.OrderDao;
import top.glory.entity.Book;
import top.glory.entity.Order;
import top.glory.service.BooKService;
import top.glory.service.OrderService;

import javax.annotation.Resource;

@Slf4j
@Service    //这里使用spring注解
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Reference
    private BooKService booKService;

    @Override
    public Order saveOrderInfo(Order order) {
        return orderDao.save(order);
    }

    @Override
    @GlobalTransactional
    public Order saveOrderInfo2(Integer bookId) {
        Book book = booKService.getBookById(bookId);
        if(book == null){
            Order order = new Order();
            order.setBookname("下单失败");
            return order;
        }
        log.info("图书信息:" + new Gson().toJson(book));

        Integer num = 2;

        Order order = new Order();
        order.setId(1);
        order.setUsername("测试用户");
        order.setUserid(1);
        order.setBookid(book.getId());
        order.setBookname(book.getBookname());
        order.setPrice(book.getPrice());
        order.setBooknum(num);

        orderDao.save(order);


        int i = 1 / 0;

        //减库存
        booKService.inventoryBookStock(bookId,num);

        return order;
    }
}
