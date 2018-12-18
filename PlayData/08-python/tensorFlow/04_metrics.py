import tensorflow as tf

x = tf.constant([1.0, 2.0, 3.0], dtype=tf.float32, shape=[1, 3])
y = tf.constant([2.0, 2.0, 2.0], shape=[3, 1])
w = tf.matmul(x, y)

print(x.get_shape())
print(y.get_shape())
print(w.get_shape())

sess = tf.Session()
result = sess.run(w)
print(result)

print()
a = tf.Variable([[1, 2],[3, 4]])
b = tf.Variable([[1, 2],[3, 4]])
add = tf.add(a, b)
sub = tf.subtract(a, b)
print(add.get_shape())
print(sub.get_shape())
sess = tf.Session()
init = tf.global_variables_initializer()
sess.run(init)
addresult = sess.run(add)
subresult = sess.run(sub)
print(type(addresult))
print(type(subresult))
print(addresult)
print(subresult)

print()
input_data = [[1.,2.,3,], [1.,2.,3,], [1.,2.,3,] ]	# 3X3 길이가 가변적이다.
ph = tf.placeholder(dtype=tf.float32, shape=[None, 3])
var_metrix = tf.Variable([[2.], [2.], [2.]])						# 3X1 
mul = tf.matmul(ph, var_metrix)
sess = tf.Session()
init = tf.global_variables_initializer()
sess.run(init)
print(sess.run(mul, feed_dict={ph:input_data}))

# Numpy 와 tensorFlow
import numpy as np

aa = [[1, 2], [3, 4]]
bb = [[5, 6], [7, 8]]
cc = (1, 2, 3, 4)
dd = (5, 6, 7, 8)
re1 = np.multiply(aa, bb)	# 곱셈
re2 = np.matmul(aa, bb)		# 행렬곱
re3 = np.multiply(cc, dd)
re4 = np.matmul(cc, dd)

print("re1 : ",re1)
print("re2 : ",re2)
print("re3 : ",re3)
print("re4 : ",re4)

pl1 = tf.placeholder(dtype=tf.int32, shape=[None, 2])
pl2 = tf.placeholder(dtype=tf.int32, shape=[None, 2])
mm = tf.matmul(pl1, pl2)
sess = tf.Session()
re5 = sess.run(mm, feed_dict={pl1:aa, pl2:bb})
print("re5의 타입 : ", type(re5))
print(re5)