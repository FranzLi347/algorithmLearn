package classes2;


import java.util.HashSet;
import java.util.Set;

public class MergeSort {
    public static void mergeSort(int []arr){
        if(arr.length < 2 || arr == null)return;
        process(arr,0,arr.length-1);
    }

    public static void process(int []arr,int l,int r){
        if(l == r)return;
        int mid = l + ((r - l) >> 1);
        process(arr,l,mid);
        process(arr,mid + 1,r);
        merge(arr,l,mid,r);
    }

    public static void merge(int[] arr,int l,int mid,int r){

        int []help = new int[r - l + 1];
        int index = 0,leftIndex = l,rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= r){
            help[index ++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex ++] : arr[rightIndex++];
        }
        while(leftIndex <= mid){
            help[index ++] = arr[leftIndex ++];
        }
        while(rightIndex <= r){
            help[index ++] = arr[rightIndex ++];
        }
        for(int i = 0;i < help.length;i++){
            arr[i + l ] = help[i];
        }
    }


    public static void main(String[] args) {
        int []arr = {1,3,2,4,5,1,6};
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
