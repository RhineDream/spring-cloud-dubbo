package top.glory.massage;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import top.glory.entity.Order;

@Slf4j
@Service("unitMsgService")  //不加会重复         //spring的注解
@RocketMQMessageListener(consumerGroup = "unit-msg", topic = "book-order-topic")
public class MsgService implements RocketMQListener<Order> {
    @Override
    public void onMessage(Order order) {
        log.info("收到一个订单信息{}", JSON.toJSONString(order));
    }
}