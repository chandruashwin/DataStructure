import java.io.*;
import java.util.*;
class BFS{
	Scanner sc = new Scanner(System.in);
	int v = 6;
	String output ="";
	int visiVertex[] = new int[9];
	List<Integer> q = new ArrayList<Integer>();
	HashMap<Integer,LinkedList<Integer>> edg = new HashMap<Integer,LinkedList<Integer>>();
	void createBFS(){
		for (int i = 1; i <= v ; i++ ) {
			LinkedList li = new LinkedList();
			addEdge(li);
			edg.put(i,li);	
		}
		bfs();
	}
	void bfs(){
		for(int i=1;i<=v;i++){
			addQueue(i);
				// printQueue();
		}
		print();
		System.out.println("The Path For Breath First Search : " +output);
				// printQueue();
	}
	LinkedList<Integer> getList(int key){
		return edg.get(key);
	}
	// void printQueue(){
	// 	System.out.println("Queue values :");
	// 	for(Integer i : q){
	// 		System.out.print(i+" ");
	// 	}
	// 	System.out.println();
	// }
	void addQueue(int key){
		LinkedList<Integer> li = getList(key);
		q.add(key);
		for (Integer i : li) {
			// System.out.print(i+" ");
			q.add(i);
		}
		// System.out.println();
		
	}
	void print(){
		for(Integer val : q){
			// System.out.print(val+" ");
			if(checkVisited(val) == 0){
				visiVertex[val] = 1;
				output = output + String.valueOf(val)+" ";
				// q.remove(index);
			}
			else{
				visiVertex[val] = 1;
			}
		}
	}
	int checkVisited(int key){
		return visiVertex[key];
	}
	void addEdge(LinkedList<Integer> li){
		System.out.println("Enter 0 to exit");
		int end = sc.nextInt();
		while(end!=0){
			li.add(end);
			end = sc.nextInt();
		}
	}
	public static void main(String[] args) {
		BFS g = new BFS();
		g.createBFS();
	}
}