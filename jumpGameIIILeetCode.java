class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int n = arr.length;
        if((n==1 && arr[0] == 0) || (arr[start] == 0)) return true;
        if(n == 0 || start < 0 || start > n) return false;
        LinkedList<Integer> graph []= new LinkedList[n];
        for(int i = 0; i < n; i++){
            LinkedList<Integer> nei = new LinkedList();

            if (arr[i]>0 && i-arr[i] >= 0) nei.add(i-arr[i]);
            if (arr[i]>0 && i+ arr[i] < n) nei.add(i+arr[i]);
            graph[i] = nei;        
        }
        
       
        System.out.println(Arrays.toString(graph));
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        
            Queue<Integer> q = new LinkedList();
            q.offer(start);
            while(q.size() > 0){
                LinkedList<Integer> nei = graph[q.poll()];
                for(int i = 0; i < nei.size(); i++){
                    if(!visited[nei.get(i)]){
                        visited[nei.get(i)] = true ;
                        if(arr[nei.get(i)] == 0) return true;
                        else q.offer(nei.get(i));
                    }
                }
            }
           
        return false;
        
    }
}
