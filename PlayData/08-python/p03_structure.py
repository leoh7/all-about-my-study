### 자료구조
# 열거형 [배열, 리스트, 튜플, 문자열, 딕셔너리]

# 배열..?
m = ["apple", "banana", "orange", "mango", "melon"]
# for i in m :
# 	print (i)
# print( m[0] )
# print( m[-1])
# for i in range(-1, -5, -1) :
# 	print( m[i] )

# print( "m[0:2]",m[0:2] )
# print( "m[2:]",m[2:] )
# print( "m[2:len(m)]",m[2:len(m)] )
# print( "m[2:-1]",m[2:-1] )
# print( "m[-1:-3]",m[-1:-3] )
# print( "m[:-3]",m[:-3] )
# print( "m[:-1]",m[:-1] )
# print( m[-4:-1] )
# print( m[2:].pop() )

# 얘네가 들어가면 아래 배열찍기가 안된다?
# m.append(10)
m.insert(2,"insert")
# 문자열
for i in range( len(m) ) :
	for j in range( len(m[i]) ) :
		print( m[i][j] )


msg = "hello python HAHA!!!"
msgs = "    ha    hha          h       "
msgss = "a,b,c,d,e,f,g"
digit = "a1b2c3d4"

print(msg.swapcase())
print(msg.title())
print(msg.capitalize())
print(msg.count("!"))
print(msg.find("o"))
print(msg.find("i"))
print(msg.index("o"))
# print(msg.index("i")) index()는 없는 것은 찾지 못한다
print(msg.join("###"))	# 사이에 끼워넣기

print(msgs.strip())

print(msgss.split(","))

print(digit.isalnum())
print(digit.isdecimal())
print(digit.isalpha())
print(digit.isdigit())


# 튜플
zoo = ("dog", "cat", "pig", "lion", "tiger")
print(len(zoo))
print(zoo)
print(zoo.index("dog"))
print(zoo[0])
print(zoo[3])
print(zoo[3][0],zoo[3][1],zoo[3][2],zoo[3][3])

alist = ['Alpha','Bravo','Chalie',"Delta"]
blist = ['Alpha','Bravo','Chalie',"Tango"]

print(alist)
print(len(alist))
alist.insert(0,"Swiss")
print(alist)
alist.sort()
print(alist)
print(alist.pop())
print(alist)
# for i in range( len(alist) ) :
# 	for j in range( len(alist[i]) ) :
# 		print( alist[i][j] )


# 사전 Dictionary
kim = {
	"name" : "김유신",
	"age" : 30,
	"tel" : "1111-2222",
	"address" : "서울시"
}
print(kim)
print(kim["name"])
print(len(kim))
print(kim.keys())
print(kim.values())
for value in kim.values() :
	print(value)
for key in kim.keys() :
	print(kim.get(key))

kim["age"] = 50
for (key, value) in kim.items() :
	print(key, " : ", value)


# 집합 Set
bg = set(["red", "blue", "green", "yello"])
fg = set(["pink", "magenta", "cyan", "black", "red"])
print(bg - fg)
print(bg.difference(fg))

print(bg & fg)
print(bg.intersection(fg))

print(bg | fg)
print(bg.union(fg))

print(bg.symmetric_difference(fg)) #대칭자 #교집합만 뺀 나머지
