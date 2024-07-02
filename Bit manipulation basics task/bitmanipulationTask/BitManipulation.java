package com.bitmanipulationTask;

public class BitManipulation {

	private static int[] precomputedSetBits = new int[256];

	static {
		for (int i = 0; i < 256; i++) {
			precomputedSetBits[i] = Integer.bitCount(i);
		}
	}

	public static int countSetBits(int x) {
		return precomputedSetBits[x & 0xff] + precomputedSetBits[(x >> 8) & 0xff] + precomputedSetBits[(x >> 16) & 0xff]
				+ precomputedSetBits[(x >> 24) & 0xff];
	}

	public static int totalSetBits(int n) {
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total += countSetBits(i);
		}
		return total;
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println("Total set bits from 1 to " + n + ": " + totalSetBits(n));
	}
}
