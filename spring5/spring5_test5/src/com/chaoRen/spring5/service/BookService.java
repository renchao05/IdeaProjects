package com.chaoRen.spring5.service;

import com.chaoRen.spring5.dao.BookDao;
import com.chaoRen.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {

    @Value(value = "我是BookService")
    public String name;

    //根据名称进行注入
//    @Resource(name = "bookDaoImpl")
    private BookDao bookDao;

    public void add(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBook(String id) {
        bookDao.deleteBook(id);
    }

    public Integer findCount() {
        return bookDao.selectCount();
    }

    public Book findBookOne(String id) {
        return bookDao.findBookInfo(id);
    }

    public List<Book> findAll() {
        return bookDao.findBookAll();
    }

    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchBook(batchArgs);
    }

    public void batchUpdate(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    public void batchDelete(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }
}
