package leetcode;

import java.util.Arrays;

class Solution {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i = 0;i < nums2.length;i ++){
            res[i] = getlowernum(nums1,nums2[i]);
        }
        return res;
    }

    public static int getlowernum(int[] nums1,int target){
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int minResIndex = 0;
        int minIndex = 0;
        for(int i = 0;i < nums1.length;i++){
            if(nums1[i] > target && res > nums1[i] && nums1[i] != -1){
                res = nums1[i];
                minResIndex = i;
            }
            if(min > nums1[i] && nums1[i] != -1){
                min = nums1[i];
                minIndex = i;
            }
        }
        if(res != Integer.MAX_VALUE){
            nums1[minResIndex] = -1;
            return res;
        }else{
            nums1[minIndex] = -1;
            return min;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {1,10,4,11};
        System.out.println(Arrays.toString(advantageCount(nums1,nums2)));
    }

}