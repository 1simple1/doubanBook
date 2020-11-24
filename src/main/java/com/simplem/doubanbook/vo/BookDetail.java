package com.simplem.doubanbook.vo;

import com.simplem.doubanbook.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: BookDetial
 * Package: com.simplem.doubanbook.vo
 * Description：
 * Author: simpleM
 * Date: 2020/11/24 14:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetail {
    private int id;
    private String author;
    private String binding;
    private String bookName;
    private String ISBN;
    private String bookfaceImg;
    private String press;
    private String price;
    private String publishTime;

    //购物车内图书总数量
    private int cartNum;

    private List<Image> images;
}
