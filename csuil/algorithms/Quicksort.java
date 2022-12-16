package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        int[] nums = new int[] { 8, 7, 3, 5, 6, 0, 8, 2, -5, 9, 0 };
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        //very robust testing yessir
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            quickSort(nums, l, pivot - 1);
            quickSort(nums, pivot + 1, r);
        }
    }

    public static int partition(int[] nums, int lBound, int rBound) {
        int val = nums[rBound];
        int r = rBound - 1;
        int l = lBound;
        while (true) {
            while (l < rBound && nums[l] < val) {
                l++;
            }
            while (r > lBound && nums[r] > val) {
                r--;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            } else {
                break;
            }
        }
        nums[rBound] = nums[l];
        nums[l] = val;
        return l;
    }
}
