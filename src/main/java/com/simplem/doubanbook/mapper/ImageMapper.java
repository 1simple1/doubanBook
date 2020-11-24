package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ClassName: ImageMapper
 * Package: com.simplem.doubanbook.mapper
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 21:24
 */

@Repository
public interface ImageMapper {

    int insert(Image image);
}
