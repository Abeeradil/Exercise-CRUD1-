package org.example.exercisecrud1.Controller;

import org.example.exercisecrud1.Api.ApiResponse;
import org.example.exercisecrud1.Model.TaskTrackerSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")

public class TaskController {
    ArrayList<TaskTrackerSystem> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<TaskTrackerSystem> getTasks() {
        return tasks;
    }

    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody TaskTrackerSystem task) {
        tasks.add(task);
        return new ApiResponse ("Task added successfully") ;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index, @RequestBody TaskTrackerSystem task) {
        tasks.set(index, task);
        return new ApiResponse("Task updated successfully") ;
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return new ApiResponse("task deleted successfully") ;

    }

    @PutMapping("/change/{index}")
    public ApiResponse changeTask(@PathVariable int index) {
        tasks.get(index).status = !tasks.get(index).status;
        return new ApiResponse("Status changed to " + tasks.get(index).getStatus() + "!") ;

    }

    @GetMapping("/search")
    public List<TaskTrackerSystem> searchTask(@RequestBody TaskTrackerSystem searchRequest) {
        String title = searchRequest.getTitle();
        List<TaskTrackerSystem> search = new ArrayList<>();
        for (TaskTrackerSystem task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                search.add(task);
            }
        }
        return search;

    }
}

