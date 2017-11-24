package main;

public class LC014FirstPositionOfTarget {
    /**
     * @param nums:   The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int midIndex = (end + start) >>> 1;
            int mid = nums[midIndex];
            if (mid > target) {
                end = midIndex - 1;
            } else if (mid < target) {
                start = midIndex + 1;
            } else {
                for (int i = midIndex; i > 0; i--) {
                    if (nums[i - 1] != target) {
                        return i;
                    }
                }
                return start;
            }
        }
        return -1;
    }
}