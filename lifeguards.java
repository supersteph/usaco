import java.io.*;
import java.util.*;

/**
 * Created by supersteve on 1/14/18.
 */
public class lifeguards {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));

        // input file name goes above
        int n = Integer.parseInt(f.readLine());
        int[][] indexes = new int[n][2];

        int[] stuff = new int[10001];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            indexes[i][0] = Integer.parseInt(st.nextToken());
            indexes[i][1] = Integer.parseInt(st.nextToken());
            for (int j = indexes[i][0]; j < indexes[i][1]; j++) {
                if (stuff[j] == 0) {
                    sum++;
                }
                stuff[j]++;
            }

        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curnum = 0;
            for (int j = indexes[i][0]; j < indexes[i][1]; j++) {
                if (stuff[j] == 1) {
                    curnum++;
                }

            }

            min = Math.min(min,curnum);


        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        out.println(sum-min);

        out.close();
    }

}
