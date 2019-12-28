class Solution {
    
    public int[] replaceElements(int[] arr) {
        int curr = -1, temp = 0;
        int n = arr.length;
        for(int i = n-1; i >= 0; i--){
             temp = arr[i];
             arr[i] = curr;
             curr = Math.max(curr, temp);
        }
        return arr;
    }
}
