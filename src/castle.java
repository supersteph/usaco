/*
ID: xiaoyun4
LANG: JAVA
TASK: sprime
*/

/**
 * How to solve it:
 * So I read in all of the data, and I add a 1 if it is a wall, and I just start at 1, and keep on going right until
 * I might be able to go up or down, and when it can i add up the spaces in the room, when i try to remove a wall, i
 * try to remove all the walls in the middle and see if there are any rooms that are bigger
 *
 */


import java.io.*;
import java.util.*;

public class castle {

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        // input file name goes above

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
    }
}
