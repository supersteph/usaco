

public class quicksort {

    static void quicksort(int[] x, int start, int end){
        if(start+1==end){
            return;
        }

        int small = start;
        int big = end;
        int pivot = x[(start+end)/2];
        while(small<big){
            while (x[small]<pivot){
                small++;
            }
            while (x[big]>pivot){
                big--;
            }
            if(small<big) {
                int trans = x[big];
                x[big] = x[small];
                x[small] = trans;
                small++;
                big --;
            }
        }

        quicksort(x,start,small);
        quicksort(x,big,end);

    }
    public static void main(String[] args) {
        // write your code
        int[] x = {2,1};
        quicksort(x,0,1);


    }
}
