# tensorFlow
import tensorflow as tf

a = tf.constant([5], dtype=tf.int32)
b = 10
c = tf.constant([2], dtype=tf.float32)
d = tf.constant([2], dtype=tf.float32)
result1 = a + b		# 결과값이 아니라 그래프(Tensor) 가 된다
result2 = c + d
sess = tf.Session()

value1 = sess.run(result1)
print(value1)

value2 = sess.run(result2)
print(value2)

# Python
# d = 5
# e = 2
# f = d + e
# pValue = sess.run(f)
# print(pValue) 	# 에러 / tensorFlow 는 자료형 개념이 완전히 바뀌었다는 걸 볼 수 있다.