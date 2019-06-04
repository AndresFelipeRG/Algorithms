import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = new Integer(reader.readLine()).intValue();
		while(t > 0){
		    String [] pair = reader.readLine().split(" ");
		    int n = new Integer(pair[0]);
		    int s = new Integer(pair[1]);
		    int k = n;
		    List<Integer> array = new ArrayList<>();
		    String [] items = reader.readLine().split(" ");
		    for(String item: items){
		        array.add(new Integer(item).intValue());
		    }
		    int i = 0;
		    int currentSum = 0;
		    boolean found = false;
		    int left = 0;
		    int right = 0;
		    while(i <= k){
		       if(currentSum == s){
		           System.out.println(String.format("%d %d", left + 1, right));
		           found = true;
		           break;
		       }
		       if(currentSum < s){
		           if(i < k){
		           currentSum = currentSum + array.get(i);
		           }
		           right = right + 1;
		           i = i + 1;
		           continue;
		       }
		       if(currentSum > s){
		           if(left < k){
		               currentSum = currentSum - array.get(left);
		           }
		           left = left + 1;
		           continue;
		       }
		    }
		    if(!found){
		        System.out.println("-1");
		    }
		    t = t - 1;
		}
	}
}
