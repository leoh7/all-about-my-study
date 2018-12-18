import pandas as pd
from pandas import DataFrame, Series
from sklearn import svm, metrics

xor_input = [
	[0, 0, 0],
	[0, 1, 1],
	[1, 0, 1],
	[1, 1, 0]
]
xor_df = pd.DataFrame(xor_input)
xor_data = xor_df.ix[:,0:1]		# [ [0,1], [0,1], [1,0], [1,1]]
xor_label = xor_df.ix[:,2]		# [0 ,1, 1, 0]

clf = svm.SVC()
clf.fit(xor_data, xor_label)
# pre = clf.predict(xor_data)

examdata = xor_df.ix[0:1, 0:1]
examlabel = xor_df.ix[0:1, 2]
pre = clf.predict(examdata)

ac_score = metrics.accuracy_score(examlabel, pre)
print("정답률 : ", ac_score)