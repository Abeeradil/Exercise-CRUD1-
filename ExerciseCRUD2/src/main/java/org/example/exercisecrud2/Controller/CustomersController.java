package org.example.exercisecrud2.Controller;

import lombok.Data;
import org.example.exercisecrud2.Api.ApiResponse;
import org.example.exercisecrud2.Model.Customers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    ArrayList<Customers> customersList = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customers> getCustomers() {
        return customersList;
    }
    @PostMapping("/add")
    public ApiResponse addCustomer(@RequestBody Customers customer) {
        customersList.add(customer);
        return new ApiResponse("Customer added successfully!") ;
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index, @RequestBody Customers customer) {
         customersList.set(index, customer);
        return new ApiResponse("Customer updated successfully!") ;
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index) {
        customersList.remove(index);
        return new ApiResponse("Customer deleted successfully!") ;
    }

    @PutMapping("/deposit/{index}")
    public ApiResponse depositMoney(@PathVariable int index, @RequestBody double amount) {
        Customers customer = customersList.get(index);
        customer.setBalance(customer.getBalance() + amount);
        return new ApiResponse("Deposited " + amount + " to " + customer.getUserName() + ". New balance: " + customer.getBalance()) ;
    }

    @PutMapping("/withdraw/{index}")
    public String withdrawMoney(@PathVariable int index, @RequestBody double amount) {
        Customers customer = customersList.get(index);
        if (customer.getBalance() < amount) {//اذا كان الحساب لا يقبل السحب
            return "Insufficient balance for " + customer.getUserName() + ". Current balance: " + customer.getBalance();
        }
        customer.setBalance(customer.getBalance() - amount);
        return "Withdrew " + amount + " from " + customer.getUserName() + ". New balance: " + customer.getBalance();
    }


}
