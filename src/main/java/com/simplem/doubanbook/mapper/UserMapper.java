package com.simplem.doubanbook.mapper;

import com.simplem.doubanbook.model.User;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserMapper
 * Package: com.simplem.doubanbook.mapper
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 11:42
 */
@Repository
public interface UserMapper {
    User login(User user);
}
