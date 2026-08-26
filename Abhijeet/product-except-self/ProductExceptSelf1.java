
public class ProductExceptSelf1 {

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int isZero = 0;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i]==0){
                isZero++;
            } else {
                product = product*nums[i];
            }
        }

        int[] products = new int[nums.length];

        if(isZero > 1) {
            return products;
        }
        else if(isZero == 1) {
            for(int i = 0; i<nums.length; i++) {
                if(nums[i]==0) {
                    products[i] = product;
                }
                else {
                    products[i] = 0;
                }
            }
            return products;
        } 
        else {
            for(int i=0; i<nums.length; i++) {
                products[i] = product / nums[i];
            }
            return products;
        }
    }
}