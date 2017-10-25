import java.io.*;
import java.util.*;
class DFS{
	static Scanner sc = new Scanner(System.in);
	private static String start = "";
	private static int v = 0;
	private static int top = 0;
	private static HashMap<String,LinkedList<String>> hmap = new HashMap<String,LinkedList<String>>();
	private static HashSet<String> visited = new HashSet<String>();
	private static String stack[];
	static void setVertices(int v){
		stack = new String[v];
		for(int i = 0;i < v ; i++){
			System.out.println("Enter the vertice name :");
			String val = sc.next();
			if(i==0){
				start = val;
				stack[top++] = val;
				visited.add(val);
			}
			System.out.println("Enter the connected vertices :");
			System.out.println("*******\tEnter 0 to exit\t*******");
			hmap.put(val,setConnections());
			// visited.add(val);
		}
	}
	static LinkedList<String> setConnections(){
		LinkedList<String> list = new LinkedList<String>();
		String check = "";
		while(true){
			check = sc.next();
			if(check.equals("0"))
				break;
			else
				list.add(check);
		}
		return list;
	}
	static void readVertices(String start){
		boolean status = false;
		LinkedList<String> list = getConnections(start);
		String current = "";
		int count = 0;
		int size = list.size();
		for (String obj : list) {
			if(!visited.contains(obj)){
				stack[top++] = obj;
				visited.add(obj);
				status = true;
				current = obj;
				break;
			}
			
		}
		if(status==true){
			readVertices(current);
		}
		else if(status == false && visited.size()<v){
			current = stack[top - 2];
			--top;
			readVertices(current);
		}

	}
	static LinkedList<String> getConnections(String key){
		return hmap.get(key);
	}
	public static void main(String[] args) {
		System.out.println("Enter the number of vertices");
		v = sc.nextInt();
		setVertices(v);
		readVertices(start);
		for(int i=0;top>i;i++){
			System.out.print(stack[i]+" ---  ");
		}
	}
}