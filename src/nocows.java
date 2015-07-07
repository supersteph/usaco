import java.io.*;
import java.lang.Integer;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Exchanger;
/*
ID: xiaoyun4
LANG: JAVA
TASK: nocows
*/

public class nocows {
    public static void print(int[] x){
        for(int i :x){
            System.out.print(i + " ");
        }
    }

    public static int choose(int big, int small){
        int first = 1;
        int fac = 1;
        for(int i = big; i>big-small;i--){
            first *= i;
        }
        //System.out.println(first);
        for(int i = small; i >0;i--){
            fac *=i;

        }
        //System.out.println(fac);
        return first/fac;
    }
    public static class pedi{
        int[] stuff;
        int[] counts;
        int count;
        pedi(int height){
            stuff = new int[height];
            stuff[0]=1;
            counts = new int[height];
            counts[0]=1;
            count = 0;

        }
        pedi(pedi x){
            this.stuff = x.stuff.clone();
            this.counts = x.counts.clone();
            this.count = x.count;
        }


    }
    public static int expandpedigree(int count,int height) {
        ArrayList<pedi> x = new ArrayList<pedi>();
        int sum = 0;
        x.add(new pedi(height));
        while(x.size()!=0){

            if(x.get(0).count==height-1){
                int k = 0;
                for(int i = 0; i <height;i++){
                    k+=x.get(0).stuff[i];

                }
                if(k == count){
                    int pro = 1;
                    for(int i = 0; i <height;i++){
                        pro*=x.get(0).counts[i];

                    }
                    sum+=pro;

                }
                x.remove(0);
                continue;

            }
            int m = x.get(0).stuff[x.get(0).count];

            for(int i = 2; i<=2*m;i+=2){
                pedi nex = new pedi(x.get(0));
                nex.stuff[nex.count+1] = i;
                nex.counts[nex.count+1] = choose(nex.stuff[nex.count],i/2);
                nex.count +=1;
                x.add(nex);
            }

            x.remove(0);

        }
        return sum;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("nocows.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int k = expandpedigree(nodes,height);

        System.out.println(choose(9,4));

        out.println(k);
        //System.out.println(num);


        

        out.close();
        System.exit(0);



    }
}