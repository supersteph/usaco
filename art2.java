import java.io.*;
import java.util.StringTokenizer;
import java.lang.reflect.Array;
import java.util.*;
public class art2 {


    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("art2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("art2.out")));

        int n = Integer.parseInt(f.readLine());

        int[][] places= new int[n+1][2];
        for(int i = 0; i<n;i++){
            int k = Integer.parseInt(f.readLine());
            if(k!=0) {
                if (places[k][0] == 0) {
                    places[k][0] = i;
                    places[k][1] = i;
                }
                else {
                    places[k][1] = i;
                }
            }

        }
        int[] bit = new int[n+2];
        System.out.println("yo");
        for (int i = 0; i<n;i++){

            updateBIT(bit,places[i][1]+1,1);
            updateBIT(bit,places[i][0],-1);
        }
        int max = -1;
        for(int i = 0; i<n;i++){
            System.out.println(places[i][1]);
            int num = getSum(bit,places[i][1]+1)-getSum(bit,places[i][0]);
            max = Math.max(num,max);
        }

        out.println(max-1);


        out.close();
    }

    static int getSum(int BITree[], int index)
    {
        int sum = 0;
        index = index + 1;

        while (index>0)
        {
            sum += BITree[index];

            index -= index & (-index);
        }
        return sum;
    }

    static void updateBIT(int BITree[], int index, int val)
    {

        index = index + 1;


        while (index < BITree.length)
        {

            BITree[index] += val;

            index += index & (-index);
        }
    }

}