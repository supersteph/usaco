
import java.io.*;

import java.util.*;

public class lasers {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("lasers.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lasers.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int count = Integer.parseInt(st.nextToken());
        int startx = Integer.parseInt(st.nextToken());
        int starty = Integer.parseInt(st.nextToken());
        int endx = Integer.parseInt(st.nextToken());
        int endy = Integer.parseInt(st.nextToken());

        HashSet<Integer> seeny = new HashSet<Integer>();
        


        out.close();
    }

}