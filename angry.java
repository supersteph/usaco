
import sun.awt.image.ImageWatched;

import javax.print.DocFlavor;
import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class angry {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("angry.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

        //StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] locations = new int[n];
        for(int i = 0; i < n; i++) {
            locations[i] = Integer.parseInt(f.readLine());
        }

        Arrays.sort(locations);

        int min = 0;
        int max = 500000000;
        while(min != max) {
            int mid = (min + max) / 2;
            int used = 0;
            int last = 0;
            while (last < n) {
                used++;
                int curr = last + 1;
                while (curr < n && locations[curr] - locations[last] <= 2 * mid) {
                    curr++;
                }
                last = curr;
            }
            if (used <= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        out.println(min);
        out.close();

    }
}