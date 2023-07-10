## 题目描述
LowbieH is learning about matching brackets in the classroom. There are n brackets, and LowbieH want to know whether they are matched. The brackets will only contain {,},(,),[,]
. Here is the matching rules. For example, {({[}]})
is not matched, but [{{}}()]
is matched. Please write a program to check whether the given string is matched or not.

## 输入
The ﬁrst line will be an integer T(1≤T≤10)
, which is the number of test cases.

For each test case, the ﬁrst line will be an integer n(1≤n≤30000)
.

Then there is a line with n
brackets.

## 输出
For each test case, print YES if the test case is a matched case. Otherwise, print NO.

## 样例输入
7
1
(
2
()
2
{]
6
[(){}]
4
(])[
8
[[{{}}]]
6
[][{]]
## 样例输出
NO
YES
NO
YES
NO
YES
NO
## 提示
