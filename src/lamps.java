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



    public static class confg implements Comparable{
        int[] it;
        int count;
        public confg(int[] x, int m){
            //works = k;
            it = x;
            count = m;

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
            int sum = 0;
            for(int i = 0; i<it.length;i++){
                sum+=i*Math.pow(10.0,i);
            }
            sum*= count;
            return sum;

        }

        @Override
        public int compareTo(Object o) {
            confg second = (confg) o;
            for (int i = 0; i < it.length; i++) {
                if (second.it[i] > it[i]) {
                    return -1;
                }else if(second.it[i]<it[i]){
                    return 1;
                }
            }
            return 0;

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
        int[] l = it.it;
        getit(stuff, new confg(button1(l),it.count+1),max,been);
        getit(stuff, new confg(button2(l),it.count+1),max,been);
        getit(stuff, new confg(button3(l),it.count+1),max,been);
        getit(stuff,new confg(button4(l),it.count+1),max,been);

    }

    public static int[] button1(int[] stuff){
        int[] otherstuff = stuff.clone();
        for(int i = 0; i<stuff.length;i++){
            otherstuff[i]=(stuff[i]+1)%2;

        }

        //otherstuff[otherstuff.length-1] ++;

        //System.out.println(stuff[stuff.length-1]+ " " +otherstuff[stuff.length-1]);
        return otherstuff;
    }

    public static int[] button2(int[] stuff){
        int[] otherstuff = stuff.clone();
        for(int i = 0; i<stuff.length;i+=2){
            if(i%2==0){
                //means that it is odd
                otherstuff[i]=(stuff[i]+1)%2;

            }
        }


        //otherstuff[otherstuff.length-1] ++;
        //System.out.println(stuff[stuff.length-1]+ " " +otherstuff[stuff.length-1]);
        return otherstuff;
    }
    public static void print(int[]x){
        for(int k:x){
            System.out.print(k + " ");
        }
        System.out.println();

    }
    public static int[] button3(int[] stuff){
        int[] otherstuff = stuff.clone();
        for(int i = 1; i<stuff.length;i+=2){
            if((i+1)%2==0){
                //means that it is odd
                otherstuff[i]=(stuff[i]+1)%2;

            }
        }
        //otherstuff[otherstuff.length-1] ++;
        return otherstuff;
    }

    public static int[] button4(int[] stuff){
        int[] otherstuff = stuff.clone();
        for(int i = 0; i<stuff.length;i+=3){
            if(i%3==0){
                //means that it is odd
                otherstuff[i]=(stuff[i]+1)%2;

            }
        }
        //otherstuff[otherstuff.length-1] ++;
        return otherstuff;
    }
    public static void print(int[] toprint, PrintWriter out){
        for(int i = 0; i<toprint.length-1;i++){
            out.print(toprint[i]);
        }
        out.println(toprint[toprint.length-1    ]);
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

        int[] it = new int[n];
        for(int i = 0; i <it.length;i++){
            it[i] = 1;
        }

        confg start=  new confg(it,0);


        ArrayList<confg> stuff = new ArrayList<confg>();
        //HashSet<confg> contain = new HashSet<confg>();




        getit(stuff,start, count, new HashSet<confg>());
        //quicksort(0,stuff.size()-1,stuff);


        //int cont = 0;
        outerloop:
        for(int i = 0; i<stuff.size();i++){
            int[] kk = stuff.get(i).it;
            for(int j = 0; j<on.size();j++){
                if(kk[on.get(j)-1]!=1){
                    stuff.remove(i);
                    continue outerloop;
                }
            }
            for(int j = 0; j<off.size();j++){
                print(kk);
                System.out.println(off.get(j)-1);
                if(kk[off.get(j)-1]!=0){
                    System.out.println("removed");

                    stuff.remove(i);
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