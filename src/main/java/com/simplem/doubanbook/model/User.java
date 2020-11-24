package com.simplem.doubanbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: User
 * Package: com.simplem.doubanbook.model
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 11:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String userName;
    private String password;

    private Cart cart;
}
