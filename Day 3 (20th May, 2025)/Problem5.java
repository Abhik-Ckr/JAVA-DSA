//Determine if a given directed graph contains a cycle.

// import java.util.LinkedList;
// import java.util.Queue;
import java.util.*;


public class Problem5 {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V]; 
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int node = q.peek(); //q.front();
            q.remove();
            count++;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(count == V){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); 

        Problem5 obj = new Problem5();
        boolean hasCycle = obj.isCyclic(V, adj);

        System.out.println("Does the graph contain a cycle? " + hasCycle);
    }
}
