class Coordinate {
    int x; 
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        Queue<Coordinate> queue = new ArrayDeque<>();
        
        
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    Coordinate gate = new Coordinate(i , j);
                    queue.offer(gate);
                }
            }
        }
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            distance ++;
            for(int j = 0; j<size; j++){
                Coordinate c = queue.poll();
            
                for(int i = 0; i < 4; i++){
                    int newX = c.x + dx[i];
                    int newY = c.y + dy[i];
                    if(!isValid(rooms,newX, newY)){
                        continue;
                    }
                    if(distance < rooms[newX][newY]){
                        rooms[newX][newY] = distance;
                        queue.offer(new Coordinate(newX, newY));
                    }
                }
            }
        }
    }
    private boolean isValid(int[][] rooms, int x, int y){
        if(x < 0 || x >= rooms.length || y <0 || y >= rooms[0].length){
            return false;
        }
        if(rooms[x][y] == -1) return false;
        return true;
    }
}