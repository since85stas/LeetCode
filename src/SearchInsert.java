public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums==null) {
            return 0;
        } else if ( nums.length == 1) {
            if (nums[0]>=target) {
                return 0;
            } else {
                return 1;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                } else if (nums[i] > target) {
                    return i;
                }
            }
            return nums.length;
        }
    }
}
