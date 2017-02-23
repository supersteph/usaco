
import sun.awt.image.ImageWatched;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class nocross {

    public static int compare(int[] s, int[] t, int bot, int top){
        if(Math.abs(s[bot]-t[top])<=4){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("nocross.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocross.out")));

        int n = Integer.parseInt(f.readLine());
        int[] s = new int[n];
        int[] t = new int[n];

        for(int i = 0; i<n;i++){
            s[i] = Integer.parseInt(f.readLine());
        }
        for(int i = 0; i<n;i++){
            t[i] = Integer.parseInt(f.readLine());
        }

        int[][] dp = new int[n][n];
        dp[0][0] = compare(s,t,0,0);

        for(int i = 1; i<n;i++){
            dp[0][i] = Math.max(dp[0][i-1],compare(s,t,0,i));
        }

        for(int i = 1; i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],compare(s,t,i,0));
        }

        for(int i = 1;i<n;i++){
            for(int j = 1; j<n;j++){
                dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]+compare(s,t,i-1,j-1));

            }
        }
        out.println(dp[n-1][n-1]);
        System.out.println(dp[n-1][n-1]);


        out.close();
    }


}
