import java.io.*;
import java.util.*;

/**
 * Created by supersteve on 1/14/18.
 */
public class billboard {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("billboard.in"));

        // input file name goes above
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x11 = Integer.parseInt(st.nextToken())+1000;
        int y11 = Integer.parseInt(st.nextToken())+1000;
        int x12 = Integer.parseInt(st.nextToken())+1000;
        int y12 = Integer.parseInt(st.nextToken())+1000;
        st = new StringTokenizer(f.readLine());
        int x21 = Integer.parseInt(st.nextToken())+1000;
        int y21 = Integer.parseInt(st.nextToken())+1000;
        int x22 = Integer.parseInt(st.nextToken())+1000;
        int y22 = Integer.parseInt(st.nextToken())+1000;

        int[][] grid = new int[20001][20001];

        for(int i = x11;i<x12;i++){
            for(int j = y11;j<y12;j++){
                grid[i][j] = 1;
            }
        }
        for(int i = x21;i<x22;i++){
            for(int j = y21;j<y22;j++){
                grid[i][j] = 2;
            }
        }


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        if(grid[x11][y11]==2&&grid[x12][y11]==2&&grid[x12][y12]==2&&grid[x11][y12]==2){
            out.println(0);

        }
        else if(grid[x11][y11]==2&&grid[x12][y11]==2){
            out.println(Math.abs((x11-x12)*(y12-y22)));

        }
        else if(grid[x11][y11]==2&&grid[x11][y12]==2){
            out.println(Math.abs((x11-x21)*(y12-y11)));

        }
        else if(grid[x12][y12]==2&&grid[x11][y12]==2){
            out.println(Math.abs((x11-x12)*(y11-y21)));

        }
        else if(grid[x12][y11]==2&&grid[x12][y12]==2){
            out.println(Math.abs((x12-x22)*(y12-y11)));

        }

        else{
            out.println(Math.abs((x11-x21)*(y12-y11)));
        }

        out.close();

    }
}
