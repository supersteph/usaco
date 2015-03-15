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
    public static void print(int[]x){
        for(int i:x){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int sort(int[] x){
        int i = 0;
        HashSet<Integer> places =  new HashSet<Integer>();
        while (places.size()!=x.length-1){
            int maxid = 0;
            for(int j = 0;j<x.length;j++){
                if(x[j]>x[maxid]){
                    if(!places.contains(maxid)) {
                        maxid = j;
                        System.out.println(maxid+" " +places.toString());

                    }

                }
            }
            int min = maxid;
            for(int j = maxid+1; j<x.length;j++){
                if(x[min]>x[j]){
                    min = j;
                }
            }
            //System.out.println(places);
            if(min!=maxid){
                print(x);
                int lb = x[maxid];
                x[maxid]=x[min];
                x[min] = lb;
                i++;
                print(x);

            } else {
                places.add(maxid);
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
