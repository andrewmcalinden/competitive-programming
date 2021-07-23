package algorithms;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] nums = new int[] { 8, 7, 3, 5, 6, 0, 8, 2, -5, 9, 0 };
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums.length == 1)
            return;

        int mid = (nums.length) / 2;

        int[] part1 = new int[mid];
        for (int i = 0; i < mid; i++) {
            part1[i] = nums[i];
        }

        int[] part2 = new int[nums.length - mid];
        for (int i = mid; i < nums.length; i++) {
            part2[i - mid] = nums[i];
        }

        sort(part1);
        sort(part2);

        merge(part1, part2, nums);
    }

    public static void merge(int[] nums1, int[] nums2, int[] result) {
        int i = 0; // nums1
        int j = 0; // nums2
        int m = 0; // result

        while (m < result.length) {
            if (i >= nums1.length) {
                result[m] = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                result[m] = nums1[i];
                i++;
            } else {
                if (nums1[i] <= nums2[j]) {
                    result[m] = nums1[i];
                    i++;
                } else {
                    result[m] = nums2[j];
                    j++;
                }
            }
            m++;
        }
    }
}
