import java.util.*;

public class Solution {

    int partition (int [] arr, int l, int h){
        int pivot = arr[h];
        int i = -1;
        for(int j = 0; j < h;j++){
            
            if( pivot > arr[j]){
              i++;
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[h] = temp;
        
        return i+1;
    }
    public void qsort(int [] arr, int l, int h){
        if(l < h ){
        int p = partition(arr, l, h);
        qsort(arr, l, p-1);
        qsort(arr, p+1, h);}
    }
}
