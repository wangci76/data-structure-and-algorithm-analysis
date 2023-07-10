## 题目描述
We construct an array C
out of two given array A
and B
such that each element in array C
is the product of an element in A
and an element in B
. For example, we have A=[1,2,1]
and B=[5,2]
, then C=[5,2,10,4,5,2]


Now we only want to know the first K
smallest element of array C
.
## 输入
The first line contains three integers N
, M
and K
, denoting the length of array A
, the length of array B
and K
smallest respectively.(1≤N,M≤5×105),K≤Min(5×105,N×M)


The second line contains N
integers A1,A2,...AN(1≤Ai≤109)


The third line contains M
integers B1,B2,...BM(1≤Bi≤109)

## 输出
Output K
integers separated by spaces in ascending order, denoting the first K
smallest elements in C
.
## 样例输入
3 2 6
1 2 1
5 2
## 样例输出
2 2 4 5 5 10
## 提示
不要使用任何与堆和BST相关的STL
