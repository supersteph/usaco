import java.io.*;

import java.util.*;


public class censor {
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

    public static StringBuilder searchSubString(char[] text, char[] ptrn) {
        int i = 0, j = 0;
        int k = 0;
        // pattern and text lengths
        int ptrnLen = ptrn.length;
        int textLen = text.length;
        //int txtLen = text.length();
        StringBuilder str = new StringBuilder();
        // initialize new array and preprocess the pattern
        int[] b = preProcessPattern(ptrn);
        int[] s = new int[text.length+1];
        while (i < textLen) {
            while (j >= 0 && text[k]!=ptrn[j]) {
                j = b[j];
            }
            str.append(text[k]);
            i++;
            j++;
            k++;

            // a match is found
            s[i] = j;
            if (j == ptrnLen) {
                str.replace(i-ptrnLen, i, "");
                i-=ptrnLen;
                textLen-=ptrnLen;
                j = s[i];
            }
        }
        //System.out.println(js.size());
        return str;
    }

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("censor.in"));


        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));


        char[] text = f.readLine().toCharArray();
        char[] ptrn = f.readLine().toCharArray();
        //System.out.println(searchSubString(text,ptrn));
        out.println(searchSubString(text,ptrn).toString());
        //out.println(text);


        out.close();


    }
}