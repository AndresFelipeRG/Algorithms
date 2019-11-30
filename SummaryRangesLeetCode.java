class Solution {
    
    public List<String> summaryRanges(int[] nums) {
        
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        for(int i= 0; i < n; i++){
            int j = i;
            while( j < n -1 && nums[j+1] == nums[j]+1) j++;
            if(j-i >= 1) ans.add(String.valueOf(nums[i])+"->"+String.valueOf(nums[j]));
            else ans.add(String.valueOf(nums[i]));
            i = j;
        }
        return ans;
    }
}
