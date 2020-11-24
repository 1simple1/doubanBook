package com.simplem.doubanbook.service;

import com.simplem.doubanbook.model.Book;

import java.util.List;

/**
 * ClassName: BookService
 * Package: com.simplem.doubanbook.service
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 14:34
 */
public interface BookService {
    List<Book> selectAll();

    Book selectById(int id);

    int insert(Book book);

    int updateDetail(int id,Book book);

    List<Book> cart(List<Integer> ids);
}
