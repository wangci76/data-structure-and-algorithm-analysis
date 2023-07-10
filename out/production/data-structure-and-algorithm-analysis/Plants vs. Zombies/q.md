## 题目描述
You want your plants be more stronger to against the zombies. You have n
 plants, each plant has two attributes: height and strength. Crazy Dave has two kinds of fertilizer Fh
 and Fs
. Each bag of Fh
 can make one plant double its height, and each bag of Fs
 can make one plant's strength equals its height. Crazy Dave gives you p bags of Fh
 and q bags of Fs
. You want to maximize the sum of your plants' strength.

More formally, you are given n pair of integers <hi,si>
, which indicates the height and strength of the i-th plant. You can use at most p times Fh
 and at most q times Fs


If you give a Fh
 to the i-th plant, then hi=hi∗2
;

If you give a Fs
 to the i-th plant, then si=hi
.

You want to maximize the ∑si

## 输入
The first line of the input contains three integers n,p,q
.

For the next n
 lines, each line contains two integers hi,si
, indicates the height and strength of the i-th plant.

For all cases, 1≤n≤2∗105, 0≤p≤20, 0≤q≤2∗105, 1≤hi,si≤109
.
## 输出
Print one integer indicates the maximum of ∑si
.
## 样例输入
2 1 1
10 8
6 1
## 样例输出
21
## 提示