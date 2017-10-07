import java.io.*;
import java.util.*;
class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
class TreeConcept{
	Node queue[] = new Node[100];
	int rear = -1;
	int front = -1;
	Node root;
	boolean status = false;
	TreeConcept(){
		root = null;
	}
	void insertOperation(int data){
		root = insert(root,data);
	}
	void inorderTraversal(){
		inorder(root);
	}
	void preOrderTraversal(){
		preorder(root);
	}
	void postOrderTraversal(){
		postorder(root);
	}
	void searchOperation(int data){
		status = false;
		if(inorder(root,data))
			System.out.println("Its correct there is the search element is available");
		else
			System.out.println("There is no search element");
	}
	void deleteOperation(int data){
		status = false;
		Node previous = null;
		if(inorder(root,data)){
			root = delete(root,data);
				System.out.println("Successfully deleted");
			}
		else{
			System.out.println("There is no data ");
		}
		inorder(root);
	}
	void leverOrderTraversal(){
		if(rear == 0 && front == 0)
			System.out.println("The queue is empty");
		else{
			int p = 0;
			queue[++rear] = root;
			while(queue[++front]!=null){
				p++;	
				System.out.print(queue[front].data+"\t");
				queue[++rear] = queue[front].left;
				queue[++rear] = queue[front].right;
			}
		}

	}
	Node insert(Node root,int data){
		if(root == null){
			root = new Node(data);
			return root;
		}
		if(root.data<=data){
			root.right = insert(root.right,data);
		}
		else if(root.data>=data){
			root.left = insert(root.left,data);
		}
		return root;
	}
	void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data+"  ");
			inorder(root.right);
		}
	}
	void preorder(Node root){
		if(root!=null){
			System.out.print(root.data+"  ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	void postorder(Node root){
		if(root!=null){
			preorder(root.left);
			preorder(root.right);
			System.out.println(root.data+"  ");
		}
	}
	boolean inorder(Node root,int data){

		if(root!=null){
			if(root.data == data){
				status = true;
				return status;
			}
			inorder(root.left,data);
			inorder(root.right,data);
		}
		return status;
	}
	Node delete(Node root,int data){
		if(root == null)
			return root;
		else if(root.data < data){
			root.right = delete(root.right,data);
		}
		else if(root.data > data){
			root.left = delete(root.left,data);
		}
		else{
			if(root.right == null)
				return root.left;
			else if(root.left == null)
				return root.right;
			else{
				root.data = minValue(root.right);
				root.right = delete(root.right,root.data);
			}
		}
		return root;
	}
	int minValue(Node root){
		int min = root.data;
		while(root.left!=null){
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeConcept t = new TreeConcept();
		while(true){
			System.out.println("\n1.Insert\t 2.Search\t 3.Delete\t 4.Inorder Traversal\t 5.PostOrder Traversal\t 6.PreOrder Traversal\t 7.LevelOrder Traversal\t 0.Exit");
			int choose = sc.nextInt();
			switch(choose){
				case 0:
					break;
				case 1:
					System.out.println("Enter the data to insert :");
					int data = sc.nextInt();
					t.insertOperation(data);
					break;
				case 2:
					System.out.println("Enter the element to search :");
					data = sc.nextInt();
					t.searchOperation(data);
					break;
				case 3:
					System.out.println("Enter the element to search :");
					data = sc.nextInt();
					t.deleteOperation(data);
					break;
				case 4:
					t.inorderTraversal();
					break;
				case 5:
					t.postOrderTraversal();
					break;
				case 6:
					t.preOrderTraversal();
					break;
				case 7:
					t.leverOrderTraversal();
					break;
				default:
					System.out.println("Select valid operation");
					break;
			}
			if(choose==0)
				break;
		}
	}
}