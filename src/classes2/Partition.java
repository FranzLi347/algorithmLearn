package classes2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Partition {
    public static void partition(int []arr,int num){
        int l = -1,r = arr.length;
        int i = 0;
        while(i != r) {
            if (arr[i] < num) {
                swap(arr, i++, ++l);
                continue;
            }
            if (arr[i] == num) {
                i++;
                continue;
            }
            if (arr[i] > num) swap(arr, i, --r);
        }
    }
    public static void swap(int []arr,int i,int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public static void main(String[] args) {
        int []arr = {1,1,2,9,9,2,5,5,6,6,3,3,1,1};
        partition(arr,5);
        System.out.println(Arrays.toString(arr));
    }


}
