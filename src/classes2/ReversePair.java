package classes2;

public class ReversePair {
    public static void getReversePair(int []arr){
        if(arr == null)return;
        process(arr,0,arr.length - 1);
    }

    public static void process(int []arr,int l,int r){
        if(l == r)return;
        int mid = l + ((r - l) >> 1);
        process(arr,l,mid);
        process(arr,mid + 1,r);
        merge(arr,l,mid,r);
    }

    public static void merge(int []arr,int l,int mid,int r){
        int []help = new int[r - l + 1];
        int p1 = l,p2 = mid + 1,p = 0;
        while(p1 <= mid && p2 <= r){
            if(arr[p1] > arr[p2]){
                for(int i = p2;i <= r;i++){
                    System.out.println(arr[p1] + " " + arr[i]);
                }
            }
            help[p ++] = arr[p1] < arr[p2] ? arr[p1 ++] : arr[p2++];
        }
        while(p1 <= mid){
            help[p ++] = arr[p1 ++];
        }
        while(p2 <= r){
            help[p ++] = arr[p2 ++];
        }
        for(int i = 0;i < help.length;i++){
            arr[i + l] = help[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,1,2,4,0};
        getReversePair(arr);
    }
}
