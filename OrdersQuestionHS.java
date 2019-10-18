import java.util.*;
public class OrdersQuestionHS{

     public int [] answer(Map <Integer,Integer> orders, int n, int k){
         int time = 0;
         Map<Integer, Integer> map = new HashMap<>();
         int [] response = new int[k];
         Iterator it = orders.entrySet().iterator();
         int count = 0;
         while(it.hasNext()){
             
             Map.Entry item = (Map.Entry) it.next();
             int val = (int) item.getKey();
             int t1 = (int) item.getValue();
             int key = val % n;
             
             if(map.containsKey(key)){
                  
                 if(map.get(key) - time >= t1 ){
                     map.put(key, time + t1);
                     response[count] = key;
                 }
                 else{
                     int temp = time;
                     boolean found = false;
                     while(!found){
                        key = key + 1;
                        if(map.containsKey(key)){
                                if(map.get(key) - temp >= t1 ){
                                    map.put(key, temp + t1);
                                    response[count] = key;
                                    found = true;
                                }
                        }
                        else{
                             map.put(key, temp + t1);
                             response[count] = key;
                             found = true;
                        }
                        temp+=1;
                     }
                 }
             }else{
                 map.put(key, time + t1);
                 response[count] = key;
                 
             }
             time++;
             count++;
         }
         
         return response;
         
     }
     
}
