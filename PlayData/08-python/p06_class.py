# 클래스
# class Person : 
# 	__name = "홍길동"
# 	age = 30
# 	def getName(self) :
# 		return self.__name
# 	def getAge(self) :
# 		return self.age

# hong = Person()
# # print(hong.__name)
# print(hong.getName())
# print(hong.age)

class Person : 
	def __init__(self, name="noname", age=0) :
		self.__name = name
		self.age = age
	def getName(self) :
		return self.__name
	def getAge(self) :
		return self.age
	def __del__(self) :
		print("소멸자")

hong = Person("홍길동", 30)
print(hong.getName())
print(hong.age)
hong.__del__()
# del hong
# del Person

kim = Person()
print(kim.getName())
print(kim.age)