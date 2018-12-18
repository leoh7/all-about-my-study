import matplotlib.pyplot as plt
import numpy as np
import tensorflow as tf

# 자료 로드
data_file_name = 'x_square.txt'
xy = np.genfromtxt(data_file_name, dtype='float32')

# x값과 y값을 불러와 임시로 저장
temp_x = xy[:, 0]
temp_y = xy[:, 1]

# reshape data
x_data = np.reshape(temp_x, [1, -1])	# 행은 1개 열은 여러 개
y_data = np.reshape(temp_y, [1, -1])	# 행은 1개 열은 여러 개
	# 텐서는 기본적으로 행렬연산
	# 다중퍼셉트론으로 만들기 위해서는 2차원 이상의 매트릭스 연산이 가능한 형태로 변환
	# 은닉 계층이 10개의 뉴런으로 구성

# 입력층 설계
x = tf.placeholder(dtype=tf.float32, shape=[1, None])
y = tf.placeholder(dtype=tf.float32, shape=[1, None])

# 은닉층 설계
number_of_hidden = 10
a_hidden = tf.Variable(tf.random_normal([number_of_hidden, 1]))	# 가중치
b_hidden = tf.Variable(tf.random_normal([number_of_hidden, 1]))	# 편차
	# matrix 연산을 고려하여 (10, 1) 구조를 갖는다.
	# 가중치 x의 매트릭스 곱은 (10, 1) x (1, n) 이 되고 결과는 (10, n)이 된다
hidden_layer1 = tf.nn.sigmoid(tf.matmul(a_hidden, x) + b_hidden)
	# sigmoid 함수를 이용해서 0과 1사이의 값을 갖도록 한다.

# 은닉층 추가
a_middle = tf.Variable(tf.random_normal([number_of_hidden, number_of_hidden]))
b_middle = tf.Variable(tf.random_normal([number_of_hidden, 1]))
hidden_layer2 = tf.nn.sigmoid(tf.matmul(a_middle, hidden_layer1) + b_middle)

# 출력층 설계
a_out = tf.Variable(tf.random_normal([1, number_of_hidden]))
	# 가중치 (1, 10)의 구조 layer1_out이 (10, n)의 구조이므로 (1, 10) x (10, n) 행렬곱은 (1, n)이 된다.
	# 입력값과 동일하다
b_out = tf.Variable(tf.random_normal([1, 1]))	# 편차
y_out = tf.matmul(a_out, hidden_layer2) + b_out

# 비용 계산
cost = tf.nn.l2_loss(y_out-y)

# optimizer 설정
optimizer = tf.train.AdamOptimizer(0.1)
do_train = optimizer.minimize(cost)
init = tf.global_variables_initializer()

with tf.Session() as sess :
	sess.run(init)
	for i in range(1000) :
		sess.run(do_train, feed_dict={x: x_data, y: y_data})

	# 학습
	x_temp = np.linspace(0, 20, 50)
	x_test = [x_temp]
	y_test = sess.run(y_out, feed_dict={x: x_test})

plt.plot(x_data, y_data, 'ro', alpha=0.05)
plt.plot(x_test, y_test, 'b^', alpha=1)
plt.show()
