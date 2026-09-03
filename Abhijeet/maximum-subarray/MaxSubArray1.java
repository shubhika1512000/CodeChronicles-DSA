
public class MaxSubArray1 {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sumSoFar = nums[0];

        for(int j = 1; j < nums.length; j++) {
            // incomming number is positive 
            if(nums[j] >= 0) {
                // previous sum is negative
                if(sumSoFar <= 0) {
                    sumSoFar = nums[j];
                }
                else {
                    sumSoFar += nums[j];
                }
            }
            // incomming number is negative
            else {
                if(sumSoFar <= 0 ) {
                    sumSoFar = nums[j];
                }
                else {
                    sumSoFar += nums[j];
                }
            }
            
            maxSum = Math.max(sumSoFar, maxSum);
        }

        return maxSum;
    }
}