import java.io.*;
import java.util.*;

/**
 * Created by supersteve on 1/14/18.
 */
public class outofplace {
    static int bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        int count = 0;
        for(int i=0; i < n; i++){
            for(int j=i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    count++;
                    //swap elements
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return count;

    }
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));

        // input file name goes above
        int n = Integer.parseInt(f.readLine());

        int[] stuff = new int[n];
        for(int i = 0; i<n;i++){
            stuff[i] = Integer.parseInt(f.readLine());
        }
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        out.println(bubbleSort(stuff))c;

        out.close();
    }

}
