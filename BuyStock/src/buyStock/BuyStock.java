package buyStock;

// LeetCode #121 (Best Time to Buy and Sell Stock).

// Given an array of positive integers representing a stock’s price on each day. 
// On each day you can only make one operation: either buy or sell one unit of stock and
// you can make at most 1 transaction. 
// Determine the maximum profit you can make.

// Assumption: The give array is not null and is length of at least 2

public class BuyStock {

	public int maxProfit(int[] array) {
		int max = 0, maxCur = 0;
		for (int i = 1; i < array.length; i++) {
			maxCur = Math.max(0, maxCur + array[i] - array[i - 1]);
			max = Math.max(max, maxCur);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public int maxProfit2(int[] array) {
		int min = Integer.MAX_VALUE, max = 0;
		for (int i = 0; i < array.length; i++) {
			min = Math.min(min, array[i]);
			max = Math.max(max, array[i] - min);
		}
		return max;
	}
	
	// Time complexity is O(n).
	// Space complexity is O(1).
}
