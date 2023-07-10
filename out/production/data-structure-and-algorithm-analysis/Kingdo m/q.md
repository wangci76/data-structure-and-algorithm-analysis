## 题目描述
Long time ago, there was a handsome prince named Pisces, who ruled a powerful kingdom. In his kingdom, there were n
cities along with m
directed roads connecting them. To better govern his kingdom, Pisces had decided to draw an adjacent matrix to represent the circulation relationship among these cities. In his matrix, if there are aij
roads from city i
to city j
, we have A[i][j]=aij
. Please help him solve this problem.

## 输入
The first line contains an integer T
(1≤T≤10)
, which denotes the number of test cases.

In each test case, the first line contains 2
integers n
(2≤n≤1000)
and m
(1≤m≤2000)
, indicating the number of cities and the number of roads. And in each of the next m
lines, there are 2
integers u
and v
(1≤u,v≤n)
, representing that there is a directed road from city u
to city v
.

## 输出
For each test case, print the adjacent matrix.

## 样例输入
2
4 6
1 2
2 3
3 4
2 3
4 2
1 4
3 4
1 2
3 2
1 3
3 1
## 样例输出
0 1 0 1
0 0 2 0
0 0 0 1
0 1 0 0
0 1 1
0 0 0
1 1 0
## 提示
