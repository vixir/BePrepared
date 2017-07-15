package com.vixir.beprepared.recursion.backtracking;

public class NQueens {

	public static boolean isConsistent(int[] a, int n){
		for(int i=0;i<n;i++) 	{
			if((a[i]-a[n]) == 0) return false;
			if((a[n]-a[i]) == (i-n)) return false;
			if((a[i]-a[n]) == (i-n)) return false;
			
	}
		return true;
	} 
	public static void printBoard(int[] a){
		System.out.println("Take this one : ");
		int n = a.length;
		for(int i=0;i<n;i++)	{
			for(int j =0;j<n;j++)	{
				if(a[i]==j) System.out.print("Q ");
				else System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void enumerate(int n){
		int [] a = new int [n];
		enumerate(a,0);
	}
	
	private static void enumerate(int [] a,int n){
		int N = a.length;
		if(n == N) printBoard(a);
		else{for(int i = 0; i < N; i++)	{
			a[n] = i;
			if(isConsistent(a,n))
				enumerate(a,n+1);
		}
	}
		}
	
	public static void main(String[] args){
		enumerate(8);
}
}