import java.io.*;
import java.util.*;
class Linked
{
	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	public int length()
	{
		Node temp=head;
		int count=0;
		while(temp!=null)
		{
			temp=temp.next;
			count++;
		}
		return count;
	}
	public void at_Begin(int d)
	{
		Node new_node=new Node(d);
		// new_node.next=head;
		head=new_node;
		new_node.next=null;
	}
	public void append(int d)
	{
		Node new_node=new Node(d);
		if(head==null)
		{
			head=new_node;
			
		}
		
		else
		{
			Node current=head;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next=new_node;
		}
		new_node.next=null;
	}
	public void insert_after(int pos,int d)
	{
		Node new_node=new Node(d);

		int count=length();
		if(pos==1)
		{
			new_node.next=head;
			head=new_node;
		}
		
		else if(count>=pos)
		{
			count=1;
			Node temp=head;
			while(temp!=null)
			{
				count++;
				if(count==pos)
				{

					new_node.next=temp.next;
					temp.next=new_node;
					break;
				}
				else
				{
					temp=temp.next;
				}
			}
		}
		else
		{
			System.out.println("There is the out of position plz select within the position");
		}
	}
	public void pos_delete(int pos)
	{
		int len=length();
		Node previous=null;
				// System.out.println("length  :"+len);
		if(len<pos || pos==1){
			if(pos==1)
				head=head.next;
			else
				System.out.println("There is not available the position select within in the range 1 to "+len);
		}
		
		else
		{
			
			int count=0;
			Node temp=head;
			while(temp!=null)
			{
				// System.out.println("awesome");
				count++;
				if(count==pos)
				{
				previous.next=temp.next;
				break;
			}
				else
				{
					previous=temp;
					temp=temp.next;
				}
			}
		}
	}
	public void display()
	{
		Node print=head;
		while(print!=null)
		{
			System.out.print(print.data+"-->");
			print=print.next;
		}
		System.out.println();
	}
	public void Reverse_Recursion(Node temp)
	{
		if(temp==null)
			return ;
		Reverse_Recursion(temp.next);
		System.out.print(temp.data+"-->");
	}
	public void sorting(Node head)
	{
		int len=length();int data;
		for(int i=0;i<len;i++)
		{
			Node temp=head;
			Node temp1=head.next;
			for(int j=0;j<len-1;j++)
			{
				if(temp.data>temp1.data)
				{
					data=temp.data;
					temp.data=temp1.data;
					temp1.data=data;
				}
				temp=temp.next;
				temp1=temp1.next;

			}
		}
		while(head!=null)
		{
			System.out.print(head.data+"-->");
			head=head.next;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Linked ln=new Linked();
		while(true){
		System.out.println("1.Begin , 2.Append , 3.Insert_after ,4.Pos_delete ,5.Display ,6.Reverse 7.sorting(Bubble_Sort) ");
		int n=sc.nextInt();
		int data,pos;
		if(n==1)
		{
			System.out.println("Enter the data :");
			data=sc.nextInt();
			ln.at_Begin(data);
			ln.display();
		}
		else if(n==2)
		{
			System.out.println("Enter the data :");
			data=sc.nextInt();
			ln.append(data);
			ln.display();
		}
		else if(n==3)
		{
			System.out.println("Enter the data :");
			data=sc.nextInt();
			System.out.println("Enter the position");
			pos=sc.nextInt();
			ln.insert_after(pos,data);
			ln.display();
		}
		else if(n==4)
		{
			System.out.println("Enter the data position to be delete");
			pos=sc.nextInt();
			ln.pos_delete(pos);
			ln.display();
		}
		else if(n==5)
		{
			System.out.println("The elements are :");
			ln.display();
		}
		else if(n==6)
		{
			System.out.println("The Reverse order :");
			
			ln.Reverse_Recursion(ln.head);
			System.out.println();
		}
		else if(n==7)
		{
			System.out.println("Bubble sort :");
			System.out.println("Before Sorting the techniques :");
			ln.display();
			System.out.println("After Sorting the techniques :");
			ln.sorting(ln.head);
			System.out.println();
			
		}
		else
			break;
	}
	}
}