### 함수 Function
def hello(id) :
	print("Hello",id,"Function!!!")
hello("Python")

def hap(a, b) :
	print("합 : ", a+b)
hap(5,2)
hap(3,7)
hap(3.5,3.2)
# hap(3,5,2)
# hap(3)

## 지역변수
a = 100
b = 200
def disp(a) :			# 지역변수 우선권
	a += 20
	print("a : ", a)
	print("b : ", b)
disp(30)

## return
# C				함수		int add( int a, int b ) { return a+b }
# Java			메서드		public int add(int a, int b) { return a+b }
# JavaScript	Function	function add(a, b) { return a+b }
# Scala			Function	def add(a, b) : Int = { a+b }
# Python		Function	def add(a, b) :
#							return a, b, a+b

def add(a, b) :
	return a, b, a+b
x, y, result = add( 5, 2)
print(x,"+",y,"=",result)

def cha(a, b) :
	return a, b, a-b
result = cha(5,2)

# print( "차 : %d"%result)		# %d정수 / $f실수 / %c문자 / %s문자열
# print( "차 : %f"%result)
# print( "차 : %c"%result)
# print( "차 : %s"%result)

def gop(a, b=2) :
	return a*b
print(gop(5,3))
print(gop(1))

print("곱 : ", gop(b=10, a=5))

def va(*args) :		# 튜플
	for list_args in args :
		print(list_args)
va(1,2,3,4,5,6)
va("A","B","C")

def total(initial=5, *numbers, **keywords) :
	count = initial
	for number in numbers :
		count += number
	for key in keywords : 
		count += keywords[key]
	return count

print(total(10,1,2,3, vegetables=50, fluit=100))

# def div(a,b) :
# 	return a/b
# print(div(5.4,3))

div = lambda a, b : a/b
print(div(5,2))

print( (lambda a,b,c : a+b+c)(1,2,3) )

mm = ["one", lambda a : a*a, "third"]
print(mm[1](5))

