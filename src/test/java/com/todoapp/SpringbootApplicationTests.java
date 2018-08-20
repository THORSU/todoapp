package com.todoapp;

import com.todoapp.SpringbootApplication;
import com.todoapp.domain.Todo;
import com.todoapp.mapper.TodoMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class SpringbootApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void testInsert() throws Exception {
        Todo todo = new Todo();
        todo.setContent("This is a test4");
        todo.setChecked(false);
        int num = todoMapper.insert(todo);
        TestCase.assertEquals(num,1);
    }

    @Test
    public void testFindById() throws Exception {
        Todo todo = todoMapper.selectByPrimaryKey(2);
        TestCase.assertNotNull(todo);
        System.out.println(todo.toString());
    }

    @Test
    public void testUpdateById() throws Exception {
        Todo todo = todoMapper.selectByPrimaryKey(1);
        TestCase.assertNotNull(todo);
        todo.setChecked(true);
        int rows = todoMapper.updateByPrimaryKey(todo);
        System.out.println(rows);
    }
}
