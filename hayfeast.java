import java.io.*;
import java.util.*;

/**
 * Created by supersteve on 1/14/18.
 */
public class hayfeast {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("bphoto.in"));

        // input file name goes above

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        pair[] x = new pair[n];
        for(int i =0; i<n;i++){
            st = new StringTokenizer(f.readLine());
            pair a = new pair();
            a.flavor = Integer.parseInt(st.nextToken());
            a.spicy = Integer.parseInt(st.nextToken());
        }
        int flavorcount = 0;
        int start = 0;

        for(int i =0; i<n;i++){
            if(flavorcount<m){
                continue;
            }
            else{

            }
        }



        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));

        out.close();

    }

    static class pair{
        int spicy;
        int flavor;
    }

}
