
public class MaxSubArray2 {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sumSoFar = nums[0];

        for(int j = 1; j < nums.length; j++) {
            if(sumSoFar <= 0 ) {
                sumSoFar = nums[j];
            }
            else {
                sumSoFar += nums[j];
            }

            maxSum = Math.max(sumSoFar, maxSum);
        }

        return maxSum;
    }
}