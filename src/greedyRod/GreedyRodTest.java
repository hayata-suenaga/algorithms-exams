package greedyRod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreedyRodTest {
    @Test
    void oneAndFive() {
        int[] prices = { 1, 4, 8, 9, 15 };
        int maxValue = GreedyRod.findMaxCombination(prices.length + 1, prices);
        assertEquals(16, maxValue);
    }

    @Test
    void onlyLengthOne() {
        int[] prices = { 3, 4, 8, 9, 14 };
        int maxValue = GreedyRod.findMaxCombination(prices.length + 1, prices);
        assertEquals(18, maxValue);
    }

    @Test
    void singlePiece () {
        int[] prices = { 3 };
        int maxValue = GreedyRod.findMaxCombination(prices.length + 1, prices);
        assertEquals(6, maxValue);
    }

    @Test
    void unreasonablePricing () {
        int[] prices = { 10, 9, 8, 7, 6 };
        int maxValue = GreedyRod.findMaxCombination(prices.length + 1, prices);
        assertEquals(60, maxValue);
    }
}