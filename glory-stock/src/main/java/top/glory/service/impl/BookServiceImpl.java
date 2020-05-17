package top.glory.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.glory.dao.BooKDao;
import top.glory.entity.Book;
import top.glory.service.BooKService;

@Service    //注意，需要使用dubbo的service注解
public class BookServiceImpl implements BooKService {

    @Autowired
    private BooKDao bookDao;

    @Override
    public Book getBookById(Integer id) {
        return bookDao.findById(id).get();
    }

    @Override
    public void inventoryBookStock(Integer bookId, Integer num) {
        Book book = bookDao.findById(bookId).get();
        Integer stocknum = book.getStocknum();
        book.setStocknum(stocknum - num);

        bookDao.save(book);
    }
}
