import tensorflow as tf

a = tf.constant(10)
b = tf.constant(20)

# a = tf.constant(5)	# 값을 바꿀 때는 이렇게 바꾸는게 아니라
# a = tf.Variable(5)		# 이렇게 바꾸는 거라고? 초기화 필요

add = tf.add(a, b)
sub = tf.subtract(a, b)
mul = tf.multiply(a, b)
div = tf.divide(a, b)

sess = tf.Session()
add_result = sess.run(add)
sub_result = sess.run(sub)
mul_result = sess.run(mul)
div_result = sess.run(div)
print(add_result)
print(sub_result)
print(mul_result)
print(div_result)

