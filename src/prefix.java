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

    public static boolean equals(String c, String p, int idx) {
        if(idx+p.length()>c.length()){
            return false;
        }

        for (int i = 0; i < p.length(); ++i) {
            if (c.charAt(idx+i) != p.charAt(i)) return false;
        }
        return true;
    }


    public static int getPrefix(ArrayList<String> comp, String compare){
        int max = 0;
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(0);
        while(x.size()!=0){
            if(x.get(0)>max){
                max = x.get(0);
            }
            for(String i:comp){
                if(x.get(0)+i.length()<=compare.length()&&!x.contains( x.get(0) + i.length())) {
                    if (compare.substring(x.get(0), x.get(0) + i.length()).equals(i)) {
                        x.add(x.get(0) + i.length());
                    }
                }
            }
            x.remove(0);
        }

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

        //HashMap<Integer,Integer> x = new HashMap<Integer, Integer>();

        int count = getPrefix(prim,compare);
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