# Dynamic Rod

### SRT BOT

- Subproblem: `R(s)`
- Relation: `R(s) = max{ R(j) + pieces[j] | 1 <= j <= s }` `s = l -> 1 <= j < s`
- Topological order: Decreasing
- Base case: `R(0) = 0`
- Original: `R(l)`
- Time T(l) = ?

### Explanation
The problem can be following the chain of smaller subprobems `R(s)` from the original problem `R(l)`.

Each subproblem can be framed as follows: given a rod of length `s`,
find the max value obtained by cutting it into pieces. *When `s = l`, a cut-off piece cannot be the whole rod.*

At each subproblem, one piece can be cut off from the given rod. The value of the cut-off rod is added to the
value sum. Remaining rod is an argument to the next subproblem.

For example, if given a rod of length 3, a piece of length 1, length 2, or length 3 can be cut off.
A rod of length 2, 1, and 0 will remain, accordingly.

If given a rod of length `s`, there are `s` ways to cut off one piece out of it. For each of the `s` choices,
the max value that can be obtained is the sum of the value of the cut-off piece and the max value that can
be obtained from the remaining rod.

Thus, each subproblem `R(s)` can be solved by trying all `s` choices and finding the max.
This is a brute force at a local level.

Because some subproblems of the original problem overlap with each other, solution of each subproblem should be
saved to avoid unnecessary computation.