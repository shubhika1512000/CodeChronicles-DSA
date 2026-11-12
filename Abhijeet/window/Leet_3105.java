package Abhijeet.window;

public class Leet_3105 {

    public int longestMonotonicSubarray(int[] nums) {
        int left = 0;
        int prev = 0;
        int countI = 0;

        // increasing
        for(int right=0; right < nums.length; right++) {
            if(nums[right] <= prev)  {
                countI = Math.max(right - left, countI);
                left = right;
            }

            prev = nums[right];
        }

        countI = Math.max(nums.length - left, countI); // right was local to loop so nums.length is taken

        prev = 51;
        left = 0;
        int countD = 0;
        
        // decreasing
        for(int right=0; right < nums.length; right++) {
            if(nums[right] >= prev)  {
                countD = Math.max(right -left,countD);
                left = right;
            }

            prev = nums[right];
        }

        countD = Math.max(nums.length - left, countD); // right was local to loop so nums.length is taken

        return Math.max(countI, countD); 
    }
}