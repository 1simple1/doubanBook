package com.simplem.doubanbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Img
 * Package: com.simplem.doubanbook.model
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 12:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private int id;
    private int bookId;
    private String imgUrl;
}
