package com.simplem.doubanbook.service.impl;

import com.simplem.doubanbook.mapper.BookMapper;
import com.simplem.doubanbook.model.Book;
import com.simplem.doubanbook.service.BookService;
import com.simplem.doubanbook.vo.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: BookServiceImpl
 * Package: com.simplem.doubanbook.service
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 14:34
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public int insert(Book book) {
        return bookMapper.insert(book);
    }

    @Override
    public int updateDetail(int id,Book book) {
        return bookMapper.updateDetail(id,book);
    }

    @Override
    public BookDetail selectById(int id) {
        return bookMapper.selectById(id);
    }


}
