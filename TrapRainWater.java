class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int [] maxLeft = new int[n];
        int [] maxRight = new int [n];
        int currentMaxLeft = height[0];
        int currentMaxRight = height[n-1];
        for(int i = 0; i < n; i ++){
           
    
            
            if(height[i] > currentMaxLeft){
                maxLeft[i] = height[i];
                currentMaxLeft = maxLeft[i];
            }
            else{
                maxLeft[i] = currentMaxLeft;
            }
            
            //System.out.println(currentMaxLeft);
            
            if(height[n-1-i] > currentMaxRight){
                maxRight[n-1-i] = height[n-1-i];
                currentMaxRight = maxRight[n-1-i] ;
            }
            else{
                maxRight[n-1-i] = currentMaxRight;
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            answer += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return answer;
    }
}
