# Greedy Rod

A greedy algorithm make choices one at a time, without any consideration for past or future choices.
In the context of optimization problems, each choice is the most optimal one available. The key is that
this optimal choice is only optimal at a local level and does not guarantee that the choice is included
in the globally optimal solution.

In the context of this specific problem of rod value maximization, the choice to make is the length of
a piece to cut off from a rod. The process is repeated for the remainder of the rod until
there is no rod left.

Since this is maximization problem, the locally optimal choice is to choose the piece that has the
most per-unit price.

To facilitate the most efficient implementation, the input list of piece prices should be ordered in the
non-increasing order by per-unit price.

Beginning from the piece with the most per-unit value, the rod is cut off. The length of the cut-off rod
is subtracted from the total length of the rod. Each time, the most optimal piece available is chosen.
The algorithm finishes when there is no rod left.

The solution found by this algorithm does not guarantee the optimal solution.