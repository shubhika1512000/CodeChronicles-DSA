package Abhijeet.math.leet462;
import java.util.Arrays;

public class Leet462Mnlogn {
    // median logic
    public int minMoves2(int[] nums) { 
        Arrays.sort(nums);

        int med_i = nums.length/2; 
        long step = 0;
        for(int i=0; i<nums.length; i++){

            step += Math.abs(nums[med_i] - nums[i]);
        }
        
        return (int) step; 
    }
}