package com.simplem.doubanbook.pachong;

import com.simplem.doubanbook.model.Book;
import com.simplem.doubanbook.model.Image;
import com.simplem.doubanbook.service.BookService;
import com.simplem.doubanbook.service.ImageService;
import com.simplem.doubanbook.util.JsoupUtils;
import com.simplem.doubanbook.util.PachongUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * ClassName: Pachong
 * Package: com.simplem.doubanbook.pachong
 * Description：
 * Author: simpleM
 * Date: 2020/11/23 9:22
 */
@SpringBootTest
public class Pachong {
    @Autowired
    private BookService bookService;

    @Autowired
    private ImageService imageService;

    @Test
    void contextLoads() throws IOException {
        String url = "https://market.douban.com/book/?page=2&page_num=18&";
        boolean result = JsoupUtils.attempConnect(url);
        if (result) {
            System.out.println("html爬取成功！");
            System.out.println("========================================");
        }
        Document document = JsoupUtils.downloadDocument(url);
        FileWriter fileWriter = new FileWriter("goods.html");
        fileWriter.write(document.toString());
        fileWriter.close();
        System.out.println("生成html文件成功！");
        System.out.println("========================================");
        Elements elements = document.select("ul.book-list>li");
        System.out.println("li元素的个数：" + elements.size());

        Book book = new Book();
        for (Element e : elements) {
            Element a = e.selectFirst("a");
            //获取面板图地址
            Element NowpanelImg = a.selectFirst("div.panel-img>img");
            String panelImg = NowpanelImg.attr("src");
            //图书封面图
            Element NowbookfaceImg = a.selectFirst("div.panel-detail>div.bookface-img>img");
            String bookfaceImg = NowbookfaceImg.attr("src");
            //价格
            Element NowPrice = a.selectFirst("div.panel-detail>span.book-price>i");
            String Nprice = NowPrice.text();
            BigDecimal price = PachongUtil.parseStrToNum(Nprice);
            //书名
            Element NowbookName = a.selectFirst("div.panel-detail>div.book-brief>h3");
            String bookName = NowbookName.text();
            //描述
            Element Nowdescription = a.selectFirst("div.panel-detail>div.book-brief>div.book-quote>p");
            String description = Nowdescription.text();

            book.setPanelImg(panelImg);
            book.setBookfaceImg(bookfaceImg);
            book.setPrice(price);
            book.setBookName(bookName);
            book.setDescription(description);
            book.setIsShow(true);
            bookService.insert(book);
        }
    }

    /*@Test
    void paChongBookDetail() throws IOException{
        StringBuffer sb = new StringBuffer("https://market.douban.com/book/fengzhi/?region=zhishu_collect_books_list&location=");
        int length = sb.length();
        for(int i = 1;i<=18;i++) {
            sb.append(i);
            if(i<10){
                //删除后一位
                sb.deleteCharAt(length);
            }else {
                //删除后两位
                sb.deleteCharAt(length);
                sb.deleteCharAt(length);
            }
            String url = sb.toString();
            boolean result = JsoupUtils.attempConnect(url);
            if (result) {
                System.out.println("html爬取成功！");
                System.out.println("========================================");
            }
            Document document = JsoupUtils.downloadDocument(url);
            FileWriter fileWriter = new FileWriter("goods.html");
            fileWriter.write(document.toString());
            fileWriter.close();
            System.out.println("生成html文件成功！");
            System.out.println("========================================");
            Elements elements = document.select("ul.photos>li");
            Image image = new Image();

            for (Element element : elements) {
                Element img = element.selectFirst("a.photo>img");
                image.setImgUrl(img.attr("src"));
                image.setBookId(i);
                //插入图书的展示图片
                imageService.insert(image);
            }
            //图书详情信息
            elements = document.select("div.text-right>dl>dd>em");
            Book book = new Book();
            book.setAuthor(elements.get(1).text());
            book.setPress(elements.get(2).text());
            book.setPublishTime(elements.get(3).text());
            book.setBinding(elements.get(5).text());
            book.setISBN(elements.get(6).text());
            bookService.updateDetail(i,book);
        }
    }*/

    @Test
    void paChongBookDetail() throws IOException {
        int bookId = 36;
        String url = "https://market.douban.com/book/poe/?region=zhishu_collect_books_list&location=18";
        boolean result = JsoupUtils.attempConnect(url);
        if (result) {
            System.out.println("html爬取成功！");
            System.out.println("========================================");
        }
        Document document = JsoupUtils.downloadDocument(url);
        FileWriter fileWriter = new FileWriter("goods.html");
        fileWriter.write(document.toString());
        fileWriter.close();
        System.out.println("生成html文件成功！");
        System.out.println("========================================");
        Elements elements = document.select("ul.photos>li");
        Image image = new Image();
        for (Element element : elements) {
            Element img = element.selectFirst("a.photo>img");
            image.setImgUrl(img.attr("src"));
            image.setBookId(bookId);
            //插入图书的展示图片
            imageService.insert(image);
        }
        //图书详情信息
        elements = document.select("div.text-right>dl>dd>em");
        int size = elements.size();
        Book book = new Book();
        book.setAuthor(elements.get(2).text());
        book.setPress(elements.get(4).text());
        book.setPublishTime(elements.get(5).text());
        book.setBinding(elements.get(size-2).text());
        book.setISBN(elements.get(size-1).text());
        bookService.updateDetail(bookId, book);
    }
}
