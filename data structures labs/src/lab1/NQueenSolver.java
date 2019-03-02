package lab1;

public class NQueenSolver {
	boolean isSafe(int board[][], int row, int col, int n) {
		//Check row
		for(int i = 0; i < col; i++)
			if(board[row][i] == 1)
				return false;
		//Check up left diagonal
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if(board[i][j] == 1)
				return false;
		//Check down left diagonal
		for(int i = row, j = col; i < n && j >= 0; i++, j--)
			if(board[i][j] == 1)
				return false;
		
		return true;
	}
	
	private boolean solveNQueenUtil(int[][] board, int col, int n) {
		//base case if solution found
		if(col >= n)
			return true;
		//pick column to check for queen placement
		for(int i = 0; i < n; i++) {
			//check if can place queen in row of current column
			if(isSafe(board, i, col, n)) {
				board[i][col] = 1;
				//recursion to check rest of columns
				if(solveNQueenUtil(board, col + 1, n) == true)
					return true;
				//recursive backtrack if a previous queen did not lead to a solution >>> remove queen from board
				board[i][col] = 0;
			}
		}
		//no safe placement in any row of first column = no solution = return false
		return false;
	}
	
	void printSolution(int board[][], int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) { 
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println(); 
        } 
    } 
	
	boolean solve(int n) {
		//create board of size n,n filled with 0s
		int board[][] = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				board[i][j] = 0;
		
		if(solveNQueenUtil(board, 0, n) == false) {
			System.out.println("No Solutions");
			return false;
		}
		printSolution(board, n);
		return true;
	}
}
