
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class circlecross {

    static private void update(int[] arr, int pos, int val)
    {
        int len = arr.length;
        for (; pos < len; pos |= (pos + 1))
            arr[pos] += val;
    }
    
    static private int query(int[] arr, int pos)
    {
        int sum = 0;
        for (; pos >= 0; pos = (pos & (pos + 1)) - 1)
            sum += arr[pos];

        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("circlecross.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        int n = Integer.parseInt(f.readLine());

        pair[] pairs = new pair[n];

        for(int i = 0; i<2*n;i++){
            int ind = Integer.parseInt(f.readLine());
            if(pairs[ind-1]!=null){
                pairs[ind-1].y= i;
            }
            else {
                pairs[ind-1] = new pair();
                pairs[ind-1].x = i;
            }
        }


        Arrays.sort(pairs);
        //FAST METHOD
        int count = 0;
        int[] bit = new int[2*n+1];
        for(int i =0;i<n;i++){
            int start = pairs[i].x;
            int end = pairs[i].y;
            count+= query(bit,end)-query(bit,start);
            update(bit,end,1);
        }
        out.println(count);
        System.out.println(count);


        /*
        SLOW METHOD
        int count = 0;
        for(int i =0; i<n;i++){
            for(int j =i+1; j<n;j++){
                int startfirst = pairs[i][0];
                int endfirst = pairs[i][1];
                int startsecond = pairs[j][0];
                int endsecond = pairs[j][1];

                if(startfirst>startsecond){
                    if(endfirst>endsecond&&startfirst<endsecond){
                        count++;
                    }
                }
                else if (startfirst<startsecond){
                    if(endfirst<endsecond&&startsecond<endfirst){
                        count++;
                    }
                }

            }
        }
        out.println(count);
        System.out.println(count);
        */
        out.close();
    }

    static class pair implements Comparable<pair> {
        int x;
        int y;

        @Override
        public int compareTo(pair pair) {
            return this.x-pair.x;
        }
    }



}
