import pandas as pd
from sklearn import svm, metrics, model_selection
from sklearn.model_selection._split import train_test_split
from sklearn.model_selection._search import GridSearchCV
import random, re
csv = pd.read_csv("C:\\Users\\Playdata\\Documents\\GitHub\\Python\\iris.csv")
data = csv[["SepalLength","SepalWidth", "PetalLength", "PetalWidth"]]
label = csv[ "Name" ]

# clf = svm.SVC()
# clf.fit(data, label)
# result = clf.predict([[5.1, 3.0, 1.3, 0.2]])
# print(result)

train_data, test_data, train_label, test_label = train_test_split(data, label)
clf = svm.SVC()
clf.fit( train_data, train_label )
pre = clf.predict(test_data)
score = metrics.accuracy_score(pre, test_label)
print(score)

scores = model_selection.cross_val_score(clf, data, label, cv=5)
print("각각 정답률 : ", scores )
print("평균 정답률 : ", scores.mean())

params = [{"C":[1,10,100,1000], "kernel":["linear"]},
		{"C":[1,10,100,1000], "kernel":["rbf"], "gamma":[0.001, 0.0001]}]

clf = GridSearchCV(svm.SVC(), params, n_jobs=1)
clf.fit(train_data, train_label)
print("score : ", clf.best_score_)
print("params : ", clf.best_params_)
print("estimator : ", clf.best_estimator_)