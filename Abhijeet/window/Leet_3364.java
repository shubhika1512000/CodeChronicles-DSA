package Abhijeet.window;

import java.util.ArrayList;
import java.util.List;

public class Leet_3364 {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        List<Integer> box = new ArrayList<>();
        int ans = -1;

        int sum = 0;
        for(int i = 0; i < l; i++) {
            sum += nums.get(i);
        }
        
        ans = ansRule(ans, sum);
        box.add(sum);

        int i=0;
        for(int j = l; j < nums.size(); j++){
            if(ans == 0) break;

            sum = sum + nums.get(j) - nums.get(i);
            ans = ansRule(ans, sum);

            box.add(sum);
            i++;
        }

        // Calculating all sizes
        for(int k = l+1; k <= r; k++) {
            if(ans == 0) break;
            
            int numi = k-1;
            for(
                int j=0; 
                j < box.size() && numi < nums.size(); j++
            ) {
                
                box.set(j, box.get(j) + nums.get(numi));

                ans = ansRule(ans, box.get(j));
                numi++;
            }
        }

        return ans;
    }

    public static int ansRule(int ans, int sum) {
        if(sum > 0 && (ans < 0 || sum < ans)) return sum;
        
        return ans;
    }
}