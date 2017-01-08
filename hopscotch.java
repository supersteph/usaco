import java.io.*;

import java.util.*;


public class hopscotch {

    public static void dp(int x, int y, int[][] dp,boolean[][] visited, int[][] keys, int r, int c){
        int curkey = keys[x][y];
        //get what you are currently standing on
        int count = 0;
        //count is the summation of all the pathes
        for(int i = x+1; i < r-1; i++) {
            for(int j = y+1; j < c-1; j++) {
                //go through the next right column to the end and the next down column to the bottom
                if(keys[i][j] != curkey){
                    //if you find a key that isn't equal to the one you're standing on then you add it to the total count
                    if(!visited[i][j]) {
                        //if you haven't
                        dp(i,j,dp,visited,keys,r,c);
                        visited[i][j] = true;
                    }
                    count += dp[i][j];
                    count %=1000000007;
                }
            }
        }
        if(keys[r-1][c-1] != curkey) {
            dp[x][y] = (count + 1)%1000000007;
            //if you can jump directly to the end then you have an extra path
        } else {
            dp[x][y] = count;
            //otherwise you just have the count
        }
    }

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("hopscotch.in"));



        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[r][c];

        int[][] keys = new int[r][c];
        for(int i = 0; i<r;i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j<c;j++){
                keys[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] stuff = new boolean[r][c];
        dp(0,0,dp,stuff,keys,r,c);
        System.out.println(dp[0][0]);
        out.println(dp[0][0]);
        out.close();
    }
}