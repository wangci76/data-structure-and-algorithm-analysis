## 题目描述
Given a N×N
 matrix A, whose element in the i
-th row and j
-th column A[i][j]
 is a number that equals i2+12345×i+j2−12345×j+i×j
.

Please find the M-th smallest element in the matrix.

## 输入
The 1st line is a positive integer T(1⩽ T ⩽ 10) which is the number of test case.

Then T
 lines follow. Each line has two integers N(1⩽ N ⩽ 50000) and M(1⩽ M ⩽ N×N) for a test case.

## 输出
Output T
 lines. Each line has an integer ans
, the M
-th smallest element in the matrix.
## 样例输入
2
1 1
2 1
## 样例输出
3
-12338
## 提示

The correspond solutions to the sample is :


(1) A[1][1]=12+12345×1+12−12345×1+1×1=3



(2) A[1][2]=12+12345×1+22−12345×2+1×2=−12338


    A[2][1]=22+12345×2+12−12345×1+2×1=12352


    A[2][2]=22+12345×2+22−12345×2+2×2=12


    So the smallest element is -12338