package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.CartAndBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * ClassName: AddBookToCart
 * Package: com.simplem.doubanbook.mapper
 * Description：
 * Author: simpleM
 * Date: 2020/11/24 11:18
 */
@SpringBootTest
class AddBookToCart {
    @Autowired
    private CartAndBookMapper cartAndBookMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CartMapper cartMapper;
    @Test
    void test(){
        int cid = 1;
        int bid = 1;
        CartAndBook cartAndBook = cartAndBookMapper.selectByCartIdBookId(cid, bid);
        //获取书的价格
        BigDecimal price = bookMapper.selectPrise(bid);
        //根据用传过来的userid和bookid添加到购物车
        if(cartAndBook == null){//没有就新增
            cartAndBookMapper.insertBook(cid,bid);
        }else {//有就更新数量
            cartAndBookMapper.updateBookNum(cid,bid);
        }
        //更新购物车的总价格
        cartMapper.setPrise(cid,price);
    }
}
