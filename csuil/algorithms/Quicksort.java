package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        int[] nums = new int[] { 8, 7, 3, 5, 6, 0, 8, 2, -5, 9, 0 };
        System.out.println(Arrays.toString(nums));
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int left, int right) {
        if (left < right){
            int mid = partition(nums, left, right);

            sort(nums, left, mid); //before pivot
            sort(nums, mid + 1, right); //after pivot
        }
    }

    //returns true location of pivot element
    public static int partition(int[] nums, int left, int right) {
        Random r = new Random();
        int pivotVal = nums[r.nextInt(nums.length)]; //maybe make random
        right++;
        left--;

        while(true){
            // find first element less than pivot to the right of it

            do{
                right--;
            }
            while(nums[right] > pivotVal);

            do {
                left++;
            } while (nums[left] < pivotVal);
            //if we still have elements out of place
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            //pivot element is in correct spot, return that spot
            else{
                return right;
            }
        }
        
    }
}
