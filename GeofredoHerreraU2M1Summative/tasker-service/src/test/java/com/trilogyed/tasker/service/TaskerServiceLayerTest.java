package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TaskerServiceLayerTest {

    TaskerDao taskerDao;
    TaskerServiceLayer service;
    AdserverClient client;

    @Before
    public void setUp() throws Exception {

        setUpTaskerDaoMock();
        setUpAdserverClientMock();

        service = new TaskerServiceLayer(client, taskerDao);
    }

    @Test
    public void fetchAllTasks() {

        LocalDate date1 = LocalDate.of(2019, 8, 4);
        LocalDate date2 = LocalDate.of(2019, 8, 11);

        List<TaskViewModel> tasks = new ArrayList<>();

        TaskViewModel task1 = new TaskViewModel();
        task1.setDescription("Do something.");
        task1.setCreateDate(date1);
        task1.setDueDate(date2);
        task1.setCategory("Lawn Work");
        task1 = service.newTask(task1);
        tasks.add(task1);

        TaskViewModel task2 = new TaskViewModel();
        task2.setDescription("Trim Hedges.");
        task2.setCreateDate(date1);
        task2.setDueDate(date2);
        task2.setCategory("Lawn Work");
        task2 = service.newTask(task2);
        tasks.add(task2);

        List<TaskViewModel> tasks2 = service.fetchAllTasks();

        assertEquals(2, tasks2.size());

    }

    @Test
    public void fetchTasksByCategory() {

        LocalDate date1 = LocalDate.of(2019, 8, 4);
        LocalDate date2 = LocalDate.of(2019, 8, 11);

        List<TaskViewModel> tasks = new ArrayList<>();

        TaskViewModel task1 = new TaskViewModel();
        task1.setDescription("Do something.");
        task1.setCreateDate(date1);
        task1.setDueDate(date2);
        task1.setCategory("Lawn Work");
        task1 = service.newTask(task1);
        tasks.add(task1);

        TaskViewModel task2 = new TaskViewModel();
        task2.setDescription("Trim Hedges.");
        task2.setCreateDate(date1);
        task2.setDueDate(date2);
        task2.setCategory("Lawn Work");
        task2 = service.newTask(task2);
        tasks.add(task2);

        List<TaskViewModel> tasks2 = service.fetchTasksByCategory("Lawn Work");

        assertEquals(2, tasks2.size());
    }

    @Test
    public void addGetTask() {

        LocalDate date1 = LocalDate.of(2019, 8, 4);
        LocalDate date2 = LocalDate.of(2019, 8, 11);
        TaskViewModel task1 = new TaskViewModel();
        task1.setDescription("Do something.");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("Lawn Work");

        task1 = service.newTask(task1);

        TaskViewModel task2 = service.fetchTask(5);

        assertEquals(task1.toString(), task2.toString());
    }

    @Test
    public void deleteTask() {

        LocalDate date1 = LocalDate.of(2019, 8, 4);
        LocalDate date2 = LocalDate.of(2019, 8, 11);
        TaskViewModel task1 = new TaskViewModel();
        task1.setDescription("Do something.");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("Lawn Work");

        task1 = service.newTask(task1);

        taskerDao.deleteTask(task1.getId());

        verify(taskerDao).deleteTask(any(Integer.class));

    }

    @Test
    public void updateTask() {

        LocalDate date1 = LocalDate.of(2019, 8, 4);
        LocalDate date2 = LocalDate.of(2019, 8, 11);
        TaskViewModel task1 = new TaskViewModel();
        task1.setDescription("Do something.");
        task1.setCreateDate(date1);  //LocalDate.of(2019, 8, 4)
        task1.setDueDate(date2);   //LocalDate.of(2019, 8, 11)
        task1.setCategory("Lawn Work");

        task1 = service.newTask(task1);

        task1.setDescription("Something other.");

        service.updateTask(task1);

        verify(taskerDao).updateTask(any(Task.class));
    }

    public void setUpTaskerDaoMock() {

        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        LocalDate date1 = LocalDate.of(2019, 8, 4);
        LocalDate date2 = LocalDate.of(2019, 8, 11);

        List<Task> tasks = new ArrayList<>();

        Task task1 = new Task();
        task1.setTaskDescription("Do something.");
        task1.setCreateDate(date1);
        task1.setDueDate(date2);
        task1.setCategory("Lawn Work");

        Task task2 = new Task();
        task2.setTaskId(5);
        task2.setTaskDescription("Do something.");
        task2.setCreateDate(date1);
        task2.setDueDate(date2);
        task2.setCategory("Lawn Work");
        tasks.add(task2);

        Task task3 = new Task();
        task3.setTaskDescription("Trim Hedges.");
        task3.setCreateDate(date1);
        task3.setDueDate(date2);
        task3.setCategory("Lawn Work");

        Task task4 = new Task();
        task4.setTaskId(8);
        task4.setTaskDescription("Trim Hedges.");
        task4.setCreateDate(date1);
        task4.setDueDate(date2);
        task4.setCategory("Lawn Work");
        tasks.add(task4);

        doReturn(task2).when(taskerDao).createTask(task1);
        doReturn(task4).when(taskerDao).createTask(task3);
        doReturn(task2).when(taskerDao).getTask(5);
        doReturn(tasks).when(taskerDao).getAllTasks();
        doReturn(tasks).when(taskerDao).getTasksByCategory("Lawn Work");

    }

    public void setUpAdserverClientMock() {

        client = mock(AdserverClient.class);
        doReturn("Random Ad").when(client).getAd();

    }
}