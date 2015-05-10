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

    public static boolean[] getPrefix(String compare,ArrayList<String> prim,int pidx,boolean[]everything){
        if(pidx==prim.size()){
            return everything;
        }
        String primi = prim.get(pidx);
        for(int j = 0; j<=compare.length()-primi.length();j++){
            //goes through all chars in the sequence
            System.out.println(compare.substring(j,j+primi.length())+" "+primi);
            //print out whats being compared
            if(compare.substring(j,j+primi.length()).equals(primi)){
                //if the two strings are equal then you add the stuff to everything
                for(int k = j ; k<j+primi.length();k++){
                    //goes through everything in there
                    everything[k] = true;
                    // set it to true;

                }
            }

            //test
        }

        getPrefix(compare,prim,pidx+1,everything);
        return everything;

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
        boolean[] stuff= new boolean[compare.length()];

        boolean[] everything = getPrefix(compare,prim,0,stuff);
        //System.out.println(everything);
        //print(everything);


        //int max = 0;
        int sum = 0;
        for(boolean i :everything){
            if(i==true){
                sum++;
            }else{
                break;
            }
        }
        out.println(sum);


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