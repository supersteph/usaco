/*
ID: xiaoyun4
LANG: JAVA
TASK: sprime
*/

/**
 * How to solve it:
 * So I read in all of the data, and I add a 1 if it is a wall, and I just start at 1, and keep on going right until
 * I might be able to go up or down, and when it can i add up the spaces in the room, when i try to remove a wall, i
 * try to remove all the walls in the middle and see if there are any rooms that are bigger
 *
 */


import java.io.*;
import java.util.*;

public class castle {

    public static ArrayList<Integer> getRoomsizes(int[][]x){
        ArrayList<Integer> rooms = new ArrayList<Integer>();
        for(int i = 1; i< x.length-1;i++){
            for (int j = 1; j<x[0].length-1;j++){
                x

            }
        }



    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

        int m = Integer.parseInt(f.readLine());
        int n = Integer.parseInt(f.readLine());

        int[][] x = new int[2*n+1][2*m+1];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0;j<m;j++){
                int k = Integer.parseInt(st.nextToken());
                if(k-8>=0){
                    x[2*i+2][2*j+1] = 1;
                    k-=8;
                }
                if(k-4>=0){
                    x[2*i+1][2*j+2] = 1;
                    k-=4;
                }
                if(k-2>=0){
                    x[2*i][2*j+2] = 1;
                    k-=2;
                }
                if(k-1>=0){
                    x[2*i+1][2*j]=1;
                    k-=1;

                }

            }
        }


    }
}
