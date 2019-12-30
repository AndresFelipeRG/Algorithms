class Solution {
    
    public int findBestValue(int[] arr, int target) {
        
        if(arr == null) return 0;
        int n = arr.length;
        if(n == 0) return 0;
        Arrays.sort(arr);
        int cur = 0, val = Integer.MAX_VALUE, res = 0;
        
        int [] curSum = new int[n];
        TreeMap<Integer, Integer> nums = new TreeMap<>();
        for(int i = 0; i < n; i++){
            curSum[i] = cur;
            if(!nums.containsKey(arr[i])) nums.put(arr[i], i);
            cur+=arr[i];
        }
        cur = 0;
        int left = target/n ;
       // System.out.println(Arrays.toString(curSum));
       // System.out.println(String.valueOf(nums));
        if(left > arr[n-1]) return arr[n-1];
        while(left <= target){
            Integer item = nums.ceilingKey(left);
            if(item == null) break;
            int i = nums.get(item);
            int rem = n - i;
            if(Math.abs(curSum[i]+left*rem - target)< val){
                val = Math.abs(curSum[i]+left*rem - target);
                res = left;
            }
            left++;
        }
        return res;
    }
}
