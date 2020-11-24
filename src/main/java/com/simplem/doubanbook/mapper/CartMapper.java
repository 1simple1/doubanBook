package com.simplem.doubanbook.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

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
}
