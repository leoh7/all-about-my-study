### 상속
class Animal :
	def __init__(self, age) :
		self.age = age
	def getAge(self) :
		return self.age

class Pet :
	def __init__(self, name) :
		self.name = name
	def getName(self) :
		return self.name

class Dog :
	def __init__(self, sound) :
		self.sound = sound
	def getSound(self) :
		return self.sound

class Cat :
	def __init__(self, sound) :
		self.sound = sound
	def getSound(self) :
		return self.sound

class Pig :
	def __init__(self, sound) :
		self.sound = sound
	def getSound(self) :
		return self.sound

lucky = Dog("왕왕")
navi = Cat("야옹")
pink = Pig("꿀꿀")

print(lucky.getSound())
print(navi.getSound())
print(pink.getSound())