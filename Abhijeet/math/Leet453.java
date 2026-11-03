package Abhijeet.math;

public class Leet453 {
    
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }

        for(int i=0; i < nums.length; i++) {
            sum = sum + Math.abs(nums[i] - min);
        }

        return sum;
    }
} 