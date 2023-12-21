class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, columns = maze[0].length;
        // Note that we immediately mark the node as visited when putting into the queue as to
        // prevent other nodes from visiting it. Otherwise, we will be trapped in an infinite loop.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}}; // 2D array to keep track of the directions to take.
        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++;
            // Keep track of the queue size because the queue size continuously changes as we check for the other nodes,
            // which can lead to infinite loops or undue termination of the for-loop.
            int n = queue.size();
            // Check every node at the current step.
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    // Check if this direction out of bound.
                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    // Check if this direction is the wall.
                    if (maze[x][y] == '+') continue;

                    // If this direction is empty, not visited and is at the boundary, we have arrived at the exit.
                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return steps;
                    // Otherwise, we change this direction as visited and put into the queue to check at the next step.
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1; // If no exits found, return -1.
    }
}

