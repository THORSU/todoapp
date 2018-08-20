package com.todoapp.controller;

import com.todoapp.domain.Todo;
import com.todoapp.mapper.TodoMapper;
import org.apache.ibatis.javassist.tools.rmi.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hesh on 2018/8/15.
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoMapper todoMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> list() {
        return this.todoMapper.selectAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Todo get(@PathVariable Long id) {
        Todo todo = this.todoMapper.selectByPrimaryKey(id);
        if (todo == null) {
            throw new RuntimeException(id + " " + Todo.class.toString());
        }
        return todo;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Todo create(@RequestBody Todo entity) {
        logger.debug("create() with body {} of type {}", entity, entity.getClass());
        if (this.todoMapper.insert(entity) > -1)
            return entity;
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Todo update(@PathVariable Long id, @RequestBody Todo entity) {
        logger.debug("update() of id#{} with body {}", id, entity);
        if (this.todoMapper.updateByPrimaryKey(entity) > -1)
            return entity;
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.todoMapper.deleteByExample(id);
    }

}
