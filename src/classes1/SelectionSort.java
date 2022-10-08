package classes1;

public class SelectionSort {
    public static void selectionSort(int []arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0;i < arr.length;i ++){
            int minIndex = i;
            for(int j = i + 1;j < arr.length;j++){
                 minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(i,minIndex,arr);
        }
    }

    public static void swap(int i,int minIndex,int []arr){
        int k = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = k;
    }

    public static void main(String[] args) {
        int []arr = {1,3,2,4,5,1,6};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
