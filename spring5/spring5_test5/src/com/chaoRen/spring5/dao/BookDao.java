package com.chaoRen.spring5.dao;

import com.chaoRen.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void updateBook(Book book);

    void deleteBook(String id);

    Integer selectCount();

    Book findBookInfo(String id);

    List<Book> findBookAll();

    void batchBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
