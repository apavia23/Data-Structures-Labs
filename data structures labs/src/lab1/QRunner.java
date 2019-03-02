package lab1;

public class QRunner {

	public static void main(String[] args) {
		NQueenSolver board = new NQueenSolver();

		board.solve(4);
		System.out.println("\n");
		board.solve(5);
		System.out.println("\n");
		board.solve(6);
		
		/*
		for(int i = 1; i < 10; i++) {
			board.solve(i);
			System.out.println("\n");
		}*/
	}
}
