import java.io.*;

import java.util.*;

class edge{
    ArrayList<Integer> edges;
}

public class lightson2 {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("lightson.in"));

        // input file name goes above
        int[] dx = {0, 0, -1, +1};
        int[] dy = {-1, 1, 0, 0};

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edge[][] edge = new edge[n][n];
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(f.readLine());
            int startx = Integer.parseInt(st.nextToken())-1;
            int starty= Integer.parseInt(st.nextToken())-1;
            int endx = Integer.parseInt(st.nextToken())-1;
            int endy = Integer.parseInt(st.nextToken())-1;
            if(edge[startx][starty]==null){
                edge[startx][starty] = new edge();
                edge[startx][starty].edges = new ArrayList<Integer>();
            }
            edge[startx][starty].edges.add(endx);
            edge[startx][starty].edges.add(endy);
        }

        boolean[][] on = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        LinkedList<Integer> onfrontier = new LinkedList<Integer>();
        LinkedList<Integer> offfrontier = new LinkedList<Integer>();
        on[0][0] = true;
        onfrontier.add(0);
        onfrontier.add(0);

        while(onfrontier.size()!=0) {
            int x = onfrontier.poll();
            int y = onfrontier.poll();

            if(visited[x][y]){
                continue;
            }

            visited[x][y]=true;
            if(edge[x][y]!=null) {
                for (int i = 0; i < edge[x][y].edges.size(); i += 2) {
                    int endx = edge[x][y].edges.get(i);
                    int endy = edge[x][y].edges.get(i + 1);
                    on[endx][endy] = true;
                }
            }

            for (int i = 0; i < 4; i++) {
                int xd = x + dx[i];
                int yd = y + dy[i];
                if (xd >= 0 && xd < n && yd >= 0 && yd < n) {
                    if (on[xd][yd]) {
                        onfrontier.add(xd);
                        onfrontier.add(yd);
                    } else {
                        offfrontier.add(xd);
                        offfrontier.add(yd);
                    }
                }
            }

            if (onfrontier.size() == 0) {
                int offsize = offfrontier.size()/2;
                for (int i = 0; i < offsize; ++i) {
                    int fx = offfrontier.poll();
                    int fy = offfrontier.poll();
                    if (on[fx][fy]) {
                        onfrontier.add(fx);
                        onfrontier.add(fy);
                    } else {
                        offfrontier.add(fx);
                        offfrontier.add(fy);
                    }
                }
            }
        }


        int count = 0;
        for(boolean[] x: on){
            for(boolean my:x){
                if(my){
                    count++;
                    System.out.print(1);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        out.println(count);
        out.close();


    }
}