import java.io.*;
import java.util.*;
class QuickSort{
	int partition(int array[],int start,int end){
		int pivot = array[end];
		int i = start - 1;
		for(int j = start;j<end;j++){
			if(array[j]<=pivot){
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		int temp = array[i+1];
		array[i+1] = pivot;
		array[end] = temp;
		return i+1;
	}
	void sort(int array[],int start,int end){
		if(start<end){
			int pivot = partition(array,start,end);
			sort(array,start,pivot-1);
			sort(array,pivot+1,end);
		}
	}
	void print(int array[]){
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	public static void main(String[] args) {
		int array[] = {10,80,90,20,30,25,40,50,60,70};
		QuickSort q = new QuickSort();
		q.sort(array,0,array.length-1);
		q.print(array);
	}
}