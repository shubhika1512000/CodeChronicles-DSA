package Abhijeet.math.leet462;

import java.math.BigInteger;
import java.util.Arrays;

class Leet462Snlogn {

    // with summation logic
    public int minMoves2(int[] nums) {
        BigInteger minStep = null; 
        BigInteger sum = BigInteger.ZERO;
        
        for(int i=0; i < nums.length; i++) {
            sum = sum.add(BigInteger.valueOf(nums[i]));
        }

        Arrays.sort(nums);

        BigInteger sum_0i = BigInteger.ZERO;
        for(int i=0; i<nums.length; i++){
            sum_0i = sum_0i.add(BigInteger.valueOf(nums[i]));
            
            // Direct translation of: (2*(i+1) - nums.length)*nums[i] + sum - 2*sum_0i
            // Note: 2L is used to prevent the integer multiplier from overflowing before conversion
            BigInteger step = BigInteger.valueOf(2L * (i + 1) - nums.length)
                                .multiply(BigInteger.valueOf(nums[i]))
                                .add(sum)
                                .subtract(BigInteger.valueOf(2).multiply(sum_0i));

            // Direct translation of: minStep = Math.min(minStep, step)
            if (minStep == null || step.compareTo(minStep) < 0) {
                minStep = step;
            }
        }

        return minStep.intValue();
    }
}
