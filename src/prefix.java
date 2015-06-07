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

        for (int i = 0; i < p.length(); ++i) {
            if (c.charAt(idx+i) != p.charAt(i)) return false;
        }
        return true;
    }

    public static class primitive implements Comparable{
        String x;
        primitive(String stuff){
            x = stuff;
        }

        @Override
        public String toString() {
            return x;
        }

        @Override
        public int compareTo(Object o) {
            primitive k = (primitive)o;

            return k.x.length()-x.length();
        }
    }

    public static void print(boolean[]y){
        for(boolean x:y){
            if(x){
                System.out.print(1);
            } else{
                System.out.print(0);
            }
        }
        System.out.println();
    }


    public static int getPrefix(ArrayList<primitive> comp, String compare){

        boolean[] x = new boolean[compare.length()+1];
        int max=0;
        for(int i = 0; i<x.length;i++){
            System.out.println(i);
            //System.out.println(max+ " "+ i);
            if(x[i]==true){
                //System.out.println(x[i]);
                continue;
            }
            else if(i>max){
                return max;
            }
            else{
                for(primitive v:comp){
                    System.out.println(v+ " "+ i + " " + max);
                    print(x);

                    String p = v.x;
                    if(i+p.length()>compare.length()){
                        continue;
                    }
                    if(x[i+p.length()]==true){
                        continue;
                    }
                    if(equals(compare,p,i)){
                        x[i]= true;
                        //x[i+p.length()] = true;
                        if(i+p.length()>max){
                            max = i+p.length();
                        }
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        ArrayList<primitive> prim = new ArrayList<primitive>();
        String line = f.readLine();
        while(!line.equals(".")) {
            //System.out.println(line);
            StringTokenizer st= new StringTokenizer(line);
            while(st.hasMoreTokens()){
                prim.add(new primitive(st.nextToken()));
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

        Collections.sort(prim);

        System.out.println(prim);

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