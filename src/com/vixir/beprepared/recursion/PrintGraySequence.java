package com.vixir.beprepared.recursion;

import java.util.*;

public class PrintGraySequence {

    public ArrayList<Integer> grayCodeIterative(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> result = grayCodeIterative(n - 1);
        // constant bit
        int numToAdd = 1 << (n - 1);

        // iterate through existing gray sequence
        for (int i = result.size() - 1; i >= 0; i--) { //iterate from last to first
            result.add(numToAdd + result.get(i));
        }

        return result;
    }

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
        ArrayList<Integer> solRecursive = new ArrayList<Integer>();
        PrintGraySequence pG = new PrintGraySequence();
        solRecursive = pG.grayCode(4);
        sol = pG.grayCodeIterative(4);
        for (Integer s : sol) {
            System.out.println(Integer.toBinaryString(s));
        }
        for (Integer s : solRecursive) {
            System.out.println(Integer.toBinaryString(s));
        }
    }

}
