## 题目描述
Dateri has a magic sequence and LowbieH is interested in it. Dateri promises that if LowbieH can answer his question, then he will play fencing with LowbieH. We denote the magic sequence by {an}
and Dateri will choose a lucky number k
. He asks LowbieH to find length of the longest consecutive subsequence such that the absolute difference between any two number in the subsequence will not exceed k
. Can you help LowbieH?

## 输入
The first line contains two integers k(0≤k≤2∗109)
and n(1≤n≤3∗106)
.

The second line contains n
integers a1,⋯,an(1≤ai≤2∗109, 1≤i≤n)
.

## 输出
One line contains the answer, i.e. the length of the longest available consecutive subsequence.

## 样例输入
3 9
5 1 3 5 8 6 6 9 10
## 样例输出
4
## 提示

There are two available consecutive subsequences : {5,8,6,6}
and {8,6,6,9}
.
