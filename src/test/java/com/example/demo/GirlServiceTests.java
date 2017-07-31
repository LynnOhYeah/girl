package com.example.demo;

import com.example.demo.domain.Girl;
import com.example.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fankun.zfk on 2017/7/24.
 */
//RunWith表示要在测试环境跑，底层使用junit测试工具
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTests {
    @Autowired
    private GirlService girlService;

    @Test
    public  void findOneTest(){
        Girl girl=girlService.findOne(17);
        Assert.assertEquals(new Integer(5),girl.getAge());
    }

}
