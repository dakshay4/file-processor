Let’s say we have a website and we keep track of what pages customers are viewing, for things like business metrics.


Every time somebody comes to the website, we write a record to a log file consisting of Timestamp, PageId, CustomerId. At the end of the day we have a big log file with many entries in that format. And for every day we have a new file.Now, given two log files (log file from day 1 and log file from day 2) we want to generate a list of ‘loyal customers’ that meet the criteria of: (a) they came on both days, and (b) they visited at least two unique pages.

Timestamp	PageId	UserId
09Sep, 		1		1
09Sep		2		1

10Sept		1		1
10Sept		3		1



No.of lines in file = x + y

O(x+y)

users in file 1: n
users in file 2 : m
timestamp : 2

2*n + 2*m

O(x+y + 2n + 2m)

No .of UniquePages = p

O(n*2*p) = O(2pn)
