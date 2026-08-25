public class MostWater {

    public int maxArea(int[] height) {
        
        int left = 0, right = height.length-1;
        int maxWater = 0;
        while(left < right) {
            int water = 
                Math.min(height[left], height[right])*(right-left);

            if(height[right] >= height[left]) left++;
            else right--;

            maxWater = Math.max(water, maxWater);    
        } 

        return maxWater;
    }
}