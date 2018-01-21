import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cownav {


    public static int turnleft(int dir){
        dir = dir-1;
        if(dir==-1){
            return 3;
        }
        return dir;
    }
    public static int turnright(int dir){
        return dir%4;
    }
    public static int[] movefor(int x, int y, int dir, boolean[][] map){
        int[] s = new int[2];
        if(dir == 0){
            int newx = x+1;
            if(newx == map.length || map[newx][y]){
                newx--;
            }
            s[0] = newx;
            s[1] = y;

        }
        else if(dir == 1){
            int newy = y+1;
            if(newy == map.length || map[x][newy]){
                newy--;
            }
            s[0] = x;
            s[1] = newy;
        }
        else if(dir ==2){
            int newx = x-1;
            if(newx == -1 || map[newx][y]){
                newx++;
            }
            s[0] = newx;
            s[1] = y;
        }
        else {
            int newy = y-1;
            if(newy == -1 || map[x][newy]){
                newy++;
            }
            s[0] = x;
            s[1] = newy;


        }
        return s;
    }
    public static int bfs(boolean[][] map){

        ArrayList<cow> s = new ArrayList<cow>();
        cow m = new cow(0,0,0,0, 0,0);
        s.add(m);

        while(s.size()!=0){
            cow k = s.get(0);
            s.remove(0);
            System.out.println(k);

            if(k.x1 == map.length-1&& k.x2== map.length-1&& k.y1==map.length-1 &&k.y2==map.length-1){
                return k.moves;
            }

            cow lcow = new cow(k.x1,k.y1, k.x2, k.y2,turnleft(k.dir),k.moves+1);
            s.add(lcow);
            cow rcow = new cow(k.x1,k.y1, k.x2, k.y2,turnright(k.dir),k.moves+1);
            s.add(rcow);

            int[] one = movefor(k.x1,k.y1, k.dir, map);
            int[] two = movefor(k.x2, k.y2, k.dir+1%4,map);

            cow last = new cow(one[0],one[1],two[0],two[1],k.dir,k.moves+1);
            s.add(last);
        }
        return -1;



    }

    public static void main(String[] args) throws IOException {/*
        BufferedReader f = new BufferedReader(new FileReader("cownav.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownav.out")));

        int m = Integer.parseInt(f.readLine());
        boolean[][] map = new boolean[m][m];
        for(int i = 0; i <m; i++){
            String s = f.readLine();
            for(int j = 0; j<m;j++){
                if('E'==s.charAt(j)){
                    map[i][j] = false;
                }
                else if('H'==s.charAt(j)){
                    map[i][j] = true;
                }
            }
        }

        out.println(bfs(map));

        out.close();

        System.exit(0);

*/
        int m = 1;
        int n = 2;
        System.out.println(false?m:(n=3));

    }

    static class cow{
        int x1;
        int y1;

        int x2;
        int y2;

        int dir;
        int moves;
        cow (int a, int b, int c, int d, int dir, int num){
            x1 = a;
            y1 = b;
            x2 = c;
            y2 = d;
            this.dir = dir;
            moves = num;
        }

        @Override
        public String toString() {
            return x1+" "+y1+" :"+x2+" "+y2;
        }
    }


}
