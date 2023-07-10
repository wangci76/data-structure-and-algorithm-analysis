## 题目描述
Given n cities and m roads. Sinzo wants to build these m roads one by one to guarantee all cities are connected, i.e., each city can reach all other cities. Sinzo wants to know how much roads after she built that all the n cities are connected.

## 输入
The first line contains 2 integers, n, m (1≤n,m≤105)
, indicating there are n cities and m roads to build.

The next m lines, each line contains 2 integers u, v (1≤u,v≤n)
, indicating Sinzo wants to build a unidirectional road from u to v.

Note that: these m roads are built in order.

## 输出
Please output the minimum roads to build. If Sinzo build all m roads, the n cities are not connected, then output -1.
## 样例输入
4 5
1 2
2 3
3 4
1 3
4 1
## 样例输出
5
## 提示
