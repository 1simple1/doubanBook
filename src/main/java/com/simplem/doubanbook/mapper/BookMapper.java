package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: BookMapper
 * Package: com.simplem.doubanbook.mapper
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 11:52
 */
@Repository
public interface BookMapper {
    //图书列表展示
    List<Book> selectAll();

    //查询图书详细信息
    Book selectById(int id);

    //插入图书基本信息
    int insert(Book book);

    //插入图书详情信息
    int updateDetail(@Param("id") int id, @Param("book") Book book);

    //查询购物车的图书
    List<Book> cart(List<Integer> ids);

    //查询图书价格
    BigDecimal selectPrise(@Param("bid") int bid);
}
