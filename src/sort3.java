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
        boolean shs = false;
        while (places.size()!=x.length-1){
            for(int m = 0; m<x.length-1;m++){
                for(int n = 0; n<x.length-1;n++){
                    if(shouldswitch(m,n,x)){
                        shs = true;
                        int lb = x[m];
                        x[m]=x[n];
                        x[n] = lb;
                        i++;
                        //shs = false;
                    }

                }
            }
            if(shs){
                print(x);

                shs = false;
                continue;

            }

            int maxid = 0;
            for(int j = 0;j<x.length;j++){
                if(x[j]>x[maxid]){
                    if(!places.contains(j)) {
                        //System.out.println("yo");
                        maxid = j;

                    }

                }
            }
            int min = maxid;
            for(int j = x.length-1; j>maxid;j--){
                if(x[min]>x[j]){
                    min = j;
                } else if(shouldswitch(maxid,j,x)){
                    min = j;
                }
            }
            //if(shouldswitch(,x))
            if(x[min]==1&&x[maxid]==1){
                break;
            }
            if(min!=maxid&&x[min]!=x[maxid]){
                print(x);

                int lb = x[maxid];
                x[maxid]=x[min];
                x[min] = lb;
                i++;

            } else {
                places.add(maxid);
            }
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
