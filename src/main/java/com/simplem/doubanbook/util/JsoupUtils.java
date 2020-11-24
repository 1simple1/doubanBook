package com.simplem.doubanbook.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * ClassName: JsoupUtils
 * Package: com.simplem.doubanbook.util
 * Description：
 * Author: simpleM
 * Date: 2020/11/22 18:17
 */
public class JsoupUtils {

    /**
     * 对url进行连接尝试，如果连接成功则返回true，否则返回false
     * @param url
     * @return
     */
    public static boolean attempConnect(String url){
        try {
            Jsoup.connect(url)
                    .timeout(3*1000)
                    .get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 下载指定url的文档对象
     * @param url
     * @return
     * @throws IOException
     */
    public static Document downloadDocument(String url) throws IOException{
        Document document = Jsoup.connect(url).timeout(5*1000).get();
        return document;
    }
}
