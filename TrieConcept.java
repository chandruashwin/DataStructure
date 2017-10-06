import java.io.*;
import java.util.*;
class TrieConcept{
		static class Trie{
			boolean isEnd;
			Trie children[] = new Trie[256];
			int count = 0;
			Trie(boolean isEnd){
				this.isEnd = isEnd;
				for(int i=0;i<26;i++)
					children[i] = null;
			}
		}
		static Trie root;
		static Trie temp_root;
		static int totalCount = 0;
		static void insertString(String inputData){
				temp_root = root;
				for(int i=0;i<inputData.length();i++){
					int index = (int)inputData.charAt(i);
					if(temp_root.children[index]==null && i<inputData.length()-1){
						temp_root.children[index] = new Trie(false);
						temp_root.count=1;
						// System.out.println(temp_root.count+"---->");
						temp_root = temp_root.children[index];
					}
					else if(temp_root.children[index]==null && i==inputData.length()-1){
						temp_root.children[index] = new Trie(true);
						temp_root.count=1;
						// System.out.println(temp_root.count+"<----");
						temp_root = temp_root.children[index];
					}
					else{
						temp_root.count++;
						// System.out.println(temp_root.count+"---------");
						temp_root = temp_root.children[index];
					}
				}
		}
		static boolean searchWholeString(String searchData,boolean prefixStatus){
			temp_root = root;
			boolean status = false;
			for(int i=0;i<searchData.length();i++){
				int index = (int)searchData.charAt(i);
				if(temp_root.children[index]!=null && i<searchData.length()-1 && !temp_root.isEnd ){
					totalCount = temp_root.count;
					temp_root = temp_root.children[index];
					status = false;
				}
				else if(i==searchData.length()-1){
					totalCount = temp_root.count;
					temp_root = temp_root.children[index];
					if(temp_root.isEnd && !prefixStatus)
					status = true;
					else if(!temp_root.isEnd && prefixStatus)
						status = true;
				}
				else{
					status = false;
					break;
				}
			}
			return status;
		}
		static void deleteWholeString(String deleteData){
			Trie current_temp;
			temp_root = root;
			for(int i=0;i<deleteData.length();i++){
				int index = (int)deleteData.charAt(i);
				if(temp_root.children[index]!=null){
					current_temp = temp_root.children[index];
					temp_root.children[index] = null;
					temp_root = current_temp;
				}
			}
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TrieConcept t = new TrieConcept();
		root = new Trie(false);
		while(true){
			System.out.println("\n\n0.Exit\t 1.Insert\t 2.Search Whole String\t 3.SearchPrefix\t 4.Delete\t 5.CountOfString\n");
			int choose = sc.nextInt();
			String input="";
			boolean prefixStatus = false;
			switch(choose){
				case 0:
					break;
				case 1:
					System.out.println("\nEnter the string :");
					sc.nextLine();
					input = sc.nextLine();
					t.insertString(input);
					break;
				case 2:
					System.out.println("\nEnter the string to search :");
					sc.nextLine();
				    input = sc.nextLine();
					if(t.searchWholeString(input,false))
						System.out.println("\n\n****************   Yes the string is available   ******************");
					else
						System.out.println("\n\n****************   The string does not exist     ******************");
					break;
				case 3:
					System.out.println("\nEnter the prefix string :");
					sc.nextLine();
					input = sc.nextLine();
					if(t.searchWholeString(input,true))
						System.out.println("\n\n****************   Yes the prefix string is available   ******************");
					else
						System.out.println("\n\n****************   The prefix string does not exist     ******************");
					break;
				case 4:
					System.out.println("\nEnter the String to delete :");
					sc.nextLine();
					input = sc.nextLine();
					if(t.searchWholeString(input,false))
					{
						System.out.println("\n\n****************   This is whole string so we can delete   ***************");
						deleteWholeString(input);
						System.out.println("\n\n****************   The string has been deleted successfully ***************");

					}
					else
						System.out.println("\n\n*************** we cant delete its prefix string to other string************");
					break;
				case 5:
				System.out.println("\nEnter the string to count :");
				sc.nextLine();
				input = sc.nextLine();
				if(t.searchWholeString(input,false))
				{
					System.out.println("\n\n***************** The total count of this word :"+totalCount);
				}
				else{
					System.out.println("\n\n*******************  Its not whole string so wa cant able to count     ******************");
				}
				break;
				default :
					System.out.println("\n\t\tError----->Select valid option");
					break;
			}
			if(choose == 0)
				break;
		}
	}
}
