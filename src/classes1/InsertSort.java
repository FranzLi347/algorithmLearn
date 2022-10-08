package classes1;

public class InsertSort {
    public static void swap(int []arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];  // arr[i] = arr[i] ^ arr[j] ,arr[j] = arr[j]
        arr[j] = arr[i] ^ arr[j];   // arr[i] = arr[i] ^ arr[j] , arr[j] = arr[i] ^ arr[j} ^ arr[j] = arr[i]
        arr[i] = arr[i] ^ arr[j];   //  arr[i] = arr[i] ^ arr[j] ^ arr[i] = arr[j] , arr[j] = arr[i];
    }


    public static void insertSort(int []arr){
        for(int i = 1; i < arr.length;i ++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1];j--){
                  swap(arr,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
        int []arr = {1,3,2,4,5,1,6};
        insertSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
