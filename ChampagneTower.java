import java.util.*;

class Solution {
    
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) return 0.0;
        
        List<List<Double>> cups = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            List<Double> row = new ArrayList<>();
            for(int j = 0; j <= i ; j++){
                row.add(0.0);
            }
            cups.add(row);
        }
        cups.get(0).set(0, poured*1.0);
        
        for(int i = 1; i < 100; i++){
            
            for(int j = 0; j <= i ; j++){
                 if(j == 0 ){
                       Double qte = Math.max((cups.get(i-1).get(0)-1)/2, 0);
                       cups.get(i).set(j, qte);
                
                 }else if(j == i){
                       Double qte = Math.max((cups.get(i-1).get(j-1)-1)/2, 0);
                       cups.get(i).set(j, qte);
                 
                 }else {
                       Double qte = Math.max((cups.get(i-1).get(j-1)-1)/2.0, 0);
                       qte +=Math.max((cups.get(i-1).get(j)-1)/2.0, 0) ;
                       cups.get(i).set(j, qte);
                 }
        
            }
        }
        
       // System.out.println(String.valueOf(cups));
       
        return Math.min(cups.get(query_row).get(query_glass), 1);
        
    }
}
