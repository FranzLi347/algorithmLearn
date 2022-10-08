package classes1;

public class LocalMinimum {
    public static int getLocalMinimum(int []arr){
        int l =0 ,r = arr.length - 1;
        int mid = 0;
        if(arr[l] < arr[l + 1]){
            return l;
        }
        if(arr[r] < arr[r - 1]){
            return r;
        }
        while(l <= r){
            mid = l + ((r - l) >> 1);
            if(arr[mid] < arr[mid-1]&& arr[mid] < arr[mid +1]){
                return mid;
            }

            if(arr[mid] > arr[mid - 1]){
                r = mid - 1;
            }

            if(arr[mid] > arr[mid + 1]){
                l = mid + 1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int []arr = {3,1,0,-1,2,4,6,8,9};
        System.out.println(getLocalMinimum(arr));
    }
}
