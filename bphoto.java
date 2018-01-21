import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by supersteve on 1/14/18.
 */
public class bphoto {
    static boolean isbiggerthanafactoroftwo(int one, int two){
        double x = (double)one/(double) two;
        return x<1.0/3.0||x>2.0/3.0;
    }
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("bphoto.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));

        int n = Integer.parseInt(f.readLine());
        ArrayList<pair> s = new ArrayList<pair>();
        for(int i = 0; i<n;i++){
            s.add(new pair(i,Integer.parseInt(f.readLine())));
        }
        Collections.sort(s);
        int[] bit = new int[n+1];
        int count = 0;
        for(int i = 0; i<n;i++){
            pair cur = s.get(i);
            int onleft = getSum(bit,cur.index);
            System.out.println(onleft+ " "+(i-onleft));
            if (isbiggerthanafactoroftwo(onleft,i)){

                count++;
            }
            updateBIT(bit,cur.index, 1);
        }
        out.println(count);


        out.close();

    }
    static void updateBIT(int BITree[], int index, int val)
    {
        int n = BITree.length;
        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse all ancestors and add 'val'
        while (index <= n)
        {
            // Add 'val' to current node of BI Tree
            BITree[index] += val;

            // Update index to that of parent in update View
            index += index & (-index);
        }
    }
    /**
     * Start from index+1 if you want prefix sum 0 to index. Keep adding value
     * till you reach 0
     */
    static int getSum(int binaryIndexedTree[], int index) {
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }

    static int getParent(int index){
        return index - (index & -index);
    }

    /**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */
    static int getNext(int index){
        return index + (index & -index);
    }

    static class pair implements Comparable<pair>{
        int index;
        int value;
        pair(int ind, int val){
            index = ind;
            value = val;
        }

        @Override
        public int compareTo(pair pair) {
            return pair.value-this.value;
        }
    }

}
