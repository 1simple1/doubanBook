package com.simplem.doubanbook.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplem.doubanbook.model.Book;
import com.simplem.doubanbook.service.BookService;
import com.simplem.doubanbook.service.CartAndBookService;
import com.simplem.doubanbook.vo.BookDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: BookController
 * Package: com.simplem.doubanbook.controller
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 14:35
 */
@CrossOrigin
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CartAndBookService cartAndBookService;

    //返回图书详情信息
    @RequestMapping("/book")
    public String showBook(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "10") int size) {
        PageHelper.startPage(pageNum, size);
        List<Book> books = bookService.selectAll();
        PageInfo<Book> bookPageInfo = new PageInfo<>(books);
        String s = JSON.toJSONString(bookPageInfo);
        return s;
    }

    //返回图书详情信息
    @RequestMapping("/book/{id}")
    public String bookDetail(@PathVariable int id,
                             @RequestParam(defaultValue = "1") int userId) {
        BookDetail bookDetail = bookService.selectById(id);
        bookDetail.setCartNum(cartAndBookService.sumBookNum(userId));
        String s = JSON.toJSONString(bookDetail);
        return s;
    }

}
