# exercise 2.1.1
import numpy as np
import csv
import matplotlib.pyplot as plt

count = 214
labels = ['RI', 'Na content', 'Mg content', 'Al content', 'Si content', 'K content', 'Ca content', 'Ba content', 'Fe content', 'Type']
# Preallocate memory, then extract excel data to matrix X
X = np.mat(np.empty((count, 11)))

# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		X[i, :] = np.array(row)

for c in range(X.shape[1]-1):
	plt.figure(figsize=(7,3))
	plt.subplots_adjust(left=0.1, bottom=0.2, right=0.98, top=0.9)
	plt.rc('axes', axisbelow=True)
	plt.grid('on')
	plt.title('Histogram of raw data')
	plt.hist(X[:, c+1], bins=20)
	plt.ylabel('Observations')
	plt.xlabel('{}'.format(labels[c]))
	# plt.savefig('figures/Histogram{}.eps'.format(c+1))
	

plt.show()