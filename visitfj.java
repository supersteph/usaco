import java.io.*;
import java.util.*;


public class visitfj {
    static int dr[] = {0, 1, 2, 3, 2, 1, 0, -1, -2, -3, -2, -1, -1, 1, 0, 0};

    static int dc[] = {3, 2, 1, 0, -1, -2, -3, -2, -1, 0, 1, 2, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("visitfj.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("visitfj.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        for(int i = 0; i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        int cur = 0;

        dp[0][0] = 0;
        LinkedList<pair> places = new LinkedList<pair>();
        pair m = new pair(0,0);
        places.add(m);
        int result = Integer.MAX_VALUE;
        while (places.size()!=0) {
            pair ms = places.poll();
            int d = -ms.x;
            int r = ms.y / n;
            int c = ms.y % n;
            //System.out.println(r+" "+c);
            if (d > dp[r][c]) {
                continue;
            }

            cur++;

            int dist = Math.abs(n - 1 - r) + Math.abs(n - 1 - c);
            if (dist <= 2) {
                //System.out.println("yo");
                result = Math.min(result, d + dist * t);
            }

            for (int i = 0; i < dr.length; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n ||
                        dp[nr][nc] < d + a[nr][nc] + 3 * t) {
                    continue;
                }
                dp[nr][nc] = d + a[nr][nc] + 3 * t;
                places.addFirst(new pair(-dp[nr][nc], nr * n + nc));
            }
        }

        System.out.println(cur);
        out.println(result);
        System.out.println(result);

        out.close();
    }
    static class pair implements Comparable<pair>{
        int x;
        int y;
        pair(int i, int j){
            x = i;
            y=j;
        }
        @Override
        public int compareTo(pair pair) {
            if(pair.x==this.x){
                return this.y-pair.y;
            }
            else {
                return this.x-pair.x;
            }
        }
    }
}
