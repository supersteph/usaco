


import sun.awt.image.ImageWatched;

import java.io.*;

import java.util.*;

class edges{
    ArrayList<Integer> edges;
}

public class lightson {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("lightson.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges[][] edge = new edges[n][n];
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(f.readLine());
            int startx = Integer.parseInt(st.nextToken())-1;
            int starty= Integer.parseInt(st.nextToken())-1;
            int endx = Integer.parseInt(st.nextToken())-1;
            int endy = Integer.parseInt(st.nextToken())-1;
            if(edge[startx][starty]==null){
                edge[startx][starty] = new edges();
                edge[startx][starty].edges = new ArrayList<Integer>();
            }
            edge[startx][starty].edges.add(endx);
            edge[startx][starty].edges.add(endy);
        }

        boolean[][] on = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        LinkedList<Integer> s = new LinkedList<Integer>();
        on[0][0] = true;
        s.add(0);
        s.add(0);

        while(s.size()!=0){
            //while you still have stuff to checkc

            int x = s.poll();
            int y = s.poll();
            //get an x and y
            System.out.println(x+" "+y);
            if(visited[x][y]){
                continue;
            }
            visited[x][y] = true;
            //you've visitied it now
            if(edge[x][y]!=null) {
                for (int i = 0; i < edge[x][y].edges.size(); i += 2) {
                    int endx = edge[x][y].edges.get(i);
                    int endy = edge[x][y].edges.get(i + 1);
                    if (!on[endx][endy]) {
                        on[endx][endy] = true;

                        if (endx != 0 && on[endx - 1][endy]&&visited[endx-1][endy]) {
                            s.add(endx);
                            s.add(endy);

                        }
                        if (endy != 0 && on[endx][endy - 1]&&visited[endx][endy-1]) {
                            s.add(endx);
                            s.add(endy);

                        }
                        if (endx != n - 1 && on[endx + 1][endy]&&visited[endx+1][endy]) {
                            s.add(endx);
                            s.add(endy);
                        }
                        if (endy != n - 1 && on[endx][endy + 1]&&visited[endx][endy+1]) {
                            s.add(endx);
                            s.add(endy);
                        }

                    }
                }
            }
            if (x != 0 && on[x - 1][y]) {
                s.add(x-1);
                s.add(y);
            }
            if (y != 0 && on[x][y - 1]) {
                s.add(x);
                s.add(y-1);
            }
            if (x != n - 1 && on[x + 1][y]) {
                s.add(x+1);
                s.add(y);
            }
            if (y != n - 1 && on[x][y + 1]) {
                s.add(x);
                s.add(y+1);
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