package com.uniqueElementsTask;

public class UniqueElements {

	public static int[] findUniqueElements(int[] nums) {
		int xor = 0;
		for (int num : nums) {
			xor ^= num;
		}

		int rightmostSetBit = xor & -xor;

		int unique1 = 0, unique2 = 0;
		for (int num : nums) {
			if ((num & rightmostSetBit) == 0) {
				unique1 ^= num;
			} else {
				unique2 ^= num;
			}
		}

		return new int[] { unique1, unique2 };
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		int[] result = findUniqueElements(nums);
		System.out.println("Unique elements are: " + result[0] + " and " + result[1]);
	}
}
