import java.io.*;
import java.util.*;
class TrieHashMap{
	class Node{
		HashMap<Character,Node> map;
		boolean isEnd;
		Node(boolean isEnd){
			this.isEnd = isEnd;
			map = new HashMap<Character,Node>();
		}
	}
	Node root;
	void rootInitialize(){
		root = new Node(false);
	}
	boolean isAvailable(Node temp,char val){
		if(temp.map.containsKey(val))
			return true;
		return false;
	}
	Node createNewNode(boolean isEnd){
		return new Node(isEnd);
	}
	void insertDictionary(String data){
		Node temp = root;
		for(int i = 0;i<data.length();i++){
			if(isAvailable(temp,data.charAt(i))){
				temp = temp.map.get(data.charAt(i));
			}
			else{
				if(i == data.length()){
					temp.map.put(data.charAt(i),createNewNode(true));
					temp = temp.map.get(data.charAt(i));
				}
				else{
					temp.map.put(data.charAt(i),createNewNode(false));
					temp = temp.map.get(data.charAt(i));
				}
			}
		}
	}
	boolean isDataFound(String data){
		Node temp = root;
		boolean status = true;
		for(int i=0;i<data.length();i++){
			if(isAvailable(temp,data.charAt(i))){
				temp = temp.map.get(data.charAt(i));
			}
			else{
				status = false;
				break;
			}
		}
		return status;
	}
	String getPrefix(String data){
		String prefix="";
		Node temp = root;
		for(int i = 0;i<data.length();i++){
			if(isAvailable(temp,data.charAt(i))){
				temp = temp.map.get(data.charAt(i));
				prefix = prefix+data.charAt(i);
			}
			else
				return prefix;
		}
		return prefix;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TrieHashMap tmap = new TrieHashMap();
		tmap.rootInitialize();
		System.out.println("Data insertion  : ");
		System.out.println("Enter the string :");
		String d = sc.nextLine();
		String array[] = d.split(" ");
		for(int i=0;i<array.length;i++){
			tmap.insertDictionary(array[i]);
		}
		System.out.println("Searching Data : ");
		for(int j=0;j<array.length;j++){
			System.out.println(array[j]+"---->"+tmap.isDataFound(array[j]));
		}
		System.out.println("Enter the data to find Longest Prefix Matching :");
			String ispre = tmap.getPrefix(sc.next());
			if( ispre.length() == 0)
				System.out.println("There is no prefix found");
			else
				System.out.println("The longest prefix is :"+ispre);
		
	}
}