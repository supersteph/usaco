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

    public static void getIt(int index, int diff, int sum, boolean tracked){
        if(index==max/2+1){
            int k = contains(index,diff);
            if(k!=-1){
                x.get(k)[3] ++;
            }
            else{
                //System.out.println("yo");
                tracked = true;
                int[] placeholder = {diff,sum,0,1};
                x.add(placeholder);

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

        getIt(index+1,diff+index, sum-index, tracked);
        getIt(index+1,diff-index, sum - index,tracked);




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

        getIt(2,1,sum-1, false);

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