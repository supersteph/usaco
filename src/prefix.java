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
    public static HashSet<Integer> all = new HashSet<Integer>();


    public static int getPrefix(String compare,ArrayList<String> prims,int idx, HashSet visited){
        //compare is the string that i am trying to make the prefix out of
        //prim is all of the primitives
        //idx is the place you are currently
        //visited is all of the places that i have gone to
        System.out.println(visited);

        if (visited.contains(idx)) return idx;
        //if it contains it, then i return where i am currently
        System.out.println(idx);
        int max = idx;
        for(int i = 0; i<prims.size();i++){
            String prim = prims.get(i);
            if (compare.indexOf(prim,idx) == idx) {
                int len = getPrefix(compare, prims, idx+prim.length(), visited);
                if (len > max) max = len;
            }
        }
        visited.add(idx);
        return max;
        //return the maximum len
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

        int count = getPrefix(compare,prim,0,new HashSet());
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