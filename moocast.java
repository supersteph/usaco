
import java.io.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
class node{
    int x;
    int y;
    int pow;

    @Override
    public String toString() {
        return x+" "+y+" "+pow;
    }
}

public class moocast {
    public static boolean canreach(node start, node end){
        if(Math.sqrt(Math.pow((start.x-end.x),2)+Math.pow((start.y-end.y),2))<=start.pow){
            return true;
        }
        return false;
    }
    public static int flow(ArrayList<node> unvisted, node cur){
        int count = 1;
        if(unvisted.size()==0){
            return 2;
        }
        for(int i = 0; i<unvisted.size();i++){
            node s = unvisted.get(i);
            if(canreach(cur,s)){
                unvisted.remove(i);
                i--;
                count+=flow(unvisted,s);
                //unvisted.add(s);
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));

        int num = Integer.parseInt(f.readLine());
        ArrayList<node> ad = new ArrayList<node>();


        out.close();


    }
}