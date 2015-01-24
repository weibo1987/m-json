package com.jrj.m.service.news;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.jrj.m.model.news.News;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dataSource.xml")
public class NewsServiceTest {

    @Autowired
    private NewsService service;
    @Test
    public void getNewsTest() {
       	News obj = new News();
       	obj.setIiid(1111);
       	obj.setTitle("adfadf");
       	obj.setIntro("dsssdd");
//        NewsDAO newsDAO = EasyMock.createMock("newsDAO", NewsDAO.class);
//
//        EasyMock.expect(newsDAO()).andReturn(t);
//        EasyMock.replay(testDAO);
//
//        ReflectionTestUtils.setField(service, "testDAO", testDAO, TestDAO.class);
//
//        t = service.getTest();
//        // 确信使用了mock
//        EasyMock.verify(testDAO);
//
//        Assert.assertEquals(1111, t.getId());
    }
}
