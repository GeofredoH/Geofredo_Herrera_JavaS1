package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskerDaoJdbcTemplateImpl implements TaskerDao {

    public static final String INSERT_TASK =
            "insert into task (task_description, create_date, due_date, category) values (?, ?, ?, ?)";
    public static final String SELECT_TASK_BY_ID =
            "select * from task where task_id = ?";
    public static final String SELECT_ALL_TASKS =
            "select * from task";
    public static final String SELECT_TASKS_BY_CATEGORY =
            "select * from task where category = ?";
    public static final String UPDATE_TASK =
            "update task set task_description = ?, create_date = ?, due_date = ?, category = ? where task_id = ?";
    public static final String DELETE_TASK =
            "delete from task where task_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TaskerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Task createTask(Task task) {
        jdbcTemplate.update(INSERT_TASK, task.getTaskDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory());
        int taskId = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        task.setTaskId(taskId);
        return task;
    }

    @Override
    public Task getTask(int id) {
        try{
        Task task = jdbcTemplate.queryForObject(SELECT_TASK_BY_ID, this::mapRowToTask, id);
        return task;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Task> getAllTasks() {
        try{
        List<Task> tasks = jdbcTemplate.query(SELECT_ALL_TASKS, this::mapRowToTask);
        return tasks;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        try{
        List<Task> tasks = jdbcTemplate.query(SELECT_TASKS_BY_CATEGORY, this::mapRowToTask, category);
        return tasks;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void updateTask(Task task) {
        jdbcTemplate.update
                (UPDATE_TASK, task.getTaskDescription(),
                        task.getCreateDate(),
                        task.getDueDate(),
                        task.getCategory(),
                        task.getTaskId());
    }

    @Override
    public void deleteTask(int id) {
        jdbcTemplate.update(DELETE_TASK, id);
    }

    private Task mapRowToTask(ResultSet rs, int rowNumber) throws SQLException {
        Task task = new Task();
        task.setTaskId(rs.getInt("task_id"));
        task.setTaskDescription(rs.getString("task_description"));
        task.setCreateDate(rs.getDate("create_date").toLocalDate());
        task.setDueDate(rs.getDate("due_date").toLocalDate());
        task.setCategory(rs.getString("category"));

        return task;
    }
}
