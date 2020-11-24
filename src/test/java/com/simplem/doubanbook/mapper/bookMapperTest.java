package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: bookMapperTest
 * Package: com.simplem.doubanbook.mapper
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 9:28
 */
@SpringBootTest
public class bookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CartAndBookMapper cartAndBookMapper;

    @Test
    public void cartTest(){
        List<Integer> bookList = new ArrayList<>();
        bookList.add(1);
        bookList.add(3);
        List<Book> cart = bookMapper.cart(bookList);
        for (Book book : cart) {
            System.out.println(book);
        }
    }


}
