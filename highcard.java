import java.io.*;

import java.util.*;


public class highcard {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("highcard.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));

        int n = Integer.parseInt(f.readLine());

        ArrayList<Integer> bess = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();
        boolean[] k = new boolean[2*n];
        for(int i = 0; i<n;i++){
            k[Integer.parseInt(f.readLine())-1] = true;
        }

        for(int i = 0; i<2*n;i++){
            if(k[i]){
                other.add(i);
            }
            else {
                bess.add(i);
            }
        }
        int count = 0;
        for(int i = 0; i<bess.size();i++){
            if(bess.get(i)>other.get(count)){
                count++;
            }
        }
        out.println(count);



        out.close();


    }
}