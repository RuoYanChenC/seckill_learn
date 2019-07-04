package com.cc.dao.cache;

import com.cc.dao.SeckillMapper;
import com.cc.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class RedisDaoTest {

    private  long id = 1001;
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private SeckillMapper seckillMapper;
    @Test
    public void getSeckill() {

        Seckill seckill = redisDao.getSeckill(id);
        if(seckill == null){
            seckill = seckillMapper.queryById(id);
            if(seckill != null){
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);

                Seckill seckill1 = redisDao.getSeckill(id);
                System.out.println(seckill1);
            }
        }


    }

    @Test
    public void putSeckill() {
    }
}