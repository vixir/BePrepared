package com.vixir.beprepared;

public class KMPSubstringSearch {

	private int[] pattern(String s) {
		char[] cArray = s.toCharArray();
		int[] pattern = new int[cArray.length];
		int n = pattern.length;
		int i = 0;
		int j = 1;
		while (j < n) {
			if (cArray[i] == cArray[j]) {
				pattern[j++] = ++i;
			} else {
				if (i != 0) {
					i = pattern[i - 1];
				} else {
					pattern[j++] = 0;
				}
			}
		}
		return pattern;
	}

	public boolean KMP(String text, String pattern) {
		int lps[] = pattern(pattern);
		char[] patternArr = pattern.toCharArray();
		char[] textArr = text.toCharArray();
		int i = 0;
		int j = 0;
		while (i < textArr.length && j < patternArr.length) {
			if (textArr[i] == patternArr[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == patternArr.length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		KMPSubstringSearch substringSearch = new KMPSubstringSearch();
		String pattern = new String("aabcddcddaa");
		String text = new String("aabcddcddaaaaa");
		System.out.println(substringSearch.KMP(text, pattern));
		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
		System.out.println(substringSearch.KMP(str, subString));
	}

}
