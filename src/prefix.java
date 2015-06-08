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
        //go through all the chars, and if any of the chars aren't equal then you return false

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


    public static int getPrefix(ArrayList<primitive> comp, String compare, int idx){
        //System.out.println();

        boolean[] x = new boolean[compare.length()+1];
        // new boolean of all falses
        int max=0;
        for(int i = 0; i<x.length;i++){

            //print(x);
            // goes through all the integers in the array
            if(i>max){
                // if you are past the max, then you know you went too far so you return max
                return max;
            }
            if(x[i]!=true&&i!=0){
                continue;
            }
            else{
                // other wise you go through all the primitives
                if(idx==-1){
                    for(primitive v:comp){
                        //System.out.println(v+" "+i);

                        String p = v.x;
                        //check to see if your gonna go too far
                        if(i+p.length()>compare.length()){
                            continue;
                        }
                        //if you already explored this one, then you continue
                        if(x[i+p.length()]==true){
                            continue;
                        }
                        // if the primitive is equal to the current substring starting at index then you set x[i+p.length] as explored
                        if(equals(compare,p,i)){
                            x[i+p.length()]= true;
                            //if your past max, you make max bigger
                            if(i+p.length()>max){
                                max = i+p.length();
                            }
                        }
                    }
                } else{
                    for(int j = idx;j<comp.size();j++){
                        //System.out.println(v+" "+i);


                        String p = comp.get(j).x;
                        //check to see if your gonna go too far
                        if(i+p.length()>compare.length()){
                            continue;
                        }
                        //if you already explored this one, then you continue
                        if(x[i+p.length()]==true){
                            continue;
                        }
                        // if the primitive is equal to the current substring starting at index then you set x[i+p.length] as explored
                        if(equals(compare,p,i)){
                            x[i+p.length()]= true;
                            //if your past max, you make max bigger
                            if(i+p.length()>max){
                                max = i+p.length();
                            }
                        }
                    }
                }
            }
        }
        //return the max

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
        ArrayList<primitive> p = new ArrayList<primitive>();
        p.add(new primitive("A"));
        p.add(new primitive("B"));
        //System.out.println(togetridof(p,"A",0));


        for(int i = 0; i< prim.size()-1;i++){

            primitive m = prim.get(i);

            //System.out.println(i);
            //System.out.println(m);
            String x = m.x;
            prim.remove(i);
            //System.out.println(prim);
            if(getPrefix(prim,x,i+1)!=x.length()){
                prim.add(i, m);
            } else{
                //System.out.println(x);
                i--;
            }
        }




        //System.out.println(prim);

        //System.out.println(prim);

        //HashMap<Integer,Integer> x = new HashMap<Integer, Integer>();

        int count = getPrefix(prim,compare,-1);
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