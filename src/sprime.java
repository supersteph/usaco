/*
ID: xiaoyun4
LANG: JAVA
TASK: sprime
*/

import java.io.*;
import java.util.*;
public class sprime {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String group = f.readLine();
        int gc= group.length();
        String comet = f.readLine();
        int cc = comet.length();
        int gn = 0;
        int gtotal = 1;
        char a = 'A';
        for(int i=0;i<gc;i++)
        {

            char x = Character.toLowerCase(group.charAt(i));



            gtotal *= (int)x-(int)'a'+1;


        }

        int gnum= gtotal%47;
        int cn = 0;

        int ctotal = 1;
        for(int i=0;i<cc;i++)
        {
            char x = Character.toLowerCase(comet.charAt(i));
            ctotal *= (int)x-'a'+1;


        }
        int cnum= ctotal%47;
        if(cnum==gnum) {
            out.println("GO");

        } else {
            out.println("STAY");
        }
        out.close();
        System.exit(0);

    }
}
