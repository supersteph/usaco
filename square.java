

import java.io.*;
import java.util.*;
import java.lang.Integer;

public class square {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("square.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int onexone = Integer.parseInt(st.nextToken());
        int oneyone = Integer.parseInt(st.nextToken());
        int onextwo = Integer.parseInt(st.nextToken());
        int oneytwo = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());

        int twoxone = Integer.parseInt(st.nextToken());
        int twoyone = Integer.parseInt(st.nextToken());
        int twoxtwo = Integer.parseInt(st.nextToken());
        int twoytwo = Integer.parseInt(st.nextToken());

        int leftx = Math.min(onexone,twoxone);
        int rightx = Math.max(onextwo,twoxtwo);

        int lefty = Math.min(oneyone,twoyone);
        int righty = Math.max(oneytwo,twoytwo);

        out.println(Math.max(rightx-leftx,righty-lefty)*Math.max(rightx-leftx,righty-lefty));
        out.close();


    }
}
