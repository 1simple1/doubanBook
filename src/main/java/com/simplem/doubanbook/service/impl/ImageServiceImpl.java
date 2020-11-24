package com.simplem.doubanbook.service.impl;

import com.simplem.doubanbook.mapper.ImageMapper;
import com.simplem.doubanbook.model.Image;
import com.simplem.doubanbook.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: ImageServiceImpl
 * Package: com.simplem.doubanbook.service
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 21:31
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public int insert(Image image) {
        return imageMapper.insert(image);
    }
}
