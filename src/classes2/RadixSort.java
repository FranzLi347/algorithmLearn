package classes2;

import java.util.Arrays;

public class RadixSort {
    
    public static void radixSort(int []arr){
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(i, max); 
        }
        int digital = 0;
        while(max != 0){
            digital ++;
            max /= 10;
        }
        int []help = new int[arr.length];
        // 统计最后位数频率

        //一共出入桶digital次
        for(int i = 1;i <= digital;i++){
            int []count = new int[10];
            for (int j = 0; j < arr.length; j++) {
                // 拿到num倒数第i位
                int num = getDigital(arr[j],i);
                count[num] ++;
            }
            //处理为前缀和
            for(int j = 1;j < count.length;j++){
                count[j] = count[j - 1];
            }
            for(int j = arr.length - 1;j >= 0;j --){
                help[count[getDigital(arr[j],digital)] - 1] = arr[j];
                count[getDigital(arr[j],digital)] --;
            }
            for(int j = 0;j < arr.length;j++){
                arr[j] = help[j];
            }
        }
    }

    public static int getDigital(int num,int index){
        return ((num / (int)Math.pow(10,index - 1)) % 10);
    }


}
