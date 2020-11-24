package com.simplem.doubanbook.controller;

import com.alibaba.fastjson.JSON;
import com.simplem.doubanbook.model.Cart;
import com.simplem.doubanbook.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: CartController
 * Package: com.simplem.doubanbook.controller
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 23:27
 */
@CrossOrigin
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    //将图书添加到购物车
    @RequestMapping("/addToCart")
    public String addBookToCart(@RequestParam(defaultValue = "1") int userId,
                                @RequestParam("bookId") int bid,
                                @RequestParam("bookNum") int bookNum) {
        String s = cartService.addToCart(userId, bid, bookNum);
        s = JSON.toJSONString(s);
        return s;
    }

    @RequestMapping("/cart")
    public String cart(@RequestParam(defaultValue = "1") int userId) {
        Cart cart = cartService.selectCart(userId);
        String s = JSON.toJSONString(cart);
        return s;
    }

    @RequestMapping("/cart/removeAll")
    public String removeAll(){

        return null;
    }


}
