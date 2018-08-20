package com.todoapp.mapper;


import com.todoapp.domain.Todo;
import com.todoapp.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper extends MyMapper<Todo> {
}
