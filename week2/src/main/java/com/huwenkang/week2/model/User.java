package com.huwenkang.week2.model;

import lombok.Data;

@Data
public class User {
   private String userName;
   private String userPassWord;

   public User(){

   }

   public User(String userName,String userPassWord){
      this.userName=userName;
      this.userPassWord=userPassWord;
   }
}
