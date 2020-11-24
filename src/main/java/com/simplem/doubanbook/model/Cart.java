package com.simplem.doubanbook.model;

import com.simplem.doubanbook.vo.BookCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: Cart
 * Package: com.simplem.doubanbook.model
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 11:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private int id;
    private BigDecimal totalPrice;
    private int cartNum;

    private List<BookCart> books;
}
