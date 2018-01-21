import java.io.*;
import java.util.*;

/**
 * Created by supersteve on 1/14/18.
 */
public class piepie {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("bphoto.in"));

        // input file name goes above

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


    }

    static class pair{
        int index;
        int val;
    }

}
