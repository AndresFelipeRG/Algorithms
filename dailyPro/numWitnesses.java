class Solution {

    public int numWitnesses(int [] array){
        if(array.length == 0){return 0;}
        int res = 1;
        int curMax = array[array.length-1];
        for(int i = array.length; i>=0; i--){
              if(array[i] > curMax){
                  res += 1;
                  curMax = array[i];
              }
        }
        return res;
    }
}
