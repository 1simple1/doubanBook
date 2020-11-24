package com.simplem.doubanbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: CartAndBook
 * Package: com.simplem.doubanbook.model
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 23:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartAndBook {
    private int bookId;
    private int cartId;
    private int bookNum;
}
