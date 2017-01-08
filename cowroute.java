
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class cowroute {

    static pair[] dijkistras(HashMap<Integer,ArrayList<pair>> key, int cur, long[] cost, int max){

        pair[] costfromcur = new pair[max];



        pair x = new pair();
        x.prev = -1;
        x.count = 0;
        x.cost = 0;
        costfromcur[cur] = x;

        LinkedList<Integer> s = new LinkedList<Integer>();
        s.add(cur+1);
        while (s.size()!=0){
            int curt = s.poll();
            if(key.get(curt)!=null) {
                for (int i = 0; i < key.get(curt).size(); i++) {

                    pair end = key.get(curt).get(i);

                    long nextcost = costfromcur[curt - 1].cost;
                    if (costfromcur[curt - 1].prev != end.prev) {
                        nextcost += cost[end.prev];
                    }

                    if (costfromcur[end.count - 1] == null || costfromcur[end.count - 1].cost > nextcost) {
                        pair m = new pair();
                        m.prev = end.prev;


                        m.count = costfromcur[curt - 1].count + 1;
                        m.cost = nextcost;
                        costfromcur[end.count - 1] = m;

                        s.add(end.count);
                    }
                }
            }

        }
        return costfromcur;

    }

    /*

    costs is a 2d array with the i and jth element representing the cost to go between i and j
    
    */


    static int[] standarddijkistras(int[][] costs, int cur){

        int[] costfromcur = new int[costs.length];


        Arrays.fill(costfromcur,Integer.MAX_VALUE);
        costfromcur[cur] = 0;

        LinkedList<Integer> s = new LinkedList<Integer>();
        s.add(cur);
        while (s.size()!=0){
            int curt = s.poll();

            for(int i = 0; i<costs.length;i++){
                int cost = costs[curt][i];
                if(cost!=-1){
                    if(costfromcur[curt]+cost<costfromcur[i]){
                        costfromcur[i] = costfromcur[curt]+cost;
                        s.add(i);
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
        HashMap<Integer, ArrayList<pair>> stuff = new HashMap<Integer, ArrayList<pair>>();
        long[] costs = new long[num];
        int max = -1;
        for(int i = 0; i < num ; i++){
            st = new StringTokenizer(f.readLine());
            long cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;
            int count = Integer.parseInt(st.nextToken());
            int[] s = new int[count];
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j<count;j++){

                int temp = Integer.parseInt(st.nextToken());
                s[j] = temp;
                if(temp>max){
                    max = temp;
                }
                if(j>0) {
                    if (stuff.get(s[j-1]) == null) {
                        stuff.put(s[j-1], new ArrayList<pair>());
                    }
                    pair x = new pair();

                    x.count = s[j];
                    x.prev = i;
                    ArrayList<pair> look = stuff.get(s[j-1]);


                    boolean in = false;

                    for (int l = 0; l < look.size(); l++) {

                        if (look.get(l).count == x.count) {
                            in = true;

                            if (costs[look.get(l).prev] > costs[x.prev]) {
                                look.get(l).count = x.count;
                                look.get(l).prev = x.prev;
                            }
                            break;
                        }
                    }


                    if (!in) {
                        look.add(x);
                    }
                }


            }
        }

        pair[] m = dijkistras(stuff,start-1,costs,max);

        if(m[end-1]!=null) {
            out.println(m[end-1].cost + " " + m[end-1].count);
            System.out.println(m[end-1].cost + " " + m[end-1].count);
        }
        else{
            out.println(-1+" "+(-1));
        }


        out.close();
    }
    static class pair {
        int count;
        int prev;
        long cost;

        @Override
        public int hashCode() {
            return count;
        }
    }

}
