package classes2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class QuickSort {
    // 空间复杂度O(log n)
    public static void quickSort(int []arr,int l,int r){
        if(l < r){
            swap(arr,l + (int)(Math.random() * r - l + 1),r);
            int []range = partition(arr,l,r);
            quickSort(arr,l,range[0] - 1);
            quickSort(arr,range[1] + 1,r);
        }
    }


    public static int[] partition(int []arr,int lIndex,int rIndex){
        int l = lIndex -1,r = rIndex;
        int i = 0;
        while(i != r) {
            if (arr[i] < arr[rIndex]) {
                swap(arr, i++, ++l);
            }
            else if (arr[i] == arr[rIndex]) {
                i++;
            }else {
                 swap(arr, i, --r);
            }
        }
        swap(arr,r,rIndex);
        return new int[]{l + 1,r};
    }

    public static void swap(int []arr,int i,int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }


    public static void main(String[] args) {
        int []arr = {1,3,2,4,5,1,6};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
