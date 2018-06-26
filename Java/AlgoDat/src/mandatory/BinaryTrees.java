package mandatory;

import java.util.Scanner;

public class BinaryTrees {

	static class Node {
		Node left, right;
		int key;

		Node(int k, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.key = k;
		}
	}
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Node head = readBinaryTree();
		traversal(head);
	}

	static Node readBinaryTree() {
		int A = sc.nextInt();
		
		if ( A == 0) 
			return null;
		else 
			return new Node(A, readBinaryTree(), readBinaryTree());
	}
	
	static void traversal(Node n){
		if(n == null) return;
		
		int left, right;
		if(n.left != null)
			left = n.left.key;
		else 
			left = 0;
		
		if(n.right != null)
			right = n.right.key;
		else 
			right = 0;
		
		int sum = n.key + left + right;
		
		System.out.print(sum + " ");
		
		if(n.left != null)
			traversal(n.left);
		
		if(n.right != null)
			traversal(n.right);
		
	}

}
