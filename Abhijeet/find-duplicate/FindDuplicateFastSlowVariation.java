class FindDuplicateFastSlow {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;

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