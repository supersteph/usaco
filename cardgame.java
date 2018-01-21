import java.io.*;
import java.util.*;

/**
 * Created by supersteve on 1/14/18.
 */
public class cardgame {
    static void dp(int[][] dp, int[] bottom, int[] top, int x, int y){
        if(dp[x][y]!=-1){
            return;
        }
        if(x==bottom.length-1&&y==bottom.length-1){
            if(bottom[bottom.length-1]<top[top.length-1]){
                dp[x][y] = 1;

            }
            else{
                dp[x][y] = 0;
            }
            return;
        }
        if(x==bottom.length-1){
            if(bottom[bottom.length-1]<top[y]){
                dp[x][y] = 1;

            }
            else{
                dp[x][y] = 0;
            }
            return;
        }
        if(y==top.length-1){
            if(bottom[x]<top[top.length-1]){
                dp[x][y] = 1;

            }
            else{
                dp[x][y] = 0;
            }
            return;
        }

        else{
            if(bottom[x]<top[y]){
                dp(dp,bottom,top,x+1,y);
                dp(dp,bottom,top,x+1,y);
                dp(dp,bottom,top,x+1,y+1);
                dp[x][y] = Math.max(Math.max(dp[x+1][y],dp[x][y+1]),dp[x+1][y+1]+1);
            }
            else {
                dp(dp,bottom,top,x+1,y);
                dp(dp,bottom,top,x+1,y);
                dp[x][y] = Math.max(dp[x+1][y],dp[x][y+1]);
            }
            return;
        }



    }
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("cardgame.in"));

        // input file name goes above

        int n = Integer.parseInt(f.readLine());
        int[] x = new int[2*n];
        int[] elsieorg = new int[n];
        for(int i =0; i<n;i++){
            int m = Integer.parseInt(f.readLine())-1;
            x[m] = 1;
            elsieorg[i] = m;
        }
        int besind = 0;
        int[]bessie = new int[n];
        for(int i = 0; i<2*n;i++){
            if(x[i]==0){
                bessie[besind] = i;
                ++besind;
            }
        }

        int[] besssmall = Arrays.copyOfRange(bessie, 0,n/2);
        int[] elssmall = Arrays.copyOfRange(elsieorg, 0,n/2);
        int[] bessbig = Arrays.copyOfRange(bessie, n/2,n);
        int[] elsbig = Arrays.copyOfRange(elsieorg, n/2,n);
        Arrays.sort(elssmall);
        Arrays.sort(elsbig);
        int[][] dpfirst= new int[n/2][n/2];
        for(int[] row:dpfirst){
            Arrays.fill(row,-1);
        }

        int[][] dpsecond= new int[n/2][n/2];
        for(int[] row:dpsecond){
            Arrays.fill(row,-1);
        }

        dp(dpfirst,besssmall,elsbig,0,0);
        dp(dpsecond, elssmall,bessbig,0,0);


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));

        out.println(dpfirst[0][0]+dpsecond[0][0]);
        out.close();

    }
}
