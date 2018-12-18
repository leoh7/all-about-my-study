import tensorflow as tf

input_data = [1, 2, 3, 4, 5]
x = tf.placeholder(dtype=tf.float32)	# 입력값이 들어갈 플레이스홀더 정의
y = x * 2								# 그래프를 정의
sess = tf.Session()
result = sess.run(y, feed_dict={x:input_data})	# 피딩
print(type(result))
print(result)

print()
mat = [75, 23, 64, 73, 94]
eng = [36, 77, 85, 53, 91]
a = tf.placeholder(dtype=tf.float32)
b = tf.placeholder(dtype=tf.float32)
y = (a + b) / 2
sess = tf.Session()
result = sess.run(y, feed_dict={a:mat, b:eng})
print("평균 : ", result)		# [55.5 50.  74.5 63.  92.5]

print()
input_data = [1, 2, 3, 4, 5]
x = tf.placeholder(dtype=tf.float32)
W = tf.Variable([2], dtype=tf.float32)
y = W * x
sess = tf.Session()
init = tf.global_variables_initializer()
sess.run(init)
result = sess.run(y, feed_dict={x:input_data})
print(result)