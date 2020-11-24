package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.CartAndBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    int insertBook(@Param("cid") int cid, @Param("bid") int bid,@Param("num") int num);

    //更新图书数量
    int updateBookNum(@Param("cid") int cid, @Param("bid") int bid,@Param("num") int num);

    //查询购物车图书总数量
    int sumBookNum(@Param("cid") int cid);

    List<Integer> selectBookIds(int cid);
}
