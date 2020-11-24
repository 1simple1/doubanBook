package com.simplem.doubanbook;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class DoubanBookApplicationTests {

    @Test
    void test(){
        BigDecimal bigDecimal = new BigDecimal(12.50);
        int num = 2;
        BigDecimal a = new BigDecimal(num);

    }
}
