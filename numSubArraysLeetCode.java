import java.util.*;
class Solution {
    /*Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.

    Return the number of nice sub-arrays.*/
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList();
        int min = 0;
        queue.add(-1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] %2 == 1){ queue.add(i);}
            if(queue.size() > k + 1) { queue.pop();}
            if(queue.size() == k + 1){ min += 1 + queue.get(1) - (queue.get(0)+1);}
        }
        return min;
        
    }
}
