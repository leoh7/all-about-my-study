import pandas as pd
import numpy as np

# df = pd.DataFrame(np.arange(10, 22).reshape(3, 4), 
# 	index=["a", "b", "c"], 
# 	columns=["A", "B", "C", "D"]
# )

# print(df.loc["a","A"])
# print(df.loc["b":,"A"])	# : 은 범위 지정
# print(df.loc["a", :])
# print(df.loc[["a","b"],["B", "D"]])

df2 = pd.DataFrame(np.arange(10, 26).reshape(4,4), columns=np.arange(1, 8, 2))
