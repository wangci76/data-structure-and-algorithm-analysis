## 题目描述
You're required to devise a data structure as follows:

-   It is a complete binary tree
-   The key of each node is larger than its children's (if it has any)

We call it Heap. Initially your heap is empty, then you are asked to insert N
distinct integers into the heap one by one.

When you insert a new element into the heap, you should:

-   Place it at the leftmost position of the complete binary tree
-   Swap it with its father if it is larger than the key of its father until it becomes the root of the heap or it is smaller than the key of its father

Now little HEAP wants to know the number of swapping times in each insertion.
## 输入
The first line contains a single integer N(1≤N≤3×105)


The second line contains N
integers A1,A2,...AN(1≤Ai≤109)
, denoting the integers you are going to insert in order. It is guaranteed that these integers are distinct.

## 输出
Output N
integers separated by spaces,  representing the number of swapping times in each insertion.
## 样例输入
7
5 4 8 6 2 12 55
## 样例输出
0 0 1 1 0 2 2
## 提示
不要使用任何与堆和BST相关的STL！
