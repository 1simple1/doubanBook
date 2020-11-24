package com.simplem.doubanbook.controller;

import com.alibaba.fastjson.JSON;
import com.simplem.doubanbook.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String addBookToCart(@RequestParam("userId") int cid,
                                @RequestParam("bookId") int bid) {
        String s = cartService.addToCart(cid, bid);
        s = JSON.toJSONString(s);
        return s;
    }
}
