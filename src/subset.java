import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Exchanger;
/*
ID: xiaoyun4
LANG: JAVA
TASK: subset
*/

/**
 * Created by tooawesome on 4/4/15.
 */
public class subset {
    public static int count = 0;
    public static int max = 0;

    public static class path{
        int[] x;
        boolean shouldadd;

        public path(int[]stuff){
            x = stuff;
            shouldadd = false;
        }

        public void addtox(){
            int sum = 0;
            for(int i = 0; i<x.length;i++){
                if(x[i]>max){
                    sum-=x[i];

                }
            }
        }




    }

    public static ArrayList<int[]> x = new ArrayList<int[]>();
    public static boolean isequal(int[] first, int[] second) {
        int firstsum = 0;
        int secondsum = 0;
        for (int i = 0; i < first.length; i++) {
            firstsum += first[i];
            secondsum += second[i];
        }
        if (firstsum == secondsum) {
            return true;
        }
        return false;
    }
    public static int sum(int[]x){
        int i = 0;
        for(int j:x){
            i+=j;
        }
        return i;
    }
    public static int sum(int i, int j){
        int sum = 0;
        for(int k = i; k<=j;k++){
            sum += k;
        }
        return sum;

    }
    public static int contains(int sum, int diff){
        for(int i = 0; i<x.size();i++){
            if(x.get(i)[0]==sum&&x.get(i)[1]==0){
                return i;
            }
        }
        return -1;

    }

    public static void add(ArrayList<Integer> m, boolean l){
        int sum = 0;
        int k;
        for(int i:m){

            if(i> 0){
                sum -= i/max;
                k=i/max;
            } else{
                sum+= i;
                k = i;
            }
            //int[] a= new intp][];
            if(l) {
                int[] a = {sum, k, 1, 1};
                x.add(a);
            }
            else{
                int[] a = {sum,k,-1,1};
                x.add(a);

            }


        }
    }

    public static void getIt(int index, int diff, int sum, boolean tracked, ArrayList<Integer>m){
        for(int[] k: x){
            if(k[0]==diff&&k[1]==index){
                k[3]++;

            }
        }

        if(tracked&&Math.abs(diff) == max&&index == max){
            x.get(x.size()-1)[2]++;
            return;

        }
        //System.out.println(diff+" " +sum);
        if(index==max && Math.abs(diff) == max){
            count++;
            return;
        } else if (index==max+1){
            return;
        }
        if(Math.abs(diff)>Math.abs(sum)){
            return;
        }
        ArrayList<Integer> other = m;
        ArrayList<Integer> thing = m;
        other.add(index);
        thing.add(-index);

        getIt(index + 1, diff + index, sum - index, tracked, other);
        getIt(index+1,diff-index, sum - index,tracked,thing);




    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        int k = Integer.parseInt(f.readLine());
        //allofthem(7);

        //System.out.println(toOppo("010"));

        //out.println(allofthem(k));
        max = k;
        int sum = 0;
        for(int i =1; i<=k;i++){
            sum+=i;

        }

        getIt(2,1,sum-1, false, new ArrayList<Integer>());

        //out.println(count);
        int tot = 0;
        for(int[]ls:x){
            tot+=ls[2]*ls[3];
        }
        out.println(tot);

        out.close();
        System.exit(0);


    }
}