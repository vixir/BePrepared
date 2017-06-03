package com.vixir.beprepared.recursion;

public class ModularExponentiation {

	// calculate (x^n) % m
	// (x^n % m) = (x^(n/2)%M)x(x^(n/2)%M)%M if n is even
	//           = (x%m)*(mod(x,n-1,m))
	public static void main(String[] args) {
		System.out.println(Math.floorMod(-1, 20));
	}

	public static int mod(int x, int n, int m) {
		x = Math.abs(x);
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0) {
			int y = mod(x, n / 2, m);
			return (y * y) % m;
		} else {
			return (x % m) * (mod(x, n - 1, m)) % m;
		}
	}
}
