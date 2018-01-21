import java.io.*;

import java.util.*;


public class censor2 {
    static String big;


    static int[] preProcessPattern(char[] ptrn) {
        int i = 0, j = -1;
        int ptrnLen = ptrn.length;
        int[] b = new int[ptrnLen + 1];

        b[i] = j;
        while (i < ptrnLen) {
            while (j >= 0 && ptrn[i] != ptrn[j]) {
                // if there is mismatch consider the next widest border
                // The borders to be examined are obtained in decreasing order from
                //  the values b[i], b[b[i]] etc.
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }

        return b;
    }

    public static int[] processpattern(char[] text, char[] ptrn) {
        int i = 0, j = -1;
        // pattern and text lengths
        //int txtLen = text.length();

        // initialize new array and preprocess the pattern
        int[] b = preProcessPattern(ptrn);
        int[] m = new int[text.length+1];

        while (i < text.length) {
            int prevj = j;
            while (j >= 0 && text[i]!=ptrn[j]) {
                j = b[j];
            }
            i++;
            j++;
            m[i] = j;
            if(j==ptrn.length){
                j=b[j];
            }

        }
        //System.out.println(js.size());
        return m;
    }
    public static void print(int[] x){
        for(int y: x){
            System.out.print(y+" ");
        }
        System.out.println();
    }
    public static void print(char[] x){
        for(char y: x){
            System.out.print(y+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("censor.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));


        char[] text = f.readLine().toCharArray();
        char[] ptrn = f.readLine().toCharArray();
        char[] textback = new char[text.length];
        char[] ptrnback = new char[ptrn.length];
        for(int i = 0; i<text.length;i++){
            textback[text.length-1-i] = text[i];
        }

        for(int i = 0; i<ptrn.length;i++){
            ptrnback[ptrn.length-1-i] = ptrn[i];
        }

        print(textback);
        print(ptrnback);
        int[] forward = processpattern(text,ptrn);
        int[] backward = processpattern(textback,ptrnback);
        for(int i = 1; i<forward.length;i++){
            if(forward[i]+backward[backward.length-i]==ptrn.length+1){

            }
        }

        out.close();


    }
}