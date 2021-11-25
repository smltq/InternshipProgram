package com.week1.demo;

public class test {
    public static void main(String[] args) {
       boolean b= FindTwoAdd.findTowNumberOfAdd(new int[]{3,3},6);
       System.out.println(b);
       System.out.println(FindTwoAdd.temparry[0]+" "+ FindTwoAdd.temparry[1]);

        FindTwoAdd.stem(new int[]{3,2,4});
        b=FindTwoAdd.findTowNumberOfAddWithMap(6);
        System.out.println(b);
        System.out.println(FindTwoAdd.temparry[0]+" "+ FindTwoAdd.temparry[1]);
    }
}
