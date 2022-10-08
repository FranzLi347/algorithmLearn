package classes1;

/**
 *
 Find the number that occurs an odd number of times
 O(n)
 */

public class theOccursOddNumber {

    public static int findOnlyOccursOddNumber(int []arr){
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        return eor;
    }

    public static int[] findOccursOddNumber2(int []arr){
        int eor = 0;
        for(int i : arr){
            eor ^= i;
        }
        //now eor = a ^ b the odd occurs number

        /*
        for(int i = 0; i < 31;i ++){
            if(eor >> i  == 1){ // if in eor[i] = 1 a[i] != b[i] (i is the bit index in number)
                diffIndex = i;
                break;
            }
        }
        */
        int rightOne = eor & (~eor + 1); // get the right one bit index
        int eor2 = 0;
        /*
           because this occurs odd number a and b differ in i bit
           so: there will have two heap numbers,one of that is
           a or b + others occurs even number(the i bit is 1)
           the other is
           a or b + others occurs even number(the i bit is 0)
           after xor the variable eor2 would be a or b
         */
        for(int i : arr){
            if((i & rightOne) == 0){
                eor2 ^= i;
            }
        }
        return new int[]{eor ^ eor2,eor2};
    }

    public static void main(String[] args) {
        int []arr = {1,3,3,3,4,4,5,5};
        int[] occursOddNumber2 = findOccursOddNumber2(arr);
        for (int i : occursOddNumber2) {
            System.out.println(i);
        }
    }
}
