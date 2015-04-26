import java.io.*;
import java.lang.Integer;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Exchanger;
/*
ID: xiaoyun4
LANG: JAVA
TASK: lamps
*/

public class lamps {
    public static int  lel = 0;


    public static class confg implements Comparable{
        boolean[] it;
        int count;
        int sum;
        public confg(boolean[] x, int m){
            //works = k;
            it = x;
            count = m;
            sum = 0;
            for(int i = 0; i<it.length;i++){
                if(it[i]==true){
                    sum= sum*2 +1;
                } else{
                    sum= sum*2;
                }

            }
            sum+= count;

        }

        @Override
        public boolean equals(Object o) {
            confg x = (confg) o;
            if(x.count!=count){
                return false;
            }
            for(int i = 0 ; i< it.length;i++){
                if(it[i]!=x.it[i]){
                    return false;
                }


            }
            return true;
        }

        @Override
        public int hashCode() {

            return sum;

        }

        @Override
        public int compareTo(Object o) {
            confg second = (confg) o;
            for (int i = 0; i < it.length; i++) {
                if (second.it[i] == true&& it[i]==false) {
                    return -1;
                }else if(second.it[i] == false && it[i]==true){
                    return 1;
                }
            }
            return 0;

        }

        @Override
        public String toString() {
            StringBuffer lel = new StringBuffer();
            for(int i = 0; i<it.length;i++){
                lel.append(it[i]);

            }
            return lel.toString();
        }
    }

    public static void getit(ArrayList<confg> stuff, confg it, int max, HashSet<confg> been){
        //System.out.print(it.count+ " ");
        //print(it.it);

        if(been.contains(it)){
            //System.out.println("dead");
            return;
        }

        been.add(it);
        if(it.count==max){
            stuff.add(it);
            return;
        }
        boolean[] l = it.it;
        button1(l);
        getit(stuff, new confg(l,it.count+1),max,been);
        button1(l);
        button2(l);
        getit(stuff, new confg(l,it.count+1),max,been);
        button2(l);
        button3(l);
        getit(stuff, new confg(l,it.count+1),max,been);
        button3(l);
        button4(l);
        getit(stuff, new confg(l,it.count+1),max,been);

    }

    public static void button1(boolean[] stuff){

        boolean[] otherstuff = stuff.clone();
        for(int i = 0; i<stuff.length;i++){
            stuff[i]=!(stuff[i]);

        }

    }

    public static void button2(boolean[] stuff){
        for(int i = 0; i<stuff.length;i+=2){
            if(i%2==0){
                //means that it is odd
                stuff[i]=!(stuff[i]);

            }
        }


        //otherstuff[otherstuff.length-1] ++;
        //System.out.println(stuff[stuff.length-1]+ " " +otherstuff[stuff.length-1]);
        //return otherstuff;
    }
    public static void button3(boolean[] stuff){

        for(int i = 1; i<stuff.length;i+=2){
            if((i+1)%2==0){
                //means that it is odd
                stuff[i]=!(stuff[i]);

            }
        }
        //otherstuff[otherstuff.length-1] ++;
        //return otherstuff;
    }

    public static void button4(boolean[] stuff){

        for(int i = 0; i<stuff.length;i+=3){
            if(i%3==0){
                //means that it is odd
                stuff[i]=!(stuff[i]);

            }
        }
        //otherstuff[otherstuff.length-1] ++;
        //return otherstuff;
    }
    public static void print(boolean[] toprint, PrintWriter out){
        for(int i = 0; i<toprint.length-1;i++){
            if(toprint[i]==true) {
                out.print(1);
            }else{
                out.print(0);
            }
        }
        if(toprint[toprint.length-1]==true) {
            out.println(1);
        }else{
            out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("lamps.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

        int n = Integer.parseInt(f.readLine());
        int count = Integer.parseInt(f.readLine());
        ArrayList<Integer> on = new ArrayList<Integer>();
        StringTokenizer ston = new StringTokenizer(f.readLine());
        int shouldbeon = Integer.parseInt(ston.nextToken());
        while(shouldbeon!=-1){
            on.add(shouldbeon);
            shouldbeon=Integer.parseInt(ston.nextToken());
        }
        ArrayList<Integer> off = new ArrayList<Integer>();
        StringTokenizer stoff = new StringTokenizer(f.readLine());
        int shouldbeoff = Integer.parseInt(stoff.nextToken());
        while(shouldbeoff!=-1){
            off.add(shouldbeoff);
            shouldbeoff = Integer.parseInt(stoff.nextToken());
        }

        boolean[] it = new boolean[n];
        for(int i = 0; i <it.length;i++){
            it[i] = true;
        }

        confg start=  new confg(it,0);


        ArrayList<confg> stuff = new ArrayList<confg>();
        HashSet<confg> contain = new HashSet<confg>();




        getit(stuff,start, count, contain);
        //quicksort(0,stuff.size()-1,stuff);
        //System.out.println(stuff);
        System.out.println(contain.size());


        //int cont = 0;
        //System.out.println(stuff.size());
        System.out.println(stuff.size());
        outerloop:
        for(int i = 0; i<stuff.size();i++){
            //System.out.println(stuff+ " " + i);
            boolean[] kk = stuff.get(i).it;
            for(int j = 0; j<on.size();j++){
                if(kk[on.get(j)-1]!=true){
                    stuff.remove(i);
                    i--;
                    continue outerloop;
                }
            }
            for(int j = 0; j<off.size();j++){
                //print(kk);
                if(kk[off.get(j)-1]!=false){
                    //System.out.println("removed " +(off.get(j)-1));

                    stuff.remove(i);
                    i--;
                    continue outerloop;
                }
            }


        }



        Collections.sort(stuff);

        for(int i = 0; i< stuff.size();i++){
            print(stuff.get(i).it,out);
        }
        if(stuff.size()==0){
            out.println("IMPOSSIBLE");

        }

        System.out.println(lel);

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