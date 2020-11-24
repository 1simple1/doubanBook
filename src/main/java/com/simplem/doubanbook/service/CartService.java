package com.simplem.doubanbook.service;

import com.simplem.doubanbook.model.Cart;

/**
 * ClassName: CartService
 * Package: com.simplem.doubanbook.service
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 23:23
 */
public interface CartService {
    String addToCart(int cid,int bid,int num);

    Cart selectCart(int cid);
}
