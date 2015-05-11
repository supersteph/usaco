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

    public static int getPrefix(String compare,ArrayList<String> prim,int idx, int count){
        System.out.println(count);
        if(count==compare.length()){
            return count;
        }
        if(idx>count){
            return count-1;
        }

        for(int i = 0; i<prim.size();i++){
            //System.out.println(prim.get(i)+" "+compare.substring(idx, idx + prim.get(i).length()));
            if(idx+prim.get(i).length()<compare.length()) {
                if (prim.get(i).equals(compare.substring(idx, idx + prim.get(i).length()))) {

                    if (idx + prim.get(i).length() > count) {
                        count = idx + prim.get(i).length();
                    }
                }
            }
        }



        getPrefix(compare,prim,idx+1,count);
        return count;

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

        out.println(getPrefix(compare, prim, 0, 0));


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