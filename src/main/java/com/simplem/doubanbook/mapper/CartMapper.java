package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: CartMapper
 * Package: com.simplem.doubanbook.mapper
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 23:15
 */
@Repository
public interface CartMapper {
    int setPrise(@Param("cid") int cid, @Param("price")BigDecimal price);

    Cart selectCart(int cid);

}
