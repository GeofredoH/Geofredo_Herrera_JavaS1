package com.trilogyed.tasker.service;

import com.netflix.client.ClientException;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

@Component
public class TaskerServiceLayer {

    private final AdserverClient client;

    private TaskerDao dao;

    @Autowired
    public TaskerServiceLayer(AdserverClient client, TaskerDao dao) {
        this.client = client;
        this.dao = dao;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = buildTaskViewModel(task);

//        tvm.setId(task.getTaskId());                      //replaced this block with "buildTaskViewModel" method
//        tvm.setDescription(task.getTaskDescription());
//        tvm.setCreateDate(task.getCreateDate());
//        tvm.setDueDate(task.getDueDate());
//        tvm.setCategory(task.getCategory());
//        tvm.setAdvertisement(client.getAd());  // DONE* TODO - get ad from Adserver and put in tvm

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = dao.getAllTasks();
        List<TaskViewModel> tvmList = new ArrayList<>();

        taskList.stream()
                .forEach(task -> tvmList.add(buildTaskViewModel(task)));
        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = dao.getTasksByCategory(category);
        List<TaskViewModel> tvmList = new ArrayList<>();

        taskList.stream()
                .forEach(task -> tvmList.add(buildTaskViewModel(task)));
        return tvmList;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setTaskDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getTaskId());
        taskViewModel.setAdvertisement(client.getAd());  //    Feign client used to get advertisement here, other methods use the buildTaskViewModel method

//         TODO - get ad from Adserver and put in taskViewModel , Now incorporated into the buildTaskViewModel method aswell
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setTaskId(taskViewModel.getId());
        task.setTaskDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        dao.updateTask(task);
    }

    private TaskViewModel buildTaskViewModel(Task task){
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getTaskId());
        tvm.setDescription(task.getTaskDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(client.getAd());

        return tvm;
    }
}
