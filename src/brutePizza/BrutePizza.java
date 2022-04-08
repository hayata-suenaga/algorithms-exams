package brutePizza;

public class BrutePizza {
    public static void main(String[] args) {

        String[] toppings = { "a", "b", "c", "d" };
        /* Find out at which index "anchovies" appears in the array of toppings */
        Integer index = getIndex(toppings, "anchovies");
        String result = getAllCombsInString(toppings, index);
        System.out.println(result);
    }

    static String getAllCombsInString(String[] toppings, Integer noPos) {
        int length = toppings.length;
        /* Get the base 10 representation of binary flags when all choices are selected */
        int max = Integer.parseInt("1".repeat(length), 2);

        String result = "";
        /* Try all combinations */
        for (int flags = 0; flags <= max; flags++) {
            /* String that holds the current combination */
            String combination = "Pizza: ";
            /* For noting if the combination includes the NO choice */
            boolean includesNo = false;

            /* For each choice, check if it should be included in the current combination */
            for (int pos = 0; pos < toppings.length; pos++) {
                if (checkBitFlag(flags, pos)) {
                    combination += toppings[pos] + " ";
                    /* If NO choice is included, note that */
                    if (noPos != null && pos == noPos) includesNo = true;
                }
            }

            /* If NO choice is included in the combination, append "NO" to the combination string */
            result += combination + (includesNo ? "NO\n" : "\n");
        }
        return result;
    }

    static Integer getIndex(String[] items, String target) {
        Integer index = null;
        for (int i = 0; i < items.length; i++) { if (items[i].equals(target)) { index = i; break; }}
        return index;
    }

    static boolean checkBitFlag(int flags, int flagPos) {
        /* Use mask to inspect a bit of a certain position */
        int mask = 1 << flagPos;
        return (flags & mask) > 0;
    }


}
