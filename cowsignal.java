
import java.io.*;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i<x;i++){
            String m = f.readLine();
            for(int l = 0; l<k;l++) {

                for (int j = 0; j<m.length();j++) {
                    char lm = m.charAt(j);
                    for(int hehe = 0; hehe<k;hehe++){
                        out.print(lm);
                    }
                }
                out.println();
            }
        }

        out.close();


    }
}