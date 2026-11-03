package Abhijeet.math.leet462;

public class Leet462n2 {
    
    public int minMoves2(int[] nums) {
        long minStep = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            long step = 0;
            for(int j=0; j < nums.length; j++) {
                step += Math.abs(nums[j] - nums[i]);
            }
            minStep = Math.min(minStep, step);
        }

        return (int) minStep;
    }
}