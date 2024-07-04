package com.Day13and14Task;

public class TowerOfHanoi {

	public static void solveHanoi(int n, char source, char auxiliary, char destination) {
		if (n == 1) {
			System.out.println("Move disk 1 from " + source + " to " + destination);
			return;
		}
		solveHanoi(n - 1, source, destination, auxiliary);
		System.out.println("Move disk " + n + " from " + source + " to " + destination);
		solveHanoi(n - 1, auxiliary, source, destination);
	}

	public static void main(String[] args) {
		// Define the number of disks
		int numberOfDisks = 4;

		// Define the names of the pegs
		char sourcePeg = 'A';
		char auxiliaryPeg = 'B';
		char destinationPeg = 'C';

		// Print the initial message
		System.out.println("Solving Tower of Hanoi for " + numberOfDisks + " disks:");

		solveHanoi(numberOfDisks, sourcePeg, auxiliaryPeg, destinationPeg);
	}
}