package com.chaoRen.test;

import com.chaoRen.dao.BookDao;
import com.chaoRen.dao.impl.BookDaoImpl;
import com.chaoRen.pojo.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;


class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    void addBook() {
        bookDao.addBook(new Book(null, "任超自传", "任超", new BigDecimal("88.8"), 48, 0, null));
    }

    @Test
    void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    void updateBook() {
        Book book = bookDao.queryBookById(22);
        book.setStock(60);
        book.setPrice(new BigDecimal("188.88"));
        System.out.println(bookDao.updateBook(book));
    }

    @Test
    void queryBookById() {
        Book book = bookDao.queryBookById(22);
        System.out.println(book);
    }

    @Test
    void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void queryForPageTotalCount() {
        Integer integer = bookDao.queryForPageTotalCount();
        System.out.println(integer);
    }

    @Test
    void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(0, 5);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void queryForPageTotalCountByPrice() {
        Integer integer = bookDao.queryForPageTotalCountByPrice(60,90);
        System.out.println(integer);
    }

    @Test
    void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(0, 4,60,90);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}