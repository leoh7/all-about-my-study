# HDFS 데이터를 Python 으로 가져와서 처리
import pandas as pd
from sklearn import svm, metrics, model_selection
from sklearn.model_selection._split import train_test_split
from hdfs import InsecureClient

client_hdfs = InsecureClient("http://master:50070")
with client_hdfs.read("/input/iris.csv", encoding="utf-8") as reader :
	csv = pd.read_csv(reader, index_col=0)		# DataFrame 이 리턴 -> ix 사용

# data = csv[["SepalLength","SepalWidth", "PetalLength", "PetalWidth"]]
data = csv.ix[:, 0:3]	# 행은 다 읽고, 열은 0번부터 3번까지만 # 붓꽃의 길이 4개를 읽은 것
# label = csv[:, 4] 이게 안됨(문자열)
label = csv[ "Name" ]	# 붓꽃의 종류(문자열)

train_data, test_data, train_label, test_label = train_test_split(data, label)
clf = svm.SVC()
clf.fit( train_data, train_label )
pre = clf.predict(test_data)
score = metrics.accuracy_score(pre, test_label)
print(score)
