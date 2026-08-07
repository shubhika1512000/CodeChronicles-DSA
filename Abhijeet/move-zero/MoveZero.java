
public class MoveZero {
    
    public void moveZeroes(int[] nums) {
        int pointZ  = 0;
        int pointNZ = 0;

        while(pointZ < nums.length && pointNZ < nums.length) {

            if(pointZ < pointNZ) {
                nums[pointZ] = nums[pointNZ];
                nums[pointNZ] = 0;
            }
            
            if(pointZ > pointNZ) pointNZ++;

            if(nums[pointZ] != 0) pointZ++;
            if(nums[pointNZ] == 0) pointNZ++;
        }
    }
}