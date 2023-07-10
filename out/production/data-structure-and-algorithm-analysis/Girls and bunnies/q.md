## 题目描述
Recently Satori opened a bunny store. Initially the store has no bunny at all. Yet at the ith
day of the next M
days, one of the following events will occur:

1. A girl with property Ai
   enters the store, intending to adopt a bunny.

- If there are bunnies available, she will adopt the jth
  bunny with the minimum value of |Ai−Bj|
  . If there are multiple bunnies with the same minimum |Ai−Bj|
  , she will choose the one whose Bj
  is the smallest.

- Otherwise, she will wait until one bunny chooses her.

2. A bunny with property Bi
   enters the store, willing to be adopted.

- If there are girls waiting to adopt, it will choose the jth
  girl with the minimum value of |Bi−Aj|
  as its owner. If there are multiple girls with the same minimum |Bi−Aj|
  , she will choose the one whose Aj
  is the smallest.

- Otherwise, it will stay at the store until one girl adopt her.

Each time when girl i
adopted a bunny j
successfully, Satori will earn |Ai−Bj|
coins.

Help Satori calculate the sum of coins she earns in total.

## 输入
The first line contains a single integer M(1≤M≤3×105)


The next M
lines each follows one of the two formats below:

-   1 Ai
    Indicating a girl with property Ai
    arrives (1≤Ai≤109)

-   0 Bi
    Indicating a bunny with property Bi
    arrives (1≤Bi≤109)


It is guaranteed that all integers in A
and B
are distinct.
## 输出
Output one single integer indicating the total money Satori earns.
## 样例输入
6
1 5
0 9
0 3
0 1
1 2
1 7
## 样例输出
9
## 提示
不要使用任何与堆和BST相关的STL！
