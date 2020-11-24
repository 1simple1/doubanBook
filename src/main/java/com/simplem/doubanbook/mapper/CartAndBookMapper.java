package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.CartAndBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ClassName: CartAndBookMapper
 * Package: com.simplem.doubanbook.mapper
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 23:15
 */
@Repository
public interface CartAndBookMapper {
    //通过userId 和bookId 查询是否是第一次添加购物车
    CartAndBook selectByCartIdBookId(@Param("cid") int cid, @Param("bid") int bid);

    //添加购物车
    int insertBook(@Param("cid") int cid,@Param("bid") int bid);

    int updateBookNum(@Param("cid") int cid, @Param("bid") int bid);

    int sumBookNum(@Param("cid") int cid);
}
