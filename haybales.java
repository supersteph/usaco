
import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class set{
    int start;
    int end;
    int num;
}

public class haybales {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] at = new int[n];

        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i< n; i++){
            at[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(at);
        for(int i: at){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println();

        ArrayList<set> m = new ArrayList<set>();
        for(int i = 0; i<q;i++){
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int startind = Arrays.binarySearch(at,start);
            int endind = Arrays.binarySearch(at,end);
            System.out.println(startind+" "+endind);
            if(startind<0){
                startind+=1;
                startind = -startind;
            }

            if(endind<0){
                endind= endind+2;
                endind = -endind;


            }
            System.out.println(startind+" "+endind);
            out.println(endind - startind+1);
        }



        out.close();


    }
}