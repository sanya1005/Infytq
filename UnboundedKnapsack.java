class Knapsack {
	static int max(int a, int b) { return (a > b) ? a : b; }
	static int unboundedKnapsack(int W, int wt[], int val[],
								int idx)
	{
		if (idx == 0) {
			return (W / wt[0]) * val[0];
		}
		int notTake
			= 0 + unboundedKnapsack(W, wt, val, idx - 1);
		int take = Integer.MIN_VALUE;
		if (wt[idx] <= W) {
			take = val[idx]
				+ unboundedKnapsack(W - wt[idx], wt, val,
									idx);
		}
		return max(take, notTake);
	}
	public static void main(String args[])
	{
		int W = 100;
		int val[] = { 10, 30, 20 };
		int wt[] = { 5, 10, 15 };
		int n = val.length;
		System.out.println(
			unboundedKnapsack(W, wt, val, n - 1));
	}
}
