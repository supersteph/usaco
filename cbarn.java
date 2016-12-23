
import java.io.*;

import java.util.ArrayList;
import java.util.StringTokenizer;

class cows{
    int shifted;
    int count;
}

public class cbarn {
    static void print(cows[] n){
        for(int i = 0; i<n.length;i++){
            System.out.print(n[i].count+" ");
        }
        System.out.println();
    }
    static void dostuff(cows[] stuff, int cur){
        //print(stuff);
        System.out.println("cur = "+cur);
        cows m = stuff[cur];
        int curshift = 0;
        for(int i = 0; i<m.count;i++){

            cows tobemapped = stuff[(m.shifted+i+cur)%stuff.length];
            if(tobemapped.count>0&&m.shifted+i!=0){

                tobemapped.shifted += m.shifted + m.count + curshift - 1;
                    //System.out.println(cur+i);
                curshift += tobemapped.count - 1;
                dostuff(stuff, (m.shifted + cur + i) % stuff.length);

            }
            cows newone = new cows();
            newone.count = 1;
            newone.shifted = i+m.shifted;
            stuff[(m.shifted+cur+i)%stuff.length]= newone;
        }

    }
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));

        // input file name goes above

        BufferedWriter out = new BufferedWriter(new FileWriter("cbarn.out"));

        int k = Integer.parseInt(f.readLine());
        cows[] stuff = new cows[k];

        for(int i = 0; i<k;i++){
            int lmao = Integer.parseInt(f.readLine());
            stuff[i] = new cows();
            stuff[i].count=lmao;
        }
        for(int i = 0; i<k;i++){
            if(stuff[i].count>1) {
                if(i==7){
                    System.out.println("yo");
                }
                print(stuff);
                dostuff(stuff, i);
            }
        }
        int count = 0;
        print(stuff);

        for(cows m:stuff){
            count+=m.shifted*m.shifted;
        }

        out.write(count+"\n");
        System.out.println(count);
        out.close();

    }
}