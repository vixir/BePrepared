package com.vixir.beprepared.recursion;

import java.util.ArrayList;

public class PrintGraySequence {

	ArrayList<Integer> aList = new ArrayList<Integer>();

	public ArrayList<Integer> grayCode(int a) {
		gray("", a);
		return aList;
	}

	public void yarg(String prefix, int n) {
		if (n == 0) {
			aList.add(Integer.parseInt(prefix, 2));
		} else {
			gray(prefix + "1", n - 1);
			yarg(prefix + "0", n - 1);
		}
	}

	public void gray(String prefix, int n) {
		if (n == 0) {
			aList.add(Integer.parseInt(prefix, 2));
		} else {
			gray(prefix + "0", n - 1);
			yarg(prefix + "1", n - 1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> sol = new ArrayList<Integer>();
		PrintGraySequence pG = new PrintGraySequence();
		sol = pG.grayCode(4);
		for(Integer s:sol){
			System.out.println(Integer.toBinaryString(s));
		}
	}

}
