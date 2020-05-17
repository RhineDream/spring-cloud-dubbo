package top.glory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.glory.entity.Book;

public interface BooKDao extends JpaRepository<Book, Integer> {
}
