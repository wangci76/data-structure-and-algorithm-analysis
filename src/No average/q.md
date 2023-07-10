## 题目描述
Given a sequence {a}
 with  n
 different numbers (n is even). Please permutate this sequence to form a circle, so that each element on this circle is not equal to the average of two neighbors.

More formally, find an permutation {b}
 of sequence {a}
, such that:

∀i∈{2,3,...,n−1},bi≠bi−1 +bi+12
b1≠b2+bn2
bn≠bn−1 + b12

There may be more than one answer, you just need to print one of them.

We guarantee that there is at least one solution for each test case.
## 输入
 The first line will be a integers n
 as we mentioned before.

 The second line will be n
 integers in sequence, a1,a2,...,an


 For all test cases, n
 is even and 3<=n<=106,0≤ai≤109

## 输出
The only line will be n
 integers, b1,b2,...,bn
## 样例输入
6
3 2 1 4 5 6
## 样例输出
1 2 4 3 5 6
## 提示
You may need this. Java FastIO template: https://paste.ubuntu.com/p/6ybMcVXvz5/