

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class pairup {

    public static int largest(int[] dingo){
        int current = dingo[0];
        for (int j=0; j<dingo.length - 1; j++){
            if (dingo[j] > current){
                current = dingo[j];
            }
        }
        return current;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fagr = new Scanner(new File("pairup.in"));
        int milkOutputs = fagr.nextInt();
        pair[] stuff = new pair[milkOutputs];
        for (int i=0; i<milkOutputs; i++){
            int times = fagr.nextInt();
            int output = fagr.nextInt();
            pair x = new pair();
            x.count = times;
            x.time = output;
            stuff[i] = x;
        }
        Arrays.sort(stuff);
        int x = 0;
        int y = milkOutputs-1;


        int max = 0;
        while(x<y){
            if(stuff[x].count>stuff[y].count){
                stuff[x].count-=stuff[y].count;
                max = Math.max(max,stuff[x].time+stuff[y].time);
                y--;
            }
            else if(stuff[y].count>stuff[x].count){
                stuff[y].count-=stuff[x].count;
                max = Math.max(max,stuff[x].time+stuff[y].time);
                x++;
            }
            else{
                if(x==y){
                    max = Math.max(max,2*stuff[x].time);
                    break;
                }
                else {
                    max = Math.max(max,stuff[x].time+stuff[y].time);
                    x++;
                    y--;

                }
            }
        }



        PrintWriter writer = new PrintWriter("pairup.out");
        writer.println(max);
        writer.close();

    }
    static class pair implements Comparable<pair>{
        int count;
        int time;

        @Override
        public int compareTo(pair pair) {
            return this.time-pair.time;
        }
    }

}