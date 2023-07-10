## 题目描述
You are given a complete binary tree and each node has a distinct key value. Now you are asked to determine whether the tree is a heap or not. If it is a heap, you are to determine if it is a Max-heap or a Min-heap.
## 输入
The first line contains N(2≤N≤106)
, denoting the number of nodes in the tree.

The second line contains N
integers A1,A2...AN(1≤Ai≤109)
, denoting the key value of node i
. It is guaranteed that no two key values are the same.

To simplify the problem, the tree is constructed as follows:

-   The root of the tree is node 1


-   For each 2≤i≤N
    , There is an edge between i
    and ⌊i/2⌋

## 输出
If the tree is a Max-heap, print "Max"

If the tree is a Min-heap, print "Min"

If the tree is not a heap, print "Neither" (without quotes)
## 样例输入
7
55 6 12 4 2 5 8
## 样例输出
Max
## 提示
不要使用任何与堆和BST相关的STL！
