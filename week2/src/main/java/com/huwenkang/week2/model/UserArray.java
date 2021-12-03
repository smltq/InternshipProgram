package com.huwenkang.week2.model;

import lombok.Data;

@Data
public class UserArray {
    private User [] userArray;
    private int length;

    public UserArray(){
        userArray=new User[10];
    }
}
