import java.util.*;


class LargestDistinctSubArrayConsecutive{

    public static int largestLength(Integer [] array){

        int lastIndex = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> items =  new ArrayList<Integer>(List.of(array));


        Iterator<Integer> i = items.iterator();
        int index = 0;
        int maxLength = 0;
        int currLength = 0;
        while(i.hasNext()){

            int elem = i.next();
            if(hashMap.containsKey(elem)){
                
                int lastTimeSeen = hashMap.get(elem);
                
                if(lastTimeSeen >= lastIndex){
                  lastIndex = index;
                  hashMap.put(elem, index);
                  currLength = 1;
                
                }
                else{
                    currLength = currLength + 1;
                }
            }
            else{
                hashMap.put(elem, index);
                currLength = currLength + 1;
                if(currLength > maxLength){
                    maxLength = currLength;
                }
            }
            index = index +1;
            
        }
        return maxLength;
    }

    public static void main (String [] args){

        Integer [] array = new Integer[]{1,2,45,34,3,4,5,46,7,8,8,1,2,3,4,5,6,78,9,10,11,12,13};
        System.out.println(largestLength(array));
    }
}

