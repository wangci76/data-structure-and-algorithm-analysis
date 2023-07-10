## 题目描述
Given the order of a tree's pre-order traversal and post-order traversal, you are asked to find out how many distinct binary trees fit the given traversal orders.
## 输入
The first line contains one integer T
, which denotes the number of the test cases (1≤T≤10 000)
. The nodes of a binary tree are represented by capital letters, and no two distinct nodes are represented with the same letter.

In each case, the first line contains a string Spre
, denoting the access order of the pre-order traversal. The second line contains a string Spost
, denoting the access order of the post-order traversal (|Spre|,|Spost|≤26)
.
## 输出
Output the number of binary trees which meet the requirements.
## 样例输入
1
ABCD
DCBA
## 样例输出
8
## 提示
