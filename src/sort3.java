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
        for(int j:x){
            System.out.print(j+ " ");
        }
        System.out.println();
    }
    public static int[] getBorders(int[] x){
        int[] count = new int[4];
        for(int y:x){
            count[y]+=1;
        }
        count[2]+=count[1];
        count[3]+=count[2];
        return count;
    }
    public static boolean shouldswitch(int i, int j, int[] x) {
        int[] all = getBorders(x);
        if (x[i] == domainof(all,j) && x[j]== domainof(all,i)){
            return true;
        }
        return false;


    }
    public static void switchthree(int a,int b, int c, int[]x,int[] borders){
        int a1 = x[a];
        int b1 = x[b];
        int c1 = x[c];
        x[a] = 0;
        x[b] = 0;
        x[c] = 0;
        for(int i = borders[a1-1]; i<borders[a1];i++){
            if(x[i]==0){
                x[i] = a1;
            }
        }
        for(int i = borders[b1-1]; i<borders[b1];i++){
            if(x[i]==0){
                x[i] = b1;
            }
        }
        for(int i = borders[c1-1]; i<borders[c1];i++){
            if(x[i]==0){
                x[i] = c1;
            }
        }

    }
    public static int domainof(int[] borders, int x){

        for(int i = 0; i<3;i++){
            if(borders[i]<=x && borders[i+1]>x){
                return i+1;

            }
        }
        return 0;

    }


    public static int sort(int[] x){
        int i = 0;
        HashSet<Integer> places =  new HashSet<Integer>();

        int[] borders = getBorders(x);
        //boolean shs = false;
        int index =0;
        outerloop:
        while (index!=x.length){
            if(domainof(borders,index)==x[index]){
                index++;
                continue;
            }
            for(int index2 = index; index2<x.length;index2++) {


                if (shouldswitch(index, index2, x) && x[index] != x[index2]) {
                    //shs = true;
                    int lb = x[index];
                    x[index] = x[index2];
                    x[index2] = lb;
                    places.add(index);
                    places.add(index2);
                    i++;
                    continue outerloop;

                    //shs = false;
                }
            }


            for(int index2 = x.length-1;index2>index;index2--){
                if(x[index2]==domainof(borders,index2)||x[index2]==x[index]){
                    continue;
                }
                for(int index3 = index; index3<x.length;index3++){
                    if(x[index2]==x[index3]||x[index]==x[index3]||x[index3]==domainof(borders,index3)){
                        if(x[index]==domainof(borders,index3)){
                            switchthree(index,index2,index3,x,borders);
                            i+=2;
                            continue outerloop;


                        }

                    }

                }

            }
            index++;




        }

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
