/*
ID: xiaoyun4
LANG: JAVA
TASK: sprime
*/

/**
 * How to solve it:
 *
 * I have two  a to explore method, and while the last element in the array is not = 0 then
 * i keep on going and add an odd number to the end to check to see if it is going to keep
 * on being a prime number
 *
 *
 */


import java.io.*;
import java.util.*;
public class sprime {
    public static boolean isPri(int[] x, index){
        int y = 0;
        for(int i = 0; i<= index;i++){
            y+=x[i]*Math.pow(10,index-i);
        }
        System.out.println(y);
        return false;
    }

    public static void main(String[] args) throws IOException {
        isPri(new {1,2,3},1);


    }
}
