package brutePizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BrutePizzaTest {

    @Test
    void inputOfLength4() {
        String[] toppings = { "a", "b", "c", "anchovies" };
        Integer index = BrutePizza.getIndex(toppings, "anchovies");
        String result = BrutePizza.getAllCombsInString(toppings, index);
        String[] combinations = result.split("\n");
        assertEquals(Math.pow(2, 4), combinations.length);
    }

    @Test
    void inputWithoutAnchovies() {
        String[] toppings = { "a", "b", "c", "e" };
        Integer index = BrutePizza.getIndex(toppings, "anchovies");
        String result = BrutePizza.getAllCombsInString(toppings, index);
        String[] combinations = result.split("\n");
        assertEquals(Math.pow(2, 4), combinations.length);
    }

    @Test
    void inputOfLength10() {
        String[] toppings = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        Integer index = BrutePizza.getIndex(toppings, "anchovies");
        String result = BrutePizza.getAllCombsInString(toppings, index);
        String[] combinations = result.split("\n");
        assertEquals(Math.pow(2, 10), combinations.length);
    }
}