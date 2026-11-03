package Abhijeet.math;

public class Leet3736 {
    
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        return max*nums.length - sum;
    }
}