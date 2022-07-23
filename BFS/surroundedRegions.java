class Coordinate{
    int x, y;
    public Coordinate (int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return ;
        }
        //第一列和 最后一列 如果有 O 放到queue里
        Queue<Coordinate> queue = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                board[i][0] = 'T';
                queue.offer(new Coordinate(i,0));
            }
            
            if(board[i][board[0].length - 1] == 'O'){
            board[i][board[0].length -1] = 'T';
            queue.offer(new Coordinate(i, board[0].length-1));
            }
        }
        //第一行和 最后一行 如果有 O 放到queue里
        for(int i = 0; i< board[0].length; i ++){
            if(board[0][i] == 'O'){
                board[0][i] = 'T';
                queue.offer(new Coordinate(0, i));
            }
            if(board[board.length-1][i] == 'O'){
                board[board.length -1][i] = 'T';
                queue.offer(new Coordinate(board.length -1, i));
                
            }
        }
        
        int[] adjX = {0,1,-1,0};
        int[] adjY = {1,0,0,-1};
        //对在border的O进行BFS 如果与他相连的有O的话 我们变成T 并且对其BFS
        while(!queue.isEmpty()){
            Coordinate cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int tempX = cur.x + adjX[i];
                int tempY = cur.y + adjY[i];
                if(!inBound(board,tempX, tempY)){
                    continue;
                }
                if(board[tempX][tempY] == 'O'){
                    queue.offer(new Coordinate(tempX, tempY));
                    board[tempX][tempY] = 'T';
                }
            }
        }
        //纯纯的在board中间的所有没有被bfs到的O， 变成X
        for(int i = 0; i< board.length; i ++){
            for(int j =0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        //把T变回O 
        for(int i =0 ; i< board.length; i++){
            for(int j =0; j< board[0].length; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private boolean inBound(char[][]board, int x, int y){
        return x>=0 && x<board.length && y>=0 && y< board[0].length;
    }
}