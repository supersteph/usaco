/*
ID: xiaoyun4
LANG: JAVA
TASK: sort3
*/

/**
 * How to solve it:
 *I start at the first number, and I check to see if there are any numbers that less than it, if not, then i switch to
 * the second number, and if in all the numbers, there is nothing less than it than i am good
 *
 */


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class sort3 {

    public static int sort(int[] x){
        int i = 0;
        int index = 0;
        while (index!=x.length-1){
            int min = x[index];
            int k = index;
            for(int j = index+1; j<x.length;j++){
                if(min>x[j]){
                    k = j;
                    min = x[j];
                }
            }
            if(min!=x[index]){
                int lb = x[index];
                x[index]=x[k];
                x[k] = lb;
                i++;

            }
            index++;
        }
        System.out.println("i is " + i);

        return i;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        int k = Integer.parseInt(f.readLine());
        int[] m = new int[k];

        for(int i = 0; i < k;i++){
            m[i] = Integer.parseInt(f.readLine());

        }

        int l = sort(m);
        out.println(l);



        out.close();
        System.exit(0);


    }
}
