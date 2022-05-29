public class KnightShortestPath {
    public static final int[] dx = {1,1,-1,-1,2,2,-2,-2};
    public static final int[] dy = {2,-2,2,-2,1,-1,1,-1};
    public int shortestPath(boolean[][] grid, Point source, Point destination){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return -1;
        }
        Queue<Point> queue = new ArrayDeque<t>();
        Set
    }
}