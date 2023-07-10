## 题目描述
In DSAA, we define (A[i],A[j])
 in array A as a reverse pair iff A[i]>A[j]
 and i<j
.
Given two non-descending arrays A
 with size n
 and B
 with size m
.  
Please return (i) the number of reverse pairs in array C={A[1],A[2],...,A[n],B[1],B[2],...,B[m]}
;
and  (ii) the non-desending arrary C
.

If you do not have any idea, please refer to Page 22 (in lecture 3 slides) for inspiration.


## 输入
The first line contains an integer T(1 ≤ T ≤10), representing the number of test cases. 

In each test case:

The first line will be two integers n
 and m
, which are the lengths of the two non decreasing sequences.
The second line will be n
 integersA1,A2,...,An
The third line will be m
 integers B1,B2,...,Bm

For all cases, 1<=n,m<=105,0≤Ai,Bj≤109

## 输出
For each test case:

  The first line is the number of reverse pairs of {C}


  The second line is sequence {C}
: C1,C2,...,Cn+m

## 样例输入
2
2 4
2 3
1 2 3 4
2 2
3 4
1 2
## 样例输出
3
1 2 2 3 3 4 
4
1 2 3 4 
## 提示
You may need this. Java FastIO template: https://paste.ubuntu.com/p/6ybMcVXvz5/