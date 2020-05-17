package top.glory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.glory.entity.Book;
import top.glory.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
