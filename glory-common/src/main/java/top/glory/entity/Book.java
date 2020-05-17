package top.glory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//图书
@Entity(name = "book")
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//主键

    private String bookname;//图书名称
    private Double price;//图书价格
    private Integer stocknum;//图书库存
}
