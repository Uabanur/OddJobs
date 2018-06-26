package mandatory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AlternatingPaths {
	
	static class Node {
		int x, y, depth;
		Node(int x, int y, int depth){
			this.x = x;
			this.y = y; 
			this.depth = depth;
		}
		Node(int x, int y){
			this.x = x;
			this.y = y; 
			this.depth = 0;
		}
		
	}
	
	static int size;
	static int[][] matrix;

	public static void main(String[] args) {
		setFields();
		
		System.out.println(BFS(new Node(0, 0), new Node(size-1, size-1)));
	}

	
	private static int BFS(Node start, Node end){
		LinkedList<Node> S = new LinkedList<>();
		Node first = new Node(start.x, start.y, 1);
		
		S.addLast(first);
		
		while(!S.isEmpty()){
			Node current = S.pop();
			
			S.addAll(possibleSteps(current));
			
			matrix[current.x][current.y] = 2;
			
//			printMatrix();
			
			if(current.x == end.x && current.y == end.y){
				return current.depth;
			}
		}
		return -1;
	}


	private static List<Node> possibleSteps(Node current){
		List<Node> moves = new LinkedList<>();
		
		if(matrix[current.x][current.y] == 1){
			
			if(current.x-1 >= 0 && matrix[current.x-1][current.y] == 0){
				moves.add(new Node(current.x-1, current.y, current.depth+1));
			}
			
			if(current.x+1 < size && matrix[current.x+1][current.y] == 0){
				moves.add(new Node(current.x+1, current.y, current.depth+1));
			}
			
			if(current.y-1 >= 0 && matrix[current.x][current.y-1] == 0){
				moves.add(new Node(current.x, current.y-1, current.depth+1));
			}
			
			if(current.y+1 < size && matrix[current.x][current.y+1] == 0){
				moves.add(new Node(current.x, current.y+1, current.depth+1));
			}
			
		} else if(matrix[current.x][current.y] == 0){
			
			
			if(current.x-1 >= 0 && matrix[current.x-1][current.y] == 1){
				moves.add(new Node(current.x-1, current.y, current.depth+1));
			}
			
			if(current.x+1 < size && matrix[current.x+1][current.y] == 1){
				moves.add(new Node(current.x+1, current.y, current.depth+1));
			}
			
			if(current.y-1 >= 0 && matrix[current.x][current.y-1] == 1){
				moves.add(new Node(current.x, current.y-1, current.depth+1));
			}
			
			if(current.y+1 < size && matrix[current.x][current.y+1] == 1){
				moves.add(new Node(current.x, current.y+1, current.depth+1));
			}
		}
		return moves;
	}

	private static void setFields() {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		sc.nextLine();
		
		matrix = getMatrix(size, sc);
		sc.close();
	}


	private static int[][] getMatrix(int size, Scanner sc) {
		int[][] matrix = new int[size][size];
		for (int col = 0; col < size; col++) {
			String line = sc.nextLine();
			for(int row = 0; row < size; row++){
				matrix[row][col] = Integer.parseInt("" + line.charAt(row));
			}
		}
		return matrix;
	}
	
	private static void printMatrix(){
		System.out.println();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++)
				System.out.print(matrix[j][i] + " ");
			System.out.println();
		}
		System.out.println();
	}

}
