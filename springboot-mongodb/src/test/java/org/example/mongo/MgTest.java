package org.example.mongo;

import org.example.mongo.App;
import org.example.mongo.model.Book;
import org.example.mongo.service.MongoDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * mongodb test
 */

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class MgTest {

    @Resource
    private MongoDbService mongoDbService;

    @Test
    public void testSave() {
        Book book = new Book();
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        book.setId("3");
        book.setInfo("info");
        book.setPrice(12);
        book.setPublish("publish");
        mongoDbService.saveObj(book);
    }

    @Test
    public void testQueryAll() {
        List<Book> all = mongoDbService.findAll();
        System.out.println(all);

    }

}
