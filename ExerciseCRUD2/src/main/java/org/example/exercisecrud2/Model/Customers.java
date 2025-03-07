package org.example.exercisecrud2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class Customers {

    private int id;
    private String userName;
    private double balance;
}
