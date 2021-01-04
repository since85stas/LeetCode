public class RemoveDublicats {
    public int removeDuplicates(int[] nums) {

        if (nums != null && nums.length!=1) {
            if (nums.length>1) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == nums[i + 1]) {
                         System.arraycopy(nums,i,nums,i,nums.length-2);
                         return removeDuplicates(nums);
                    }
                }
                return nums.length;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
}
