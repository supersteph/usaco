
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class cowroute {

    static pair lesser(pair x, pair y){
        if(x==null){
            return y;
        }
        else if (y==null){
            return x;
        }
        else if(x.cost>y.cost){
            return y;
        }
        else if(x.cost<y.cost){
            return x;
        }
        else {
            if(x.count>y.count){
                return x;
            }
            else{
                return y;
            }
        }
    }
    static pair[] tdijkistras(pair[][] key, int cur){

        pair[] costfromcur = new pair[1010];

        boolean[] visited = new boolean[1010];
        pair x = new pair();
        x.prev = -1;
        x.count = 0;
        x.cost = 0;
        costfromcur[cur] = x;


        for (int i = 0; i < 1010; i++) {
    /* Find the closest unvisited vertex. */
            int u = -1;
            for (int j = 0; j < 1010; j++) {
                if (visited[j]) {
                    continue;
                } else if (u == -1 || costfromcur[j]==null ||costfromcur[u]==null||costfromcur[j].cost < costfromcur[u].cost) {
                    u = j;
                }
                else if (costfromcur[j].cost == costfromcur[u].cost && costfromcur[j].count < costfromcur[u].count){
                    u = j;
                }
            }

    /* Relax vertex u. */
            visited[u] = true;
            for (int j = 0; j < 1010; j++) {
                if(key[u][j] != null) {
                    pair rlx = costfromcur[u];
                    if(rlx == null){
                        rlx = new pair();
                    }
                    rlx.cost += key[u][j].cost;
                    rlx.count += key[u][j].count;
                    costfromcur[j] = lesser(costfromcur[j], rlx);
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

        pair[][] lm = new pair[1010][1010];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(f.readLine());
            long route_cost = Long.parseLong(st.nextToken());
            int route_len = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(f.readLine());
            int[] route = new int[route_len];
            for (int j = 0; j < route_len; j++) {
                route[j] = Integer.parseInt(st.nextToken());

      /* Update the cost from everything before this city to this city. */
                for (int k = 0; k < j; k++) {
                    pair temp = new pair();
                    temp.cost = route_cost;
                    temp.count = j-k;
                    lm[route[k]][route[j]] = lesser(lm[route[k]][route[j]], temp);
                }
            }
        }

        pair[] m = tdijkistras(lm,start-1);

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
