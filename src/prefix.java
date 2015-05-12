import java.io.*;
import java.lang.Integer;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Exchanger;
/*
ID: xiaoyun4
LANG: JAVA
TASK: prefix
*/

public class prefix {
    public static int count = 0;
    public static void print(boolean[] x){
        for(boolean m:x){
            if(m) {
                System.out.print(1);
            }else{
                System.out.print(0);
            }
        }
        System.out.println();
    }

    public static void getPrefix(String compare,ArrayList<String> prim,int idx, int pidx){

        //System.out.println(pidx);
        if(idx+prim.get(pidx).length()>compare.length()){
            return;
        }
        if(!compare.substring(idx,idx+prim.get(pidx).length()).equals(prim.get(pidx))){
            return;
        }
        if(idx+prim.get(pidx).length()>count){
            count = idx+prim.get(pidx).length();
        }
        for(int i = 0; i<prim.size();i++){
            getPrefix(compare,prim,idx+prim.get(pidx).length(),i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        ArrayList<String> prim = new ArrayList<String>();
        String line = f.readLine();
        while(!line.equals(".")) {
            //System.out.println(line);
            StringTokenizer st= new StringTokenizer(line);
            while(st.hasMoreTokens()){
                prim.add(st.nextToken());
            }
            line = f.readLine();
        }
        //String x = f.readLine();
        String compare = "";
        String nextLine = f.readLine();
        while(nextLine!=null){

            compare+=nextLine;
            nextLine = f.readLine();
        }

        for(int i = 0; i<prim.size();i++){
            getPrefix(compare,prim,0,i);
        }
        out.println(count);


        //System.out.println(sum("010"));


        //int[] l = {0,1,0};
        //int[] k = {1,0,1};
        //ArrayList<confg> test = new ArrayList<confg>();
        //test.add(new confg(l,0));
        //test.add(new confg(k,0));
        //quicksort(0, 1,test);

        //System.out.println(everything.contains(x));









        //out.println(i);

        out.close();
        System.exit(0);



    }
}