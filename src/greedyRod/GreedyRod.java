package greedyRod;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyRod {
    public static void main(String[] args) {
        int[] prices = { 1, 4, 8, 9, 15 };
        int maxValue = findMaxCombination(prices.length + 1, prices);
        System.out.println(maxValue);
    }

    static int findMaxCombination(int rodLength, int[] prices) {
        /* Iterate over the prices, creating an object that holds both piece length and price per unit */
        Piece[] pieces = new Piece[prices.length];
        for (int idx = 0; idx < prices.length; idx++) {
            pieces[idx] = new Piece(idx + 1, (double) prices[idx] / (idx + 1));
        }

        /* Order pieces in non-increasing order by per unit value */
        pieces = Arrays.stream(pieces)
                //TODO: Find out why piece becomes object when I invoke reversed method on the comparator
                .sorted(Comparator.comparingDouble(piece -> ((Piece) piece).pricePerUnit).reversed())
                .toArray(Piece[]::new);

        /* Print the ordered array of pieces (piece length, price per unit) */
        for (Piece piece : pieces) { System.out.print("(" + piece.length + ": " + piece.pricePerUnit + "), "); }
        System.out.println();

        int idx = 0;
        /* Keep track of the total value produced by pieces from the rod */
        int valueSum= 0;
        /* Keep track of the length of the remainder of the rod */
        int lengthLeft = rodLength;
        while (lengthLeft > 0) {
            /* Greedily choose the piece with the most per unit value that can be cut from the remainder of the rod */
            while (lengthLeft - pieces[idx].length < 0) idx++;
            /* Print the length of a greedily chosen piece */
            System.out.println("piece chosen: " + pieces[idx].length);
            /* Cut the piece from the rod */
            lengthLeft -= pieces[idx].length;
            /* Add the value of the piece to the sum */
            valueSum += prices[pieces[idx].length - 1];
        }

        return valueSum;
    }

    static class Piece {
        int length;
        double pricePerUnit;

        public Piece(int length, double pricePerUnit) {
            this.length = length;
            this.pricePerUnit = pricePerUnit;
        }
    }
}
