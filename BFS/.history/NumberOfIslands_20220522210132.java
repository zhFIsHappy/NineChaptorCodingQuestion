class Coordinate{
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y
    }
}
public class NumberOfIslands {
    int[] deltaX = {0,1,-1,0};
    int[] deltaY = {1,0,0,-1};
    public int numIslands(boolean[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int islands = 0;
        int row = grid.length, col = grid[0].length;
        int[][] visited = new int[row][col];
        for(int i = 0; i < row, i++){
            for(int j =0 ;j < col; j++){
                if(grid[i][j] && !visited[i][j]){
                    bfs(grid,i , j , visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void bfs(boolean[][] grid, int x, int y, int[][] visited) {
        Queue<Coordinate>  queue = new ArrayDeque <>();
        queue.offer(new Coordinate(x,y));
        while(!queue.isEmpty()){
            Coordinate coor = queue.poll();
            
        }
    }
}
