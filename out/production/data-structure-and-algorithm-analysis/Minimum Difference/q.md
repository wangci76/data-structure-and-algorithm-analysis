## 题目描述
Given a sequence a with n items, the weights of each item are ai
. We define the minimum weight difference of ai
as hi=minj>i|aj−ai|
. Please compute the minimum weight difference of each item.

## 输入

The first line has a integer n (2≤n≤2×10^6).

The second line has n space-separated integers: a1,a2,…,an
all the elements of the array a (1≤ai≤109)
.




## 输出
Print space-separated integers:
h1,h2,…,hn−1.
## 样例输入
5
1 2 3 4 5
## 样例输出
1 1 1 1
## 提示

It can be solved in a simple and efficient way by using sorting algorithm and linked list elegantly, . Please note that the size of input might be really large, so you might want to use an efficient way to read the input data.
