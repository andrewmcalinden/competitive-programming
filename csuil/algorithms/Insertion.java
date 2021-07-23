package algorithms;

import java.util.Arrays;

public class Insertion {
    public static void main(String [] args){
        int [] nums = new int[] { 8, 7, 3, 5, 6, 0, 8, 2, -5, 9, 0 };
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int [] nums){
        for (int i = 1; i < nums.length; i++){
            int x = nums[i];
            int index = i - 1;
            for (int k = i - 1; k >= 0 && nums[k] > x; k--){
                nums[k + 1] = nums[k];
                index = k;
            }
            nums[index] = x;
        }
    }
}
