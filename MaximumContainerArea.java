import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        
        int answer = 0;
        
       
        int left = 0;
        int right = height.length - 1;
        while(left != right){
            int area = Math.min(height[left], height[right])*(right-left);
            if(area > answer){answer = area;}
            if(height[left]< height[right]){
                left = left + 1;
            }
            else{
                right = right -1;
            }
        }
        return answer;
        
    }
}
