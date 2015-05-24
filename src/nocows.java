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
    static int num = 0;
    static int totheight=0;
    static int all= 0;

    public static int getcount(ArrayList<ArrayList<Integer>> x){
        int sum = 0;
        for(int i = 0; i<x.size();i++){
            sum+=x.get(i).size();
        }
        return sum;
    }
    public static void print(ArrayList<ArrayList<Integer>> x){
        for(int i = 0; i<x.size();i++){
            System.out.println(x.get(i));
        }
        //System.out.println();
    }


    public static void expandpedigree(ArrayList<ArrayList<Integer>> x, int idx,int height){
        print(x);
        System.out.println(idx+ " " + height);
        if(height==totheight){
            if(getcount(x)==all){
                num++;
            }
            return;

        }

        if(idx>=x.get(height).size()){
            x.add(new ArrayList<Integer>());
            expandpedigree(x, 0, height + 1);
        }

        int k = x.get(height).get(idx);

        ArrayList<ArrayList<Integer>> m = (ArrayList<ArrayList<Integer>>)x.clone();
        m.get(height+1).add(2*k);
        m.get(height+1).add(2*k+1);

        expandpedigree(m,idx+1,height);
        expandpedigree(x,idx+1,height);





    }


    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("nocows.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        totheight=height;
        all = nodes;
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> m = new ArrayList<Integer>();
        m.add(0);
        x.add(m);
        x.add(new ArrayList<Integer>());
        expandpedigree(x,0,0);

        out.println(num);
        System.out.println(num);

        

        out.close();
        System.exit(0);



    }
}