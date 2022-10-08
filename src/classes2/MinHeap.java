package classes2;

import java.util.Arrays;
import java.util.Comparator;

public class MinHeap {
    private int[] heap;
    private int heapSize;
    
    public MinHeap(int size){
        heap = new int[size];
        heapSize = 0;
    }

    public void insertHeap(int num){
        heap[heapSize ++] = num;
        int index = heapSize - 1;
        while(heap[index] < heap[(index - 1) / 2]){
            swap(heap,index,(index - 1) / 2);
            index = ((index - 1) / 2);
        }
    }

    public int pool(){
        int ans = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        heapIfy(0);
        return ans;
    }


    public void heapIfy(int index){
        int left = index * 2 + 1;
        while(left < heapSize){
            //找出存在且最小的儿子
            int minIndex = left + 1 < heapSize && heap[left + 1] < heap[left] ? left + 1: left;
            minIndex = heap[index] < heap[minIndex] ? index : minIndex;
            // 如果父节点就是最小的节点
            if(minIndex == index) break;
            swap(heap,index,minIndex);
            index = minIndex;
            left = index * 2 + 1;
        }
    }

    private void swap(int []arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(20);
        int []arr = {1,3,2,4,5,1,6,3,-1,-2};
        for (int i : arr) {
            minHeap.insertHeap(i);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(minHeap.pool());
        }
    }
}
