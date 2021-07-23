package algorithms;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] nums = new int[] { 8, 7, 3, 5, 6, 0, 8, 2, -5, 9, 0 };
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int min = nums[i];
            int loc = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < min){
                    min = nums[j];
                    loc = j;
                }
            }
            int temp = nums[loc];
            nums[loc] = nums[i];
            nums[i] = temp;
        }
    }
}
