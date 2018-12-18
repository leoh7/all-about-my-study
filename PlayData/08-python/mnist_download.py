# 다운로드
import urllib.request as req
import gzip, os, os.path
path = "./MNIST"
url = "http://yann.lecun.com/exdb/mnist"
files = [ "t10k-images-idx3-ubyte.gz", "t10k-labels-idx1-ubyte.gz",
          "train-images-idx3-ubyte.gz", "train-labels-idx1-ubyte.gz" ]

if not os.path.exists( path ) :
    os.mkdir( path )
for f in files :
    furl = url + "/" + f
    fpath = path + "/" + f
    print( "다운로드중 : " + furl )
    if not os.path.exists( fpath ) :
        req.urlretrieve( furl, fpath )
print( "다운로드 완료" )

# 압축해제
for f in files :
    gzfile = path + "/" + f
    savefile = path + "/" + f.replace(".gz", "")
    with gzip.open( gzfile, "rb" ) as fp :
        body = fp.read()
        with open(savefile, "wb") as w :
            w.write( body )
print( "압축해제 완료" )

import struct
def to_csv( name, maxdata ) :
    imagefile = open("./MNIST/" + name + "-images-idx3-ubyte", "rb" )
    labelfile = open("./MNIST/" + name + "-labels-idx1-ubyte", "rb" )
    csvfile = open("./MNIST/" + name + ".csv", "w", encoding="utf-8" )
    # 파일 헤더 정보 읽기
    mag, imagecount = struct.unpack( ">II", imagefile.read(8) )
    mag, labelcount = struct.unpack( ">II", labelfile.read(8) )
    rows, cols = struct.unpack( ">II", imagefile.read(8) )
    pixels = rows * cols
    # 이미지를 CSV로 저장
    for i in range( labelcount ) :
        if i > maxdata :
            break;
        label = struct.unpack( "B", labelfile.read(1))[0]
        data = imagefile.read( pixels )
        sdata = list( map( lambda n: str(n), data ) )
        csvfile.write( str(label) + "," )
        csvfile.write( ",".join(sdata) + "\r\n" )
    imagefile.close()
    labelfile.close()
    csvfile.close()
    
to_csv( "train", 4000 )             # "train-images-idx3-ubyte", "train-labels-idx1-ubyte"
to_csv( "t10k", 1000 )               # "t10k-images-idx3-ubyte", "t10k-labels-idx1-ubyte"
print( "CSV 변환  완료" )


def load_csv( csvfile ) :
	labels = []
	images = []
	with open( csvfile, "r" ) as f :
		for line in f :
			cols = line.split(",")
			if len(cols) < 2 :
				continue
			labels.append( int( cols.pop(0) ) )
			vals = list( map( lambda n : int(n)/256, cols ) )
			images.append(vals)
	return {"labels": labels, "images": images}

traindata = load_csv("./MNIST/train.csv")
validdata = load_csv("./MNIST/t10k.csv")
print("CSV load 완료")


# 학습
from sklearn import svm, metrics
clf = svm.SVC()
clf.fit(traindata["images"], traindata["labels"])
predict = clf.predict(validdata["images"])
score = metrics.accuracy_score(validdata["labels"], predict)
report = metrics.classification_report(validdata["labels"], predict)
print("정답률 : ", score)
print("리포트 : ", report)



# pandas
import pandas
traincsv = pandas.read_csv("./MNIST/train.csv", header=None)
tkcsv = pandas.read_csv("./MNIST/t10k.csv", header=None)

def change(n) :
	output = []
	for i in n :
		output.append(float(i) / 256)
	return output
train_data = list(map(change, traincsv.iloc[:, 1:].values))
train_label = traincsv[0].values
tk_data = list(map(change, tkcsv.iloc[:, 1:].values))
tk_label = tkcsv[0].values
clf = svm.SVC()
clf.fit(train_data, train_label)
predict = clf.predict(tk_data)
score = metrics.accuracy_score(tk_label, predict)
print("정답 : ", score)