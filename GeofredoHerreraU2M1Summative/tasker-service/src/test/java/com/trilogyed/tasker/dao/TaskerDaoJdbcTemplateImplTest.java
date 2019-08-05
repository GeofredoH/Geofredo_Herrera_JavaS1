package com.trilogyed.tasker.dao;

import com.netflix.discovery.converters.Auto;
import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {
        List<Task> tasks = taskerDao.getAllTasks();

        tasks.stream()
                .forEach(task -> taskerDao.deleteTask(task.getTaskId()));
    }

    @Test
    public void addGetTask() {
//        Calendar cal = Calendar.getInstance(); // Don't need to use Calendar, but it is something good to remember

        Task task = new Task();
        task.setTaskDescription("Some task to do.");
        task.setCreateDate(LocalDate.now());                                          //create date is current date, LocalDate.now()
        task.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));     // used to set a due date of 1 week after creation
        task.setCategory("Errands");
        task = taskerDao.createTask(task);
        //        LocalDate next2Week = today.plus(2, ChronoUnit.WEEKS);

        Task task2 = taskerDao.getTask(task.getTaskId());

        assertEquals(task, task2);
    }

//    @Test
//    public void getTask() {
//    }

    @Test
    public void getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        Task task = new Task();
        task.setTaskDescription("Some task to do.");
        task.setCreateDate(LocalDate.now());                                          //create date is current date, LocalDate.now()
        task.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));     // used to set a due date of 1 week after creation
        task.setCategory("Errands");
        task = taskerDao.createTask(task);
        tasks.add(task);

        Task task2 = new Task();
        task2.setTaskDescription("Do this before 1 week.");
        task2.setCreateDate(LocalDate.now());                                          //create date is current date, LocalDate.now()
        task2.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));     // used to set a due date of 1 week after creation
        task2.setCategory("Yard-Work");
        task2 = taskerDao.createTask(task2);
        tasks.add(task2);

        List<Task> tasks2 = taskerDao.getAllTasks();

        assertEquals(tasks, tasks2);

    }

    @Test
    public void getTasksByCategory() {

        List<Task> tasks = new ArrayList<>();

        Task task = new Task();
        task.setTaskDescription("Some task to do.");
        task.setCreateDate(LocalDate.now());
        task.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));
        task.setCategory("Errands");
        task = taskerDao.createTask(task);

        Task task2 = new Task();
        task2.setTaskDescription("Do this before 1 week.");
        task2.setCreateDate(LocalDate.now());
        task2.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));
        task2.setCategory("Yard-Work");
        task2 = taskerDao.createTask(task2);
        tasks.add(task2);

        Task task3 = new Task();
        task3.setTaskDescription("Trim the hedges.");
        task3.setCreateDate(LocalDate.now());
        task3.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));
        task3.setCategory("Yard-Work");
        task3 = taskerDao.createTask(task3);
        tasks.add(task3);

        List<Task> tasks2 = taskerDao.getTasksByCategory(task3.getCategory());

        assertEquals(tasks, tasks2);
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setTaskDescription("Some task to do.");
        task.setCreateDate(LocalDate.now());                                          //create date is current date, LocalDate.now()
        task.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));     // used to set a due date of 1 week after creation
        task.setCategory("Errands");
        task = taskerDao.createTask(task);

        task.setTaskDescription("More tasks to do.");
        task.setDueDate(LocalDate.now().plus(2, ChronoUnit.WEEKS));

        taskerDao.updateTask(task);

        Task task2 = taskerDao.getTask(task.getTaskId());

        assertEquals(task, task2);
    }

    @Test
    public void deleteTask() {
        Task task = new Task();
        task.setTaskDescription("Some task to do.");
        task.setCreateDate(LocalDate.now());                                          //create date is current date, LocalDate.now()
        task.setDueDate(LocalDate.now().plus(1, ChronoUnit.WEEKS));     // used to set a due date of 1 week after creation
        task.setCategory("Errands");
        task = taskerDao.createTask(task);

        taskerDao.deleteTask(task.getTaskId());

        Task task2 = taskerDao.getTask(task.getTaskId());

        assertNull(task2);

    }
}