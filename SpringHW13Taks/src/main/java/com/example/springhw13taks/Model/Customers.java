package com.example.springhw13taks.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customers {

    private String id , username;
    private double balance;
}
