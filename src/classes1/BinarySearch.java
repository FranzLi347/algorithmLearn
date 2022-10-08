package classes1;

/*
    在数组中找到大于等于num最左边的位置
 */
public class BinarySearch {
    public static int binarySearch2(int []arr,int target){
        int l = 0 , r = arr.length - 1;
        int mid = 0,ans = 0;
        while (l <= r){
            mid = l + ((r - l) >> 1);
            if(arr[mid] >= target){
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }



    public static void main(String []args){
        int []arr = {1,1,2,2,2,3,3,4,4,4};
        System.out.println(binarySearch2(arr,2));
    }
}
