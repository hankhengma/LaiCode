package allValidPermutationsOfParentheses;

import java.util.ArrayList;
import java.util.List;

// Given N pairs of parentheses “()”, return a list with all the valid permutations.

// Assumption: n > 0

public class AllValidPermutationsOfParentheses {

	public List<String> validParentheses(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0) {
			result.add("");
			return result;
		}
		StringBuilder sb = new StringBuilder();
		DFS(0, 0, 0, n, sb, result);
		return result;
	}

	private void DFS(int level, int left, int right, int n, StringBuilder sb, List<String> result) {
		if (level == 2 * n) {
			result.add(sb.toString());
			return;
		}
		if (left < n) {
			sb.append("(");
			DFS(level + 1, left + 1, right, n, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(")");
			DFS(level + 1, left, right + 1, n, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// Time complexity is O(2^(2*n)), although this is only an upper bound, and
	// is not tight, because some branches are cut off.
	// Space complexity is O(n), because of call-stack.

	public static void main(String[] args) {
		AllValidPermutationsOfParentheses allValidPermutationsOfParentheses = new AllValidPermutationsOfParentheses();
		System.out.println(allValidPermutationsOfParentheses.validParentheses(3).toString());
	}
}
