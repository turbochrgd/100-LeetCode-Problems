class Solution {
    public static final int[] d = {0, 1, 0, -1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rooms[i][j] == 0) queue.offer(i * n + j); // Put gates in the queue

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int i = x / n, j = x % n;
            for (int k = 0; k < 4; ++k) {
                int p = i + d[k], q = j + d[k + 1]; // empty room
                if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] == Integer.MAX_VALUE) {
                    rooms[p][q] = rooms[i][j] + 1;
                    queue.offer(p * n + q);
                }
            }
        }
    }
}