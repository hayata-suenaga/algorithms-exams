# Brute Pizza

A brute force algorithm investigates all combinations of a given set. It can use a bit to represent
a binary choice on each item in the set. Each combination is represented in a sequence of bits.

To iterate over all combinations, arithmetic increment operation is performed on the bit representation. Starting from
0, the bit representation is incremented by 1 after each inspection. When all the bits are turned 1,
the iteration finishes.

To get a specific bit from the bit representation, a bit mask is used. Bit mask in this context is a sequence
of bits that are all 0 except the bit of interest. By performing `AND` bitwise operation between the bit
representation and the mask, all bits become 0 except the bit of interest. When the resulted bits are converted to
base 10 integer, the number is greater than 0 when the interested bit is 1 and 0 if it's 0.