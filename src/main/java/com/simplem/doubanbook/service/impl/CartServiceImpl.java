package com.simplem.doubanbook.service.impl;

import com.simplem.doubanbook.mapper.BookMapper;
import com.simplem.doubanbook.mapper.CartAndBookMapper;
import com.simplem.doubanbook.mapper.CartMapper;
import com.simplem.doubanbook.model.Cart;
import com.simplem.doubanbook.model.CartAndBook;
import com.simplem.doubanbook.service.CartService;
import com.simplem.doubanbook.vo.BookCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: CartServiceImpl
 * Package: com.simplem.doubanbook.service.impl
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 23:25
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartAndBookMapper cartAndBookMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CartMapper cartMapper;

    @Transactional
    @Override
    public String addToCart(int cid, int bid,int num) {
        CartAndBook cartAndBook = cartAndBookMapper.selectByCartIdBookId(cid, bid);
        //获取书的价格
        BigDecimal price = bookMapper.selectPrise(bid);
        //更新购物车的总价格
        BigDecimal n = new BigDecimal(num);
        price = price.multiply(n);
        //根据用传过来的userid和bookid添加到购物车
        if(cartAndBook == null){//没有就新增
            cartAndBookMapper.insertBook(cid,bid,num);
        }else {//有就更新数量
            cartAndBookMapper.updateBookNum(cid,bid,num);
        }
        //更新购物车的总价格
        cartMapper.setPrise(cid,price);
        return "添加成功";
    }

    @Override
    public Cart selectCart(int cid) {
        Cart cart = cartMapper.selectCart(cid);
        cart.setCartNum(cartAndBookMapper.sumBookNum(cid));
        List<Integer> list = cartAndBookMapper.selectBookIds(cid);
        List<BookCart> bookCarts = bookMapper.cart(list);
        cart.setBooks(bookCarts);
        return cart;
    }
}
