# exercise 2.1.1
import numpy as np
import csv
import matplotlib.pyplot as plt

count = 214
labels = ['RI', 'Na', 'Mg', 'Al', 'Si', 'K', 'Ca', 'Ba', 'Fe', 'Type']
# Preallocate memory, then extract excel data to matrix X
table = np.mat(np.empty((count, 11)))

# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		table[i, :] = np.array(row)

X = table[:, 1:-1]

NOA = X.shape[1]
cols = 3
rows = 3


f, axarr = plt.subplots(nrows=rows, ncols=cols, figsize=(10,4))
plt.subplots_adjust(left=0.03, bottom=0.08, right=0.97, top=0.99, wspace=0.01, hspace=0.3)
for c in range(NOA):
	pos = NOA - c - 1
	plot = axarr[int(pos/cols), int(pos%cols)]
	plot.hist(X[:, c], bins=20, label=labels[c])
	# plot.set_xticks([])
	plot.set_yticks([])
	title = plot.set_title(labels[c])
	title.set_y(0.7)
	title.set_x(0.9)

plt.savefig('figures/HistogramAll.eps')	
# plt.show()









