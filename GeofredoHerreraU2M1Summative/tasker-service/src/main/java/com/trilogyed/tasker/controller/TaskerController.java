package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdserverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

//    NOT NEEDED IF USING FEING CLIENT
//    @Value("${servicePath}")
//    private String servicePath;
//
//    @Value("${serviceProtocol}")
//    private String serviceProtocol;
//
//    @Value("${adserverServiceName}")
//    private String adserverServiceName;

//    @Autowired
//    DiscoveryClient discoveryClient;

    @Autowired
    AdserverClient client;

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(AdserverClient client, TaskerServiceLayer service) {
        this.client = client;
        this.service = service;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel newTask(@Valid @RequestBody TaskViewModel taskViewModel){
        taskViewModel = service.newTask(taskViewModel);
        return taskViewModel;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@Valid @RequestBody TaskViewModel taskViewModel){
        service.updateTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable("id") int id){
        try {

            TaskViewModel task = service.fetchTask(id);
            return task;

        } catch (Exception e){
            throw new NotFoundException("Task not found by ID given.");
        }
//        if(task.getId() == 0){
//            throw new NotFoundException("Task not found");
//        }

    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks(){
        List<TaskViewModel> tasks = service.fetchAllTasks();
        if(tasks == null){
            throw new NotFoundException("Tasks not found");
        }
        return tasks;
    }

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(@PathVariable("category") String category){
        List<TaskViewModel> tasks = service.fetchTasksByCategory(category);

        if(tasks == null){
            throw new NotFoundException("Tasks not found");
        }
        return tasks;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable("id") int id) {
        service.deleteTask(id);
    }
}
