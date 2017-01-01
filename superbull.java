import java.io.*;

import java.util.*;


public class superbull {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("superbull.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("superbull.out")));

        int n = Integer.parseInt(f.readLine());
        int[] teams = new int[n];

        for(int i = 0; i<n;i++){
            teams[i] = Integer.parseInt(f.readLine());
        }

        long result = 0;

        boolean[] used = new boolean[n];
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            int j = -1;
            for (int k = 0; k < n; k++) {
                if (used[k]) continue;
                if (j == -1 || edges[k] > edges[j]) {
                    j = k;
                }
            }
            
            result += edges[j];
            used[j] = true;
            for (int k = 0; k < n; k++) {
                if(used[k]){
                    continue;
                }
                edges[k] = Math.max(edges[k], teams[j] ^ teams[k]);
            }
        }
        out.println(result);




        out.close();


    }
}