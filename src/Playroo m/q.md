## 题目描述
LowbieH and Peggy are in the playroom to figure out an interesting problem. Given a string of matched parenthesis s
, the scoring rules are defined by:

1. If s=()
   , then score(s)=1
   .

2. If t
   is another string of matched parenthesis, then score(s+t)=score(s)+score(t)
   .

3. score((s))=score(s)∗2
   .

LowbieH and Peggy want to calculate the score of given string quickly, can you help them? Since the answer may be very large, you only need to tell them the score after mod 514329
.

## 输入
One line a string. It contains only parenthesis and is perfect matched. The length of input will not exceed 100000
.

## 输出
One line an integer, denoting the score (mod 514329
).

## 样例输入
((()())())
## 样例输出
10
## 提示
score(((()())()))=((1+1)∗2+1)∗2=10
