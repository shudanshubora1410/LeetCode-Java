class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new java.util.ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        return count == numCourses;
    }
}
