# exercise 2.1.1
import numpy as np
import csv
from matplotlib.pyplot import plot, title, xlabel, ylabel, show, legend, savefig, figure, hist, xticks

count = 214


# Preallocate memory, then extract excel data to matrix X
X = np.mat(np.empty((count, 11)))

# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		X[i, :] = np.array(row)

labels = ['RI', 'Na', 'Mg', 'Al', 'Si', 'K', 'Ca', 'Ba', 'Fe', 'Type']

for c in range(X.shape[1] - 1):
	fig = figure( figsize=(2,6))
	ax = fig.add_subplot(143)

	bp = ax.boxplot(X[:,c+1])
	xticks([])
	xlabel(labels[c])
	# savefig('figures/RawBoxPlot{}.eps'.format(c+1))

# show()

