import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt
from tensorflow.examples.tutorials.mnist import input_data
tf.reset_default_graph()
np.random.seed(20160704)
tf.set_random_seed(20160704)

# load data
mnist = input_data.read_data_sets("../MNIST/", one_hot=True)

# define first layer
num_filters1 = 32
x = tf.placeholder(tf.float32, [None, 784])
x_image = tf.reshape(x, [-1, 28, 28, 1])

W_conv1 = tf.Variable(tf.truncated_normal([5, 5, 1, num_filters1], stddev=0.1))
h_conv1 = tf.nn.conv2d(x_image, W_conv1, strides=[1, 1, 1, 1], padding="SAME")

b_conv1 = tf.Variable(tf.constant(0.1, shape=[num_filters1]))
h_conv1_cutoff = tf.nn.relu(h_conv1 + b_conv1)

h_pool1 = tf.nn.max_pool(h_conv1_cutoff, ksize=[1, 2, 2, 1], strides=[1, 2, 2, 1], padding="SAME")

# define second layer
num_filters2 = 64

W_conv2 = tf.Variable(tf.truncated_normal([5, 5, num_filters1, num_filters2], stddev=0.1))
h_cnov2 = tf.nn.conv2d(h_pool1, W_conv2, strides=[1, 1, 1, 1], padding="SAME")

b_conv2 = tf.Variable(tf.constant(0.1, shape=[num_filters2]))
h_cnov2_cutoff = tf.nn.relu(h_cnov2 + b_conv2)

h_pool2 = tf.nn.max_pool(h_cnov2_cutoff, ksize=[1, 2, 2, 1], strides=[1, 2, 2, 1], padding="SAME")

# define fully connected layer
h_pool2_flat = tf.reshape(h_pool2, [-1, 7*7*num_filters2])

num_units1 = 7*7*num_filters2
num_units2 = 1024

w2 = tf.Variable(tf.truncated_normal([num_units1, num_units2]))
hidden2 = tf.nn.relu(tf.matmul(h_pool2_flat, w2) + b2)

keep_prob = tf.placeholder(tf.float32)
hidden2_drop = tf.nn.dropout(hidden2, keep_prob)

w0 = tf.Variable(tf.zeros([num_units2, 10]))
b0 = tf.Variable(tf.zeros([10]))

k = tf.matmul(hidden2_drop, w0) + b0
p = tf.nn.softmax(k)

# define loss(cost) fucntion
t = tf.placeholder(tf.float32, [None, 10])
loss = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(k, t))