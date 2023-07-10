## 题目描述
There a big hexagon, the side length is n, so there are 3n2+3n+1
points, and 9n2+3n
edges. Each point has a weight.

We define the weight of each edge as the multiplying result of the weight of two endpoints in it. Please find out the minimum cost to connect these 3n2+3n+1
points.



## 输入
The first line contains an integer n (1≤n≤200)
, indicating the edge length of the hexagon.

The next 2n+1
lines, line i contains 2n+1−|i−n−1|
integers w (1≤w≤106)
, indicating the weight of each node.

## 输出
Output the minimum cost in one line.


## 样例输入
1
2 2
2 1 2
2 2
## 样例输出
12
## 提示
