import java.io.*;
import java.util.*;
class Mergesort{
	void Merge(int array[],int left,int right,int mid){
		int leftsize = mid - left + 1;
		int rightsize = right - mid;
		int leftArray[] = new int[leftsize];
		int rightArray[] = new int[rightsize];
		for(int i=0;i<leftsize;i++)
			leftArray[i] = array[i+left];
		for(int i=0;i<rightsize;i++)
			rightArray[i] = array[i+1+mid];
		int k = left;
		int i = 0,j=0;
		while(i<leftsize && j<rightsize){
			if(leftArray[i]>=rightArray[j]){
				array[k] = rightArray[j];
				j++;

			}
			else{
				array[k] = leftArray[i];
				i++;
			}
			k++;
		}
		while(i<leftsize){
			array[k] = leftArray[i];
			i++;
			k++;
		}
		while(j<rightsize){
			array[k] = rightArray[j];
			k++;
			j++;
		}
	}
	void Partition(int array[],int left,int right){
		if(left<right){
			int mid = (left+right)/2;
			Partition(array,left,mid);
			Partition(array,mid+1,right);
			Merge(array,left,right,mid);
		}
	}
	void print(int array[]){
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+"  ");
		System.out.println();
	}
	public static void main(String[] args) {
		int array[] = {12,5,1233,21,0,101,121,12,1,100,};
		Mergesort m = new Mergesort();
		m.Partition(array,0,array.length-1);
		m.print(array);
	}
}