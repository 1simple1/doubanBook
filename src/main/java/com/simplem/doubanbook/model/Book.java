package com.simplem.doubanbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Book
 * Package: com.simplem.doubanbook.model
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 11:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String panelImg;
    private String bookfaceImg;
    private BigDecimal price;
    private String bookName;
    private String description;
    private String author;
    private String press;
    private String publishTime;
    private String binding;
    private String ISBN;
    private Boolean isShow;

    private List<Image> images;

}
