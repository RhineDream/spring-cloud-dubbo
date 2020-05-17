package top.glory.service;

import top.glory.entity.Order;

public interface OrderService {

    Order saveOrderInfo(Order order);

    Order saveOrderInfo2(Integer bookId);
}
