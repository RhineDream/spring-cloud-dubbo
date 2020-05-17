package top.glory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//订单
@Entity(name = "orders")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//订单id

    private Integer userid;//用户id
    private String username;//用户名

    private Integer bookid;//商品id
    private String bookname;//商品名称
    private Double price;//商品单价

    private Integer booknum;//购买数量
}