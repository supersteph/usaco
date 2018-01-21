
import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
class edgess implements Comparable<edgess>{
    int i;
    int j;
    int w;

    edgess(int x, int y, int z){
        i = x;
        j = y;
        w = z;
    }
    @Override
    public int compareTo(edgess edgess) {
        return w-edgess.w;
    }
}

public class moocastg {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        int n = Integer.parseInt(f.readLine());
        int[] x = new int[n];
        int[] y = new int[n];
        parent = new int[n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<edgess> edge = new ArrayList<edgess>();

        for(int i = 0; i<n; i++){
            parent[i] = i;
            for(int j=0;j<i;j++){
                edge.add(new edgess(i,j,((x[i]-x[j])*(x[i]-x[j]))+((y[i]-y[j])*(y[i]-y[j]))));
            }
        }
        Collections.sort(edge);
        int cur = 0;
        int secs = n;
        for(edgess curt : edge){

            if(fetch(curt.i)!=fetch(curt.j)){

                merge(curt.i,curt.j);
                cur = curt.w;
                if(--secs==1){
                    break;
                }
            }

        }
        out.println(cur);


        out.close();


    }
    static int[] parent;

    static int fetch (int m){
        return parent[m]==m ? m :(parent[m]=fetch(parent[m]));
    }
    static void merge (int i, int j){
        parent[fetch(i)] = fetch(j);
    }
}