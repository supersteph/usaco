import java.io.*;

import java.util.*;


public class bcount {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("bcount.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        ArrayList<Integer> third = new ArrayList<Integer>();
        first.add(0);
        second.add(0);
        third.add(0);

        for(int i = 0; i<n;i++){
            int m = Integer.parseInt(f.readLine());
            first.add(first.get(i));
            second.add(second.get(i));
            third.add(third.get(i));
            if(m == 1){
                first.set(i+1,first.get(i)+1);
            } else if(m==2){
                second.set(i+1,second.get(i)+1);
            } else{
                third.set(i+1,third.get(i)+1);
            }
        }

        for(int i = 0; i<k;i++){
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            out.print(first.get(end)-first.get(start-1)+" ");
            out.print(second.get(end)-second.get(start-1)+" ");
            out.println(third.get(end)-third.get(start-1));
        }



        out.close();


    }
}