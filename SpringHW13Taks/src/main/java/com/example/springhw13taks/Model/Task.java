package com.example.springhw13taks.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {
    private String id , title , description ;
    private boolean status=true;
}
