
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class visitfj {
    static int dr[] = {0, 1, 2, 3, 2, 1, 0, -1, -2, -3, -2, -1, -1, 1, 0, 0};

    static int dc[] = {3, 2, 1, 0, -1, -2, -3, -2, -1, 0, 1, 2, 0, 0, -1, 1};

    static void dp2 (int[][] dp,int[][] a, int d, int r, int c, int t){

        if (d != dp[r][c]) {
            return;
        }
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
                keys[i][j] = Integer.MAX_VALUE;
            }
        }
        keys[0][0] = 0;
        dp2(keys,costs,0,0,0,t);
        out.println(keys[n-1][n-1]);
        out.close();
    }




}
