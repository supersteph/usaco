
import java.io.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
public class cbarn2 {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        int n = Integer.parseInt(f.readLine());
        int[] s = new int[n];
        HashSet<Integer> zeros = new HashSet<Integer>();
        for(int i = 0; i<n;i++){
            s[i] = Integer.parseInt(f.readLine());
            if(s[i]==0){
                zeros.add(i);
            }
        }
        int num = 0;
        outerloop:
        for(int end:zeros){
            int prev = 0;
            for(int i = 1; i<n+1;i++){
                if(s[(end+i)%s.length] > 1){
                    prev+=s[(end+i)%s.length]-1;
                }
                else if (s[(end+i)%s.length] < 1){
                    if(prev>0) {
                        prev--;
                    }
                    else{
                        continue outerloop;
                    }
                }

            }

            num = end;
            break;


        }

        System.out.println(num);
        int[] dup = new int[n];
        for(int i = 0; i<s.length;i++){
            dup[(i+n-num-1)%n]=s[i];
        }

        long count = 0;
        for(int j = n-1;j>0;j--){

            if(dup[j]==0){
                int cur = j-1;
                while(dup[cur]==0){
                    s[cur]=1;
                    cur--;
                }
                int counts = dup[cur];
                //end is j
                //System.out.println(cur);
                for(int i = 1; i<=counts;i++){
                    count+=(long)(i+j-counts-cur)*(i+j-counts-cur);
                    dup[i+j-counts] = 1;
                }
                if(counts<=j-cur) {
                    dup[cur] = 0;
                }
                else{
                    dup[cur]=1;
                }


            }

        }
        out.println(count);



        out.close();

    }
}