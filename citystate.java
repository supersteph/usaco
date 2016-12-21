
import java.io.*;

import java.util.ArrayList;
import java.util.StringTokenizer;

class stuff {
    String city;
    String state;
}
public class citystate {
    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));

        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

        int num = Integer.parseInt(f.readLine());
        ArrayList<stuff> s = new ArrayList<stuff>();
        int count = 0;
        ArrayList<Integer>[][] city = (ArrayList<Integer>[][])new ArrayList[26][26];
        ArrayList<Integer>[][] state = (ArrayList<Integer>[][])new ArrayList[26][26];
        for(int i = 0; i< num;i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String l = st.nextToken();
            String m = st.nextToken();
            char c1 = l.charAt(0);
            char c2 = l.charAt(1);
            char s1 = m.charAt(0);
            char s2 = m.charAt(1);

            if(city[c1-'A'][c2-'A']==null){
                city[c1-'A'][c2-'A'] = new ArrayList<Integer>();
            }
            if(state[s1-'A'][s2-'A']==null){
                state[s1-'A'][s2-'A'] = new ArrayList<Integer>();
            }
            //System.out.println((c1-'A')+" "+ (c2-'A')+" "+(s1-'A')+" "+(s2-'A'));
            city[c1-'A'][c2-'A'].add(i);
            state[s1-'A'][s2-'A'].add(i);
            stuff k = new stuff();
            k.state = m.substring(0,2);
            k.city = l.substring(0,2);
            s.add(k);
        }

        for(int i = 0; i<s.size();i++){
            char c1 = s.get(i).city.charAt(0);
            char c2 = s.get(i).city.charAt(1);
            int co = c1-'A';
            int ct = c2-'A';
            char s1 = s.get(i).state.charAt(0);
            char s2 = s.get(i).state.charAt(1);
            int so = s1-'A';
            int st = s2-'A';


            ArrayList<Integer> carray = state[co][ct];
            ArrayList<Integer> sarray = city[so][st];
            if(carray!=null&&sarray!=null) {
                //System.out.println(carray);
                //System.out.println(sarray);
                carray.retainAll(sarray);
                count += carray.size();
                for(int a:carray){
                    if(s.get(a).state.equals(s.get(i).state)){
                        count--;
                    }
                }
            }
        }
        System.out.println(count);
        out.println(count/2);
        //System.out.println("yo");
        out.close();


    }
}