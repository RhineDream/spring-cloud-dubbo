package top.glory;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class RocketMqSendMsg {

    //生产发送消息
    public static void main(String[] args) throws Exception {
        //1.创建消息生产者,并且设置生产组名
        DefaultMQProducer producer = new DefaultMQProducer("my-prod-group");

        //2 设置生产者NameServer的地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        //3 启动生产者
        producer.start();
        System.out.println("生产者已启动-----------");

        //4 构建消息对象,主要是设置消息的主题/标签/内容
        Message message = new Message("firstTopic", "firstTag", ("这是我的rocketmq发送的消息").getBytes());

        //5 发送消息 第二个参数代表超时时间
        SendResult result = producer.send(message, 10000);
        System.out.println("发送的消息："+result);

        //6 关闭生产者
        producer.shutdown();

    }
}