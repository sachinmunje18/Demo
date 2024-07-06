package com.Day15and16Task;

public class KnapsackProblem {

	public static int knapsack(int W, int[] weights, int[] values) {
		int n = weights.length;
		int[][] dp = new int[n + 1][W + 1];

		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= W; w++) {
				if (weights[i - 1] <= w) {
					dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}

		return dp[n][W];
	}

	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int W = 50;

		int maxValue = knapsack(W, weights, values);
		System.out.println("Maximum value that can be achieved: " + maxValue);
	}
}
