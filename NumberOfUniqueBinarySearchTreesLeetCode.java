class Solution {
    public int numTrees(int n) {
        Integer[] data = new Integer[n+1];
        Arrays.fill(data, new Integer(0));
        data[0] = 1;
        data[1] = 1;
        for(int i = 2; i <= n ; i++){
            for(int j = 0; j <= i-1; j++){
                int right = i - j -1;
                int left = j;
              
          
                data[i] = data[i] + data[left]*data[right];
            }
        }
       
        return data[n];
    }
}
