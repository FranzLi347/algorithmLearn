package classes2;


public class SumCountProblem {

    public static int countProblem(int []arr){
        if(arr == null || arr.length < 2)return 0;
        return process(arr,0,arr.length-1);
    }

    public static int process(int []arr,int l,int r){
        if(l == r)return 0;
        int mid = l + ((r - l) >> 1);
        // 左边小和 + 右边小和 + 左右合并的小合
        return process(arr,l,mid)
                + process(arr,mid + 1,r)
                + merge(arr,l,mid,r);
    }

    public static int merge(int []arr,int l,int mid,int r){
        int count = 0;
        int []help = new int[r - l + 1];
        int index = 0, leftIndex = l ,rightIndex = mid + 1;
        while(leftIndex <= mid && rightIndex <= r){
            count += arr[leftIndex] < arr[rightIndex] ? arr[leftIndex] * (r - rightIndex + 1) : 0;
            // copy action  两边相同时先拷贝右边
            help[index ++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex ++] : arr[rightIndex ++];
        }
        while(leftIndex <= mid){
            help[index ++] = arr[leftIndex ++];
        }
        while(rightIndex <= r){
            help[index ++] = arr[rightIndex ++];
        }
        for(int j =0 ;j < help.length ; j++) {
            arr[l+j] = help[j];
        }
        return count;
    }


    public static void main(String[] args) {
        int []arr = {1,3,4,2,5};
        System.out.println(countProblem(arr));
    }
}
