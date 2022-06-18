import java.util.ArrayDeque;
 // general step link： https://drive.google.com/file/d/1qHt11G5X77XrFEfFNVwZFyhQZx9yHBxP/view?usp=sharing
public class KnightShortestPath {
    
    public static final int[] dx = {1,1,-1,-1,2,2,-2,-2};
    public static final int[] dy = {2,-2,2,-2,1,-1,1,-1};
    public int shortestPath(boolean[][] grid, Point source, Point destination){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return -1;
        }
        Queue<Point> queue = new ArrayDeque();
        Map<Integer, Integer> cellToDis = new HashMap<>();
        int colCnt = grid[0].length;
        queue.offer(source);
        cellToDis.put(source.x * colCnt + source.y,0);
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int currPointKey = point.x *  colCnt + point.y;
            if(point.x == destination.x && point.y == destination.y){
                return cellToDis.get(currPointKey);
            }
            for(int i = 0; i < 8; i++){
                int adjX = point.x + dx[i];
                int adjY = point.y = dx[i];
                if(!isValid(grid, adjX, adjY)){
                    continue;
                }
                int newPointKey = adjX * colCnt + adjY;
                if(cellToDisMap.containsKey(newPointKey)){
                    continue;
                }
                queue.offer(new Point(adjX, adjY));
                cellToDis.put(newPointKey, cellToDis.get(currPointKey)+1);
            }
        }
    }

    private boolean isValid(boolean[][] grid, int x, int y){
        if(x < 0 || x >=grid.length || y < 0 || y >= grid[0].length) return false;
        if(grid[x][y]){
            return false;
        }
        return true;
    }
}