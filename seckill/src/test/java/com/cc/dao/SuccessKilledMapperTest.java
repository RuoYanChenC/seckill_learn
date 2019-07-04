package com.cc.dao;

import com.cc.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class SuccessKilledMapperTest {

    @Resource
    SuccessKilledMapper successKilledMapper;

    @Test
    public void insertSuccessKilled() {

        long id = 1000;
        long phone = 17606505561L;
        int insertCount = successKilledMapper.insertSuccessKilled(id,phone);
        System.out.println("insertCount: "  + insertCount);

    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000;
        long phone = 17606505561L;
        SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}