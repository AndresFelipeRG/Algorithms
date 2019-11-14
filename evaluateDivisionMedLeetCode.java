import java.util.*;


class Solution {
    
    public Double findDivision(String current,  String target, Map<String, List<String>> graph, Set<String> visited, Map<String, Double> divs){
        if(graph.containsKey(current)){
        for(String neighbor: graph.get(current)){
            if(!visited.contains(neighbor)){
                
            
            visited.add(neighbor);
            if(neighbor.equals(target)){
                
                return divs.containsKey(current+"/"+target) ? divs.get(current+"/"+ target) : 0.0;
            }
            else{
                Double res = findDivision(neighbor, target, graph, visited, divs);
                if(res != 0.0){
                    return divs.get(current+"/"+neighbor)*res;
                }
            }
            }
        }
        }
        return 0.0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
      
        Map<String, Double> divs = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        double [] ans = new double [queries.size()];
        Iterator it = equations.iterator();
        int count = 0;
        while(it.hasNext()){
            
            List<String> lst = (List<String>) it.next();
            
            String sA = lst.get(0);
            String sB = lst.get(1);
            Double val = values[count];
            String sDivA = sA+"/"+sB;
            String sDivB = sB+"/"+sA;
            
            
            
            if(!graph.containsKey(sA)){
                
                List<String> neighbors = new ArrayList<>();
                neighbors.add(sB);
               
                graph.put(sA, neighbors);
                
            }else{
                
                List<String> neighbors = graph.get(sA);
                neighbors.add(sB);
                graph.put(sA, neighbors);
                
            }
            
            if(!graph.containsKey(sB)){
                
                List<String> neighbors = new ArrayList<>();
                neighbors.add(sA);
                graph.put(sB, neighbors);
                
            }else{
                
                System.out.println(String.valueOf(graph.get(sB)));
                List<String> neighbors = graph.get(sB);
                neighbors.add(sA);
                graph.put(sB, neighbors);
                
            }
            
            if(!divs.containsKey(sDivA)){
                divs.put(sDivA, val);
            }
            if(!divs.containsKey(sDivB)){
                divs.put(sDivB, 1.0/val);
            }
            count++;
        }
        
        it = queries.iterator();
        count = 0;
        while(it.hasNext()){
            
            List<String> query = (List<String>) it.next();
            String sA  = query.get(0);
            String sB  = query.get(1);
            Double res = findDivision(sA, sB, graph, new HashSet<>(), divs) ;
            ans[count++] = res == 0 ? -1.0: res ;
            
            
        }
        
        
        return ans;
    }
    
    
}
