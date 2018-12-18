# i = 0
# while i < 10 :
# 	i+=1
# 	print(i)
# else :
# 	print(i)

# i = 0
# sum_all = 0
# sum_even = 0
# sum_odd = 0

# while i < 100 :

# 	i+=1
# 	sum_all += i
# 	if i % 2 == 0 :
# 		sum_even += i
# 	else :
# 		sum_odd += i
# else : 
# 	print("전체합 : ", sum_all)
# 	print("짝수합 : ", sum_even)
# 	print("홀수합 : ", sum_odd)


# for i in range(10) :
# 	print(i)

# for i in range(1, 10) :
# 	print(i)

# for i in range(1, 10, 2) :
# 	print(i)

# 배열 반복
m = [1,2,3,4,5,6,7,8,9,10]
for i in m :
	print(i)
print(m[5])

# 딕셔너리
w = {"a":1,	"b":2, "c":3}
for key in w :
	print(key, " : ", w[key] )
print("b : ",w["b"])

# 튜플
y = [(1,"2", True),(3, 4.5, False),(5,"ABC", True)]
for (a, b, c) in y :
	print( a, " : ", b, " = ", c)

# 리스트 축약
la = [1, 2, 3, 4, 5, 6, 7, 8, 9, ]
lb = [i*2 for i in la]
lc = [i*2 for i in la if i > 5]

# enumerate
enum_str = ["이순신", "김유신", "홍길동"]
# for i in range(len(enum_str)) :
# 	print(i, " : ", enum_str[i])
for i in enumerate(enum_str, 100) :
	print(i)