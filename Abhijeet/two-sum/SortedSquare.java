public class SortedSquare {
    
    public int[] sortedSquares(int[] nums) {
        /**
            Complete State
            - li (left index)
            - ri (right index)
            - out (output)

            At each step, 
                li defines that
                    All the indices on the left upto li are processed (except li)
                
                ri defines that
                    All the indices on the right upto ri are processed (except ri)

                out define that
                    All the values that are processed by li and ri so far
                    will be added from end,
                    At what place given li and ri indices
                        li = 0, 0 elements processed
                        ri = nums.length - 1, 0 elements processed
                        
                        So by both collectively
                        x = nums.length - ri + li - 1 satisfies 0 elements processed

                        out index (oi):
                            nums.length - nums.length + ri - li + 1
                            ri - li + 1

                        out index prefectly depicts the place when we have not processed anything yet.

        */

        // In intial State setup step.
        // State initialisation is done correctly, satisfying all invariant properties. S0 : intial state setup for P0 processing step
        int li = 0;
        int ri = nums.length - 1;
        int[] out = new int[nums.length];

        // The processing happens in the loop, where all invariants always should be held true. All before that are prepatory steps towards it. 
        // Processing step P0 takes in S0 state and produces S1 state to feed in for P1 step and so on.

        while(li <= ri) {
            // Process previous state, li, ri, oi
            boolean isLeftBig = Math.abs(nums[li]) >= Math.abs(nums[ri]);
            int val = isLeftBig ? 
                (int) Math.pow(nums[li],2) : 
                (int) Math.pow(nums[ri],2);
            
            // State Mutation for next step states
            li = isLeftBig ? li + 1 : li;
            ri = isLeftBig ? ri : ri - 1;

            out[ri-li+1] = val;
        } 
        
        return out;
    }
}

/**
    For testing : 
    The should always be tested on: 
        test cases to break invariants ( which means testing the foundational rule)
        
        test cases to test conditional boundaries ( conditions are the place where you decide the path; there can be a opportunity of missed possible solution or considering wrong solutions )
        
        test the cornor cases (extreme cases)

 */