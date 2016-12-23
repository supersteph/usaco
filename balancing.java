
import java.io.*;

import java.util.*;
import java.util.HashSet;
import java.util.StringTokenizer;


class point implements Comparable<point> {
    public int x,y;

    public point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public int compareTo(point s) {
        return x - s.x;
    }
}

public class balancing {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = Integer.parseInt(f.readLine());
        point[] list = new point[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());

            list[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())/2);
        }
        Arrays.sort(list);
        int ret = list.length;
        for(int i = 0; i < n; i++) {
            ArrayList<point> below = new ArrayList<point>();
            ArrayList<point> above = new ArrayList<point>();
            for(int j = 0; j < n; j++) {
                if(list[j].y <= list[i].y) {
                    below.add(list[j]);
                }
                else {
                    above.add(list[j]);
                }
            }
            int belowIndex = 0;
            int aboveIndex = 0;
            while(belowIndex < below.size() || aboveIndex < above.size()) {
                int xBorder = Integer.MAX_VALUE;
                if(belowIndex < below.size()) {
                    xBorder = Math.min(xBorder, below.get(belowIndex).x);
                }
                if(aboveIndex < above.size()) {
                    xBorder = Math.min(xBorder, above.get(aboveIndex).x);
                }
                while(belowIndex < below.size() && below.get(belowIndex).x == xBorder) {
                    belowIndex++;
                }
                while(aboveIndex < above.size() && above.get(aboveIndex).x == xBorder) {
                    aboveIndex++;
                }
                ret = Math.min(ret, Math.max(Math.max(belowIndex, below.size() - belowIndex), Math.max(aboveIndex, above.size() - aboveIndex)));
            }
        }


        out.close();

    }
}