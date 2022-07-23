public class wallsAndGates {
     /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int x, int y, int distance) {
        if (x < 0 || x>= rooms.length|| y< 0 || y>= rooms[0].length || rooms[x][y] < distance) { //最后一个check是check是否该走还没走的
            return;
        }
        if (rooms[x][y] > distance || distance == 0) { //剪枝要更specific 让dfs少走， 否则会超时
            rooms[x][y] = distance;
            dfs(rooms, x + 1, y, distance + 1);
            dfs(rooms, x, y + 1, distance + 1);
            dfs(rooms, x - 1, y, distance + 1);
            dfs(rooms, x, y - 1, distance + 1);
        }
    }
    
    private boolean inBound(int[][] rooms, int x, int y) {
        return x >= 0 && x < rooms.length && y >=0 && y < rooms[0].length;
    }
}
