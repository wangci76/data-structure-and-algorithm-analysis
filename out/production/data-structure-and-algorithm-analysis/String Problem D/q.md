## 题目描述
Given two strings S,T
, you are required to judge if you can obtain one of the two strings by rotating the other one
## 输入
Two lines, indicating two strings S,T  (1≤|S|,|T|≤106)

## 输出
One line, "Yes" (with out quotes) if you can obtain one of the two strings by rotating the other one, "No" (with out quotes) otherwise.
## 样例输入
abcde
cdeab
## 样例输出
Yes
## 提示

abcde
and cdeab
-> Yes


abcde
and edcba
-> No


abcdeabcde
and abcde
-> No


Example of rotating a string:


abcde
-> bcdea
-> cdeab
-> deabc
-> eabcd
-> abcde
