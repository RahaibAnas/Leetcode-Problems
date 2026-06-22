class Solution {
    public int maxProfit(int[] nums) {
        int buy = nums[0];
        int profit = 0;

        for (int i = 0;i< nums.length;i++) {
            if (nums[i] < buy) {
                buy = nums[i];
            } else if (nums[i] - buy > profit) {
                profit = nums[i] - buy;
            }
        }

        return profit;
    }
}