package top.glory.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

//用户
@Entity(name = "user")//实体类跟数据表的对应
@Data//不再去写set和get方法
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增

    private Integer id;//主键
    private String username;//用户名
    private String password;//密码
    private String phone;//手机号
    private Date birthday;//生日
}