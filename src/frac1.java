/*
ID: xiaoyun4
LANG: JAVA
TASK: frac1
*/

/**
 * How to solve it:
 * I have go through everything that the demoninator can be, and I have a class for fraction, so i have all the fractions
 * of that demoninator from 1 to n-1 and then i can put it into a hashset and then sort it
 *
 */


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class frac1{
    public static class fraction implements Comparable<fraction>{
        int n;
        int d;
        fraction(int i, int j){
            n= i;
            d = j;
        }

        @Override
        public boolean equals(Object obj) {
            fraction f = (fraction) obj;
            if((float)n/d==(float)f.n/f.d){
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(fraction frac) {
            if((float)n/d>(float)frac.n/frac.d){
                return 1;
            }
            return -1;
        }

        @Override
        public int hashCode() {
            return 37 * n + d;
        }
        public String getFrac(){
            return n+"/"+d;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        int x = Integer.parseInt(f.readLine());
        HashSet<fraction> all = new HashSet<fraction>();
        for(int i = 0; i<=x;i++){
            for(int j = 0; j<=i;j++){
                all.add(new fraction(j,i));
            }
        }

        ArrayList<fraction> stuff = new ArrayList<fraction>(all);
        Collections.sort(stuff);
        for(int i = 0; i< stuff.size();i++){
            out.println(stuff.get(i).getFrac());
        }

        out.close();
        System.exit(0);


    }
}
