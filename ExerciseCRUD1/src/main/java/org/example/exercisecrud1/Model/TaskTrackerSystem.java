package org.example.exercisecrud1.Model;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

@Data

@RequestMapping("/api/v1/task")
public class TaskTrackerSystem {

    public int ID;
    public String title;
    public String description;
    public boolean status;

    public String getStatus() {
        if (status) {
            return "Done";
        } else {
            return "Not Done";
        }
    }


}
