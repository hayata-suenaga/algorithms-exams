
public class DynamicRod {
    public static void main(String[] args) {
        int[] prices = { 2, 3, 5 };
        int result = getMaxValue(4, prices);
        System.out.println(result);
    }

    static int getMaxValue(int rodLength, int[] prices) {
        /* Locally brute force over each piece length available (no piece of length == rodLength)
        Then, return the max value */
        int max = 0;
        int maxOfSub;
        int valueOfCurrentPiece;
        /* Memorize max value for each rod piece of different length */
        int[] memo = new int[rodLength - 1];
        for (int pieceLength = 1; pieceLength < rodLength; pieceLength++) {
            maxOfSub = subProblemSolver(rodLength - pieceLength, prices, memo);
            valueOfCurrentPiece = prices[pieceLength - 1];
            max = Math.max(maxOfSub + valueOfCurrentPiece, max);
        }
        return max;
    }

    static int subProblemSolver(int rodLength, int[] prices, int[] memo) {
        /* Base case: No remaining piece of rod */
        if (rodLength == 0) return 0;
        /* If max value has already been computed, return the memoized value */
        if (memo[rodLength - 1] != 0) return memo[rodLength - 1];

        /* Locally brute force over each piece length available (no piece of length == rodLength)
        Then, return the max value */
        int max = 0;
        int maxOfSub;
        int valueOfCurrentPiece;
        /* Memorize max value for each rod piece of different length, including the length of the current rod */
        for (int pieceLength = 1; pieceLength <= rodLength; pieceLength++) {
            maxOfSub = subProblemSolver(rodLength - pieceLength, prices, memo);
            valueOfCurrentPiece = prices[pieceLength - 1];
            max = Math.max(maxOfSub + valueOfCurrentPiece, max);
        }
        memo[rodLength - 1] = max;
        return max;
    }
}
