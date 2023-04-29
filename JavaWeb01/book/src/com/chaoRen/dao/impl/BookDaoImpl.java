package com.chaoRen.dao.impl;

import com.chaoRen.dao.BookDao;
import com.chaoRen.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) value(?,?,?,?,?,?)";
        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),
                book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(), book.getPrice(),
                book.getSales(), book.getStock(), book.getImg_path(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id=?";
        return querySingle(sql, Book.class, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryMulti(sql, Book.class);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        return Integer.parseInt(queryScalar(sql));
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from t_book limit ?,?";
        return queryMulti(sql,Book.class,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min,int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        return Integer.parseInt(queryScalar(sql,min,max));
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize,int min,int max) {
        String sql = "select * from t_book where price between ? and ? order by price limit ?,?";
        return queryMulti(sql,Book.class,min,max,begin,pageSize);
    }
}
