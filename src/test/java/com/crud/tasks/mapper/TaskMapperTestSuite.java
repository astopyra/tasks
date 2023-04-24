package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void testMapToTask(){
        //given
        TaskDto taskDto1 = new TaskDto(1L, "Task1", "task number 1");

        //when
        Task resultTask = taskMapper.mapToTask(taskDto1);

        //then
        assertEquals(1L, resultTask.getId());
        assertEquals("Task1", resultTask.getTitle());
    }

    @Test
    void testMapToTaskDto(){
        //given
        Task task = new Task(3L, "Task3", "Task number 3 content");

        //when
        TaskDto resultTaskDto = taskMapper.mapToTaskDto(task);

        //then
        assertEquals(3L, resultTaskDto.getId());
        assertEquals("Task3", resultTaskDto.getTitle());
    }

    @Test
    void testToTaskDtoList(){
        //given
        List<Task> taskList = List.of(new Task(33L, "Task33", "Task number 33 content"));

        //when
        List<TaskDto> resultTaskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //then
        assertNotNull(resultTaskDtoList);
        assertEquals("Task33", resultTaskDtoList.get(0).getTitle());
    }
}
