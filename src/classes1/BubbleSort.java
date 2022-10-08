package classes1;

public class BubbleSort {
    public static void bubbleSort(int []arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = arr.length - 1;i > 0;i--){
            for(int j = 0; j < i ;j ++){
                if(arr[j] > arr[j + 1])
                    swap(arr,j,j+1);
            }
        }

    }

    //swap two variable without third variable
    public static void swap(int []arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];  // arr[i] = arr[i] ^ arr[j] ,arr[j] = arr[j]
        arr[j] = arr[i] ^ arr[j];   // arr[i] = arr[i] ^ arr[j] , arr[j] = arr[i] ^ arr[j} ^ arr[j] = arr[i]
        arr[i] = arr[i] ^ arr[j];   //  arr[i] = arr[i] ^ arr[j] ^ arr[i] = arr[j] , arr[j] = arr[i];
    }

    public static void main(String[] args) {
        int []arr = {1,3,2,4,5,1,6};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }



}
