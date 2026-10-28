import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Create adjacency list
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Step 2: Store edges
        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            graph[u].add(new int[]{v, w});
        }

        // Step 3: Initialize distances
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // Step 4: Priority Queue
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{k, 0});

        // Step 5: Dijkstra's Algorithm
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int time = curr[1];

            // Skip outdated distance
            if (time > dist[node]) {
                continue;
            }

            // Visit neighbors
            for (int[] edge : graph[node]) {

                int nextNode = edge[0];
                int weight = edge[1];

                int newTime = time + weight;

                // Relaxation
                if (newTime < dist[nextNode]) {

                    dist[nextNode] = newTime;

                    pq.offer(new int[]{nextNode, newTime});
                }
            }
        }

        // Step 6: Find maximum distance
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}