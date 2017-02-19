
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class visitfj {
    static int ops = 0;
    static int dr[] = {0, 1, 2, 3, 2, 1, 0, -1, -2, -3, -2, -1, -1, 1, 0, 0};

    static int dc[] = {3, 2, 1, 0, -1, -2, -3, -2, -1, 0, 1, 2, 0, 0, -1, 1};

    static boolean update (int[][] cost, int x, int y, int cur,int n, int[][] key){
        if(x<0||x>=n||y<0||y>=n){
            return false;
        }
        if(cost[x][y]==-1){
            cost[x][y] = cur+key[x][y];
            return true;
        }
        else if(cost[x][y]>cur){
            cost[x][y] = cur+key[x][y];
            return true;
        }
        return false;

    }

    static void dp(int[][] key, int[][] cost, int n,int t, int x, int y){

        ops++;
        if(n-x-1+n-1-y<3){
            //System.out.println("yo");
            cost[n-1][n-1] = Math.min(cost[n-1][n-1],cost[x][y]+t*(n-x-1+n-y-1));
        }
        if(n-x-1+n-1-y==3){
            cost[n-1][n-1] = Math.min(cost[n-1][n-1],cost[x][y]+t*(n-x+n-y)+cost[n-1][n-1]);

        }

        for(int i = -3;i<=3;i++){
            int j = 3-Math.abs(i);
            if(update(cost,x-i,y-j,cost[x][y]+3*t,n,key)){
                dp(key,cost,n,t,x-i,y-j);
            }
            if(update(cost,x-i,y+j,cost[x][y]+3*t,n,key)){
                dp(key,cost,n,t,x-i,y+j);
            }

        }
        for(int i = -1;i<=1;i++){
            int j = 1-Math.abs(i);
            if(update(cost,x-i,y-j,cost[x][y]+3*t,n,key)){
                dp(key,cost,n,t,x-i,y-j);
            }
            if(update(cost,x-i,y+j,cost[x][y]+3*t,n,key)){
                dp(key,cost,n,t,x-i,y+j);
            }

        }


    }
    static void dp2 (int[][] dp,int[][] a, int d, int r, int c, int t){
        //System.out.println(d+" "+r+" "+c);

        if (d != dp[r][c]) {
            return;
        }
        ops++;
        int n = a.length;
        int dist = Math.abs(n - 1 - r) + Math.abs(n - 1 - c);

            //System.out.println("yo");
        if(dist<=2) {
            dp[n - 1][n - 1] = Math.min(dp[n - 1][n - 1], d + dist * t);

        }

        for (int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n ||
                    dp[nr][nc] <= d + a[nr][nc] + 3 * t) {
                continue;
            }
            dp[nr][nc] = d + a[nr][nc] + 3 * t;
            dp2(dp,a,dp[nr][nc],nr,nc,t);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("visitfj.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("visitfj.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] costs = new int[n][n];
        int[][] keys = new int[n][n];
        for(int i = 0; i<n;i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j<n;j++){
                costs[i][j] = Integer.parseInt(st.nextToken());
                keys[i][j] = -1;
            }
        }
        keys[0][0] = 0;
        //dp2(keys,costs,0,0,0,t);
        dp(costs,keys,n,t,0,0);
        out.println(keys[n-1][n-1]);
        System.out.println(ops);
        System.out.println(keys[n-1][n-1]);

        out.close();
    }




}
