
import sun.awt.image.ImageWatched;

import javax.print.DocFlavor;
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
    public static int flow(LinkedList<node> unvisted, node cur){
        int count = 1;
        if(unvisted.size()==0){
            return count;
        }
        for(node s:unvisted){
            System.out.println(unvisted);
            if(canreach(cur,s)){
                unvisted.remove(s);
                count+=flow(unvisted,s);
                System.out.println(count);
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
        LinkedList<node> pls = new LinkedList<node>();
        for(int i = 0; i<num;i++){
            node m = new node();
            StringTokenizer st = new StringTokenizer(f.readLine());
            m.x= Integer.parseInt(st.nextToken());
            m.y = Integer.parseInt(st.nextToken());
            m.pow = Integer.parseInt(st.nextToken());
            pls.add(m);
        }
        node source = pls.pop();
        int n = flow(pls,source);
        out.println(n);
        out.close();


    }
}