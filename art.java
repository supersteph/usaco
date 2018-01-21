import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class art {

    public static void print(int[][] map){
        for(int i = 0 ;i <map.length;i++){
            for (int j = 0; j<map.length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("art.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));

        int n = Integer.parseInt(f.readLine());

        StringTokenizer st = new StringTokenizer(f.readLine());

        int[][] map = new int[n][n];
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            if(i!=n-1) {
                st = new StringTokenizer(f.readLine());
            }
        }

        int count = 0;
        while(true){
            boolean[] colors = new boolean[n*n];
            ArrayList<int[]> stuff = new ArrayList<int[]>();
            for(int i = 0; i<n;i++){
                for(int j = 0; j<n;j++){

                    if(map[i][j]==-1||(map[i][j]!=0&&colors[map[i][j]-1])){
                        int[] m = flood(map,i,j);
                        if(map[i][j]!=-1) {
                            colors[map[i][j] - 1] = true;
                        }
                        else {

                        }
                        if(m[0]==0){
                            continue;
                        }

                        stuff.add(m);
                    }
                }
            }

            if(stuff.size()==0){
                break;
            }
            count++;
            print(map);
            for(int[] k:stuff){
                int startx = k[1];
                int endx = k[2];
                int starty = k[3];
                int endy = k[4];
                for(int i = startx;i<=endx;i++){
                    for(int j = starty; j<=endy;j++){
                        map[i][j]=-1;
                    }
                }
            }
        }

        out.println(count);


        out.close();
    }

    public static int[] flood(int[][] map, int x, int y) {
        if(x==1&&y==1){









            System.out.println();
        }
        int cur = 0;
        int width = x;
        int widthneg = x;
        int len = y;
        int lenneg = y;
        if(map[x][y]!=-1) {
            boolean turnedoff = false;
            for (int i = x + 1; i < map.length; i++) {
                if (map[i][y] == map[x][y]) {
                    width = i;
                    widthneg = i;
                    if (turnedoff) {
                        int[] m = {0, -1, -1};
                        return m;
                    }
                } else if (map[i][x] == -1) {
                    widthneg = i;
                } else {
                    turnedoff = true;
                }
            }
            turnedoff = false;
            for (int i = y + 1; i < map.length; i++) {
                if (map[x][i] == map[x][y]) {
                    len = i;
                    lenneg = i;
                    if (turnedoff) {
                        int[] m = {0, -1, -1};
                        return m;
                    }
                } else if (map[x][i] == -1) {
                    lenneg = i;
                } else {
                    turnedoff = true;
                }
            }
        }
        else{
            boolean turnedoff = false;
            for (int i = x + 1; i < map.length; i++) {
                if (map[i][y] == map[x][y]) {
                    width = i;
                    widthneg = i;
                    if (turnedoff) {
                        int[] m = {0, -1, -1};
                        return m;
                    }
                }
                else if (map[i][x] == -1) {
                    widthneg = i;
                }
                else {
                    if(turnedoff==false&&map[x][y]==-1){
                        cur = map[i][y];
                        map[x][y] = map[i][y];
                        width = i;
                        widthneg = i;
                    }
                    else if(turnedoff == false){
                        turnedoff = true;
                    }
                    else{
                        int[] m = {0};
                        return m;
                    }
                }
            }
            map[x][y]=-1;
            turnedoff = false;
            for (int i = y + 1; i < map.length; i++) {
                if (map[x][i] == map[x][y]) {
                    len = i;
                    lenneg = i;
                    if (turnedoff) {
                        int[] m = {0, -1, -1};
                        return m;
                    }
                }
                else if (map[x][i] == -1) {
                    lenneg = i;
                }
                else {
                    if(turnedoff==false&&map[x][y]==-1){
                        if(map[x][i]!=cur){
                            int[] m = {0};
                            return m;
                        }
                        map[x][y] = map[i][y];
                        width = i;
                        widthneg = i;
                    }
                    else if(turnedoff == false){
                        turnedoff = true;
                    }
                    else{
                        int[] m = {0};
                        return m;
                    }
                }
            }

        }
        map[x][y]=-1;

        for(int i = x+1; i<map.length;i++){
            for(int j = y+1; j<map.length;j++){
                if(map[i][j]!=map[x][y]&&i<width&&j<len||map[i][j]==-1){

                }
                else if (map[i][j]==map[x][y]){
                    if(i>width&&widthneg>i){
                        width=i;
                    }
                    if(j>len&&lenneg>j){
                        len=j;
                    }
                }
                else{
                    if(i<=width&j<=len){
                        int[] m = {0};
                        return m;
                    }
                    if(i>width&&i<=widthneg){
                        widthneg = i-1;
                    }
                    if(j>len&&j<=lenneg){
                        lenneg = i-1;
                    }

                }
            }
        }
        int[] m = {1,x,width,y,len,cur};
        return m;

    }
}