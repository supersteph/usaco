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
        HashSet<Integer> places =  new HashSet<Integer>();
        while (places.size()!=x.length-1){
            int max = 0;
            for(int j = 0;j<x.length;j++){
                if(x[j]>x[max]){
                    if(!places.contains(max)){
                        max = x[j];
                        break;

                    }else{
                        continue;
                    }
                }
            }
            int min = max;
            for(int j = max+1; j<x.length;j++){
                if(x[min]>x[j]){
                    min = j;
                }
            }
            //System.out.println(max+ " "+min);
            if(min!=max){
                int lb = x[max];
                x[max]=x[min];
                x[min] = lb;
                i++;

            } else {
                places.add(max);
            }
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
