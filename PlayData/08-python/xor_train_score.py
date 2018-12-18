from sklearn import svm, metrics
clf = svm.SVC()
datas = [ [0, 0], [1, 0], [0, 1], [1, 1] ]
labels = [ 0, 1, 1, 0 ]

exams = [ [0, 0], [1, 0] ]
exams_label = [ 0, 1 ]

clf.fit( datas, labels )
results = clf.predict( exams )
print( results )

score = metrics.accuracy_score( exams_label, results )
print( score )