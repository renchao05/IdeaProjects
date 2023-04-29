package com.chaoRen.test;

import com.chaoRen.pojo.Book;
import com.chaoRen.pojo.Page;
import com.chaoRen.service.BookService;
import com.chaoRen.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();

    @Test
    void addBook() {
     bookService.addBook(new Book(null, "任超自传2", "renChao", new BigDecimal("1888.8"), 18, 23, null));
    }

    @Test
    void deleteBookById() {
        for (int i = 24; i < 33; i++) {
            bookService.deleteBookById(i);
        }

    }

    @Test
    void updateBook() {
        Book book = bookService.queryBookById(23);
        book.setAuthor("大超");
        book.setPrice(new BigDecimal("9888.00"));
        bookService.updateBook(book);
    }

    @Test
    void queryBookById() {
    }

    @Test
    void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(2, 4);
        System.out.println(page);
    }

    @Test
    void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(2, 4, 60, 90);
        System.out.println(page.getItems());
    }
}