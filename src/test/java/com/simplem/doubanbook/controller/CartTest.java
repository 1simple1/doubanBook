package com.simplem.doubanbook.controller;

import com.simplem.doubanbook.service.BookService;
import com.simplem.doubanbook.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: CartTest
 * Package: com.simplem.doubanbook.controller
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 23:55
 */
@SpringBootTest
public class CartTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private CartService cartService;

    @Test
    private void addToCartTest(){
        int bookid = 1;
        bookService.selectById(bookid);
    }
}
