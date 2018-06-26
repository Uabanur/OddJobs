# exercise 2.1.1
import numpy as np
import csv
from matplotlib.pyplot import plot, title, xlabel, ylabel, show, legend, savefig, figure

count = 214

X = np.mat(np.empty((count, 11)))


with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		X[i, :] = np.array(row)


nomean = X - np.ones((X.shape[0],1))*X.mean(0)

for a1 in range(1, nomean.shape[1]-1):
	for a2 in range(1, nomean.shape[1]-1):
		ATT1 = np.array(nomean[:,a1].T)[0]
		ATT2 = np.array(nomean[:, a2].T)[0]
		cov = (1/(count-1))*(ATT1 * ATT2).sum()/(np.std(X, axis=0)[0,a1] * np.std(X, axis=0)[0,a2])
		if(cov>0.4 and a1 != a2):
			print('att {0} and {1} has cov = {2}'.format(a1, a2, cov))
	print()	

