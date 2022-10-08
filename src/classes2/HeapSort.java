package classes2;

import java.util.Arrays;


public class HeapSort {

    static public int heapSize = 1;

    private static void swap(int []arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void borderRange(int[] arr){
        int index = heapSize;
        while(arr[index] < arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = ((index - 1) / 2);
        }
    }

    private static void heapify(int []arr,int index){
        int left = index * 2 + 1;
        while(left < heapSize){
            int min = left + 1 < heapSize && arr[left + 1] < arr[left] ? left + 1:left;
            min = arr[index] < arr[min] ? index : min;
            if(min == index) break;
            swap(arr,index,min);
            index = min;
            left = index * 2 + 1;
        }
    }

    public static void heapSort(int []arr){
        heapSize = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr,i);
        }
        swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0);
            swap(arr,0,--heapSize);
        }
    }

    public static void main(String[] args) {
        int []arr = {1,3,2,4,5,1,6,3,-1,-2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
