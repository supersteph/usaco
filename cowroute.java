
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class cowroute {


    static pair[] dijkistras(HashMap<Integer,ArrayList<pair>> key, int cur){

        pair[] costfromcur = new pair[key.size()+1];
        pair x = new pair();
        x.cost = 0;
        x.prev = -1;
        x.count = 0;
        costfromcur[cur] = x;

        LinkedList<Integer> s = new LinkedList<Integer>();
        s.add(cur);
        while (s.size()!=0){
            int curt = s.poll();
            for(int i = 0; i<key.get(curt).size(); i++) {

                pair end = key.get(curt).get(i);

                //System.out.println(curt+" "+end.count);

                if (costfromcur[curt].prev != end.prev) {
                    if (costfromcur[end.count] == null) {
                        pair hehe = new pair();
                        hehe.cost = costfromcur[curt].cost + end.cost;
                        hehe.prev = end.prev;
                        hehe.count = costfromcur[curt].count + 1;
                        costfromcur[end.count] = hehe;
                        s.add(end.count);
                    }
                    else if (costfromcur[curt].cost + end.cost < costfromcur[end.count].cost) {
                        pair hehe = new pair();
                        hehe.cost = costfromcur[curt].cost + end.cost;
                        hehe.prev = end.prev;
                        hehe.count = costfromcur[curt].count+1;
                        costfromcur[i] = hehe;
                        s.add(end.count-1);
                    } else if (costfromcur[curt].cost + end.cost == costfromcur[end.count].cost && costfromcur[curt].count + end.count < costfromcur[end.count].count) {
                        pair hehe = new pair();
                        hehe.cost = costfromcur[curt].cost + end.cost;
                        hehe.prev = end.prev;
                        hehe.count = costfromcur[curt].count+1;
                        costfromcur[i] = hehe;
                        s.add(end.count-1);
                    }

                }

            }

        }
        return costfromcur;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("cowroute.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        HashMap<Integer,ArrayList<pair>> stuff = new HashMap<Integer, ArrayList<pair>>();
        int[] costs = new int[num];
        for(int i = 0; i < num ; i++){
            st = new StringTokenizer(f.readLine());
            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;
            int count = Integer.parseInt(st.nextToken());
            int[] s = new int[count];
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j<count;j++){

                int temp = Integer.parseInt(st.nextToken());
                s[j] = temp;

                for(int k = 0; k<j;k++){
                    if(stuff.get(s[k])==null) {
                        stuff.put(s[k],new ArrayList<pair>());
                    }
                    pair x = new pair();
                    x.cost = cost;
                    x.count = s[j];
                    x.prev = count;
                    stuff.get(s[k]).add(x);
                }
            }
        }

        pair[] m = dijkistras(stuff,start);

        if(m[end]!=null) {
            out.println(m[end].cost + " " + m[end].count);
            System.out.println(m[end].cost + " " + m[end].count);
        }
        else{
            out.println(-1+" "+(-1));
        }


        out.close();
    }
    static class pair {
        int count;
        int prev;
        int cost;

    }

}
