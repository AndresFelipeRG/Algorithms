import java.util.*;
public class ZigzagIterator {

    Iterator<Iterator<Integer>> it;
    ArrayList<Iterator<Integer>> temp;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if ((v1 == null || v1.size() == 0) && (v2 == null || v2.size() == 0 )) this.temp =  new ArrayList<>() ;
        else if((v1 == null || v1.size() == 0) && v2 != null)  this.temp = new ArrayList<>(Arrays.asList( v2.iterator()));
        else if(v1 != null && (v2 == null || v2.size() == 0 ))  this.temp = new ArrayList<>(Arrays.asList(v1.iterator()));
        else  this.temp = new ArrayList<>(Arrays.asList(v1.iterator(), v2.iterator()));
        this.it = temp.iterator();
    }

    public int next() {
        
       
        Iterator<Integer> t = this.it.next();
        Integer ans = t.next();
        if(!t.hasNext()) this.it.remove();
        return ans;
        
    }

    public boolean hasNext() {
        if(!this.it.hasNext()) this.it = this.temp.iterator();
        return this.it.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
