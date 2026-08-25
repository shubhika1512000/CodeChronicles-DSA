public class TrappingWater {

    public int trap(int[] height) {
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];

        lmax[0] = -1;
        int max_i=0;
        int max = height[0];
        for(int i=1; i < height.length; i++) {
            if(height[i] > max) {
                max = height[i];
                max_i = i;
                lmax[i] = -1;
            }
            else {
                lmax[i] = max_i;
            }
        }

        rmax[height.length - 1] = -1;
        max_i = height.length - 1;
        max = height[height.length - 1];
        for(int i=height.length-2; i >=0 ; i--) {
            if(height[i] > max) {
                max = height[i];
                max_i = i;
                rmax[i] = -1;
            }
            else {
                rmax[i] = max_i;
            }
        }
        
        int total = 0;
        for(int i=0; i < height.length; i++) {
            if(lmax[i] != -1 && rmax[i] != -1) {
                int minH = Math.min(height[lmax[i]], height[rmax[i]]);
                total += (minH-height[i]);
            }
        }

        return total;
    }
}