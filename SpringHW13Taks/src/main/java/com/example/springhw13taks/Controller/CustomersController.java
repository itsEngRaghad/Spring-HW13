package com.example.springhw13taks.Controller;

import com.example.springhw13taks.APIResponse.APIResponse;
import com.example.springhw13taks.Model.Customers;
import com.example.springhw13taks.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customer")//URL
public class CustomersController {

    ArrayList<Customers> Customerss =new ArrayList<>();

    //CRUD

    //Read (Display customers) --> Get in postman
    @GetMapping("/get")
    public ArrayList getCustomer(){
        return Customerss; //endpoint for Displaying customers
        //it will get customer from Model then return it in the array
    }

    //Create (ADD customers) --> post in postman
    @PostMapping("/add")
    public APIResponse addCustomer(@RequestBody Customers customers){
        Customerss.add(customers); //adding to the arrayList (Customers)
        return new APIResponse("Customers has been added!");
    }


    //Update (Update Customers) --> put in postman
    @PutMapping("/update/{index}")
    public APIResponse updateTask(@PathVariable int index, @RequestBody Customers customers){
        Customerss.set(index,customers);
        return new APIResponse("Customer has been updated!");
    }

    //Delete (Delete Customer) --> Delete in postman
    @DeleteMapping("/delete/{index}")
    public APIResponse deleteCustomer(@PathVariable int index){
        Customerss.remove(index);
        return new APIResponse("Customer has been removed!");
    }

    @PostMapping("/deposit/{index}/{amount}")
    public APIResponse depositCustomer(@PathVariable int index, @PathVariable double amount){


           double afterdep= Customerss.get(index).getBalance()+amount;

           Customerss.get(index).setBalance(afterdep);
        return new APIResponse("amount has been deposit! ");
    }

@PostMapping("/withdraw/{index}/{amount}")
    public APIResponse withdrawCustomer(@PathVariable int index, @PathVariable double amount){
        if(Customerss.get(index).getBalance()>=amount){
            double aftewithd= Customerss.get(index).getBalance()-amount;
            Customerss.get(index).setBalance(aftewithd);

        }

        return new APIResponse("amount has been withdrawn! ");
    }



}
