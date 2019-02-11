/**Milena Grauzyte
 * 2038286g
 */

package AE1;

import java.util.Arrays;

public class quickSort {
	
	//1a) simple quicksort implementation
	public static int[] sort(int a[], int p, int r){
		if (p<r) {
			int q = partition(a,p,r);
			sort(a,p,q-1);
			sort(a,q+1,r);
		}
		return a;
	}
	//1a) partition implementation
	public static int partition(int a[], int p, int r) {
		int x = a[r];
		int i = p-1;
		for(int j = p; j<r; j++) {
			if (a[j]<=x) {
				i++;
				int d=a[i];
				a[i]=a[j];
				a[j]=d;
				
				
			}
		}
		int d = a[i+1];
		a[i+1] = a[r];
		a[r] = d;
		int q = i+1;
		return q;
		
	}
	
	//1b) variant of quicksort with insertort
	public static int[] quickinsort(int a[], int b, int c, int k) {
		
		if (b<c) {
			if (c-b+1>k) {
				int q = partition(a,b,c);
				quickinsort(a,b,q-1,k);
				quickinsort(a,q+1,c,k);
			}
			else {
				return a;
			}
		}
		insort(a);
		return a;
		
	}
	//1b) insort implementation
	public static void insort(int a[]){
		int n = a.length;
		for (int j = 1; j < n; j++){
			int key = a[j];
			int i = j-1;
			while ((i >= 0) && (a[i] > key)){
				a[i+1] = a[i];
				i--;
			}
			a[i+1] = key;
		}
	}
	
	//1c) quicksort implementation using median of 3 as pivot
	public static int[] sortMedian(int a[], int p, int r){
		if (p<r) {
			int q = median(a,p,r);
			sort(a,p,q-1);
			sort(a,q+1,r);
		}
		return a;
	}
	
	//1c) algorithm to choose the median of 3 points
	//provided 2 positions in the array, it finds the position in the midle and then chooses the median
	public static int median(int a[], int b, int c) {
		int mid = (c+b)/2;
		if (a[c]<a[b]) {
			int x = a[b];
			a[b]=a[c];
			a[c]=x;
		}
		else if (a[mid]<a[b]) {
			int x = a[b];
			a[b]=a[mid];
			a[mid]=x;
		}
		else if (a[c]<a[mid]) {
			int x = a[mid];
			a[mid]=a[c];
			a[c]=x;
		}
		
		return mid;
	}
	
	//1d)3-WAY-QUICK-SORT
	public static void ThreeWaySort(int a[], int p, int r) {
		System.out.println(Arrays.toString(a));
		if (p<r) {
			int left = ThreePartition(a,p,r)[0];
			int right = ThreePartition(a,p,r)[1];
			ThreeWaySort(a,p,left-1);
			ThreeWaySort(a,right+1,r);
		}
	}
	
	//1d) partition algorithm for 3-WAY-QUICK-SORT
	public static int[] ThreePartition(int a[], int p, int r) {
		int x = a[r];
		int t=r;
		int i = p-1;
		for(int j = p; j<t; j++) {
			if (a[j]<x) {
				i++;
				int d=a[i];
				a[i]=a[j];
				a[j]=d;				
			}
			else if (a[j]==x){
				t=t-1;
				int d=a[t];
				a[t]=a[j];
				a[j]=d;	
				j--;
			}
		}
		int eq = r-t+1;
		System.out.println(eq);
		for (int k=i+1; k<=i+((r-i)/2); k++) {
			int d = a[k];
			a[k] = a[r-k+i+1];
			a[r-k+i+1] = d;
		}
		int q[]= {i+1, i+eq};
		
		return q;

	}
}