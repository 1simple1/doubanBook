package com.simplem.doubanbook.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.math.BigDecimal;


/**
 * 爬虫工具类
 * @author lujun
 *
 */
public class PachongUtil {
	public static Document getDocument(String url) {
		try {
			// userAgent用于模拟自己是浏览器访问，防止反爬虫网站对爬虫程序的禁止
			String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1";
			Document doc = Jsoup.connect(url).header("Accept-Encoding", "gzip, deflate").userAgent(userAgent)
					.timeout(6000).get();
			return doc;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 浮点数字符串转换为浮点数
	 * @param str ，例如“11.26"
	 * @return
	 */
	public static BigDecimal  parseStrToNum(String str){
		
		BigDecimal dec = new BigDecimal(str);  
		//保留2位小数
		BigDecimal d = dec.setScale(2, BigDecimal.ROUND_DOWN);
		return d;
	}
}
