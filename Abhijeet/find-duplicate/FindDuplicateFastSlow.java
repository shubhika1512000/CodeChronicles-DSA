class FindDuplicateFastSlow {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}

/**
 * Important for fast slow pointer is to have same starting point
 * After collision both pointers move by 1 step to again collide at point where cycle start.
 *  
 */