/*
ID: xiaoyun4
LANG: JAVA
TASK: sprime
*/

/**
 * How to solve it:
 *So i get the first prime number, and then i add the second number to it and check to make sure that it is prime
 * if it is prime then i add it to the end of an arraylist of things to be explored if it isn't then i don't, when
 * i get to the first thing that shows that the entire thing is a super prime then i return
 *
 *
 */


import java.io.*;
import java.util.*;

public class sprime {
    public static boolean isPri(int[] x, int index){
        int y = 0;
        for(int i =;i++){
            y+=x[index-i]*Math.pow(10,index-i);
        }
        System.out.println(y);
        for (int i = 3;i<=Math.sqrt(y);i+=2){

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        isPri(new int[] {1,2,3},1);
    }
}
