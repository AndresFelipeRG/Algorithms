class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        if(arr == null) return new int[]{};
        int n = arr.length;
       
        for(int i = 1; i < n ;i++){
            arr[i] = arr[i] ^ arr[i-1];
        }
        int ans[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            if (queries[i][0] > 0) ans[i] = arr[queries[i][0]-1] ^ arr[queries[i][1]];
            else ans[i] = arr[queries[i][1]];
        }
        return ans;
    }
}
