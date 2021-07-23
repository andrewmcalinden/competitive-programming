package algorithms;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] nums = new int[] { 8, 7, 3, 5, 6, 0, 8, 2, -5, 9, 0 };
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
