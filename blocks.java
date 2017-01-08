

/**
 * Created by supersteve on 12/16/16.
 */

import java.io.*;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class blocks {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        int n = Integer.parseInt(f.readLine());
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>();

        for(int i = 0; i< n;i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            a.add(st.nextToken());
            b.add(st.nextToken());
        }
        int[] c = new int[26];
        for(int i = 0; i<n;i++){
            int[] a1 = new int[26];
            int[] b1 = new int[26];
            String astring = a.get(i);
            String bstring = b.get(i);
            for(int j = 0; j<astring.length();j++){
                a1[(astring.charAt(j)-'a')] +=1;
            }
            for(int j = 0; j<bstring.length();j++){
                b1[(bstring.charAt(j)-'a')] +=1;
            }
            for(int j = 0; j<26;j++){
                c[j]+=Math.max(a1[j],b1[j]);
            }

        }

        for(int i = 0; i<26; i++){
            out.println(c[i]);
        }


        out.close();


    }
}