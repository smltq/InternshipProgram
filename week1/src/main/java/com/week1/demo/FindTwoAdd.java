package com.week1.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */

/**
 * 1.暴力枚举解法基本正确
 * 2.用map优化没有成功
 * 评语:才大二能把代码写到这个程度非常不错,Solution.java是我整理的示例代码,可供实习生学习参考
 */
public class FindTwoAdd {

    /**
     * 建议
     * 1.temparry命名尽量规范，下划线式或驼峰式。如tempArray或temp_array
     * 2.尽量减少变量的使用域,即用局部变量就尽量不要成员变量,能成员变量就不要全局变量
     */
    static int[] temparry=new int[2];

    /**
     * 建议
     * 1.成员变量命名,尽量准确,方便他人阅读,比如这里的m,如果命名成map或hashmap,阅读者一看就知道这是个map结构的就会好很多
     */
    private static Map m= new HashMap<Integer,int[]>();

    public FindTwoAdd() {

    }

    //通过2个for循环查找对应的target
    public static boolean findTowNumberOfAdd(int[] nums,int target){
        int temp;

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                temp=nums[i]+nums[j];
                if(temp==target){
                    temparry[0]=i;
                    temparry[1]=j;
                    return true;
                }
            }
        }
        return false;
    }


    /*
    *我不确定这样算不算用map简化了时间复杂的，我想不到更好的方法了
    */

    //通过map查找对应的target，再使用findTowNumberOfAddWithMap之前需要对Map m进行设置。
    public static void stem(int[] arry){
        for(int i=0;i<arry.length-1;i++){
            for(int j=i+1;j<arry.length;j++){
                m.put(arry[i]+arry[j],new int[]{i,j});
            }
        }
    }

    //查找target
    public static boolean findTowNumberOfAddWithMap(int target){

        for(Object key : m.keySet()){
            if((int)key==target){
                temparry= (int[]) m.get(key);
                return true;
            }
        }
        return false;
    }
}
