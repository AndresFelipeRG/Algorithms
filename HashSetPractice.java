import java.util.HashMap;

import java.util.Map;

import java.util.Iterator;

import java.util.Set;

public class Details{
    public static void main(String args[]){

        HashMap<Integer, String> hmap = new HashMap<Integer, String> ();

        hmap.put(12, "A");
        hmap.put(2, "Rahul");
        hmap.put(7, "Singh");
        hmap.put(1, "a");
        hmap.put(112, "Aa");
        hamp.put(3, "andres");

        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }
        String var = hmap.get(2);
        System.out.println("Value at index 2 is: "+ var);

        Set<Integer> setB = new HashSet<>();
        setB.add(2);
        setB.add(1);
        setB.add(4);
    }
}
