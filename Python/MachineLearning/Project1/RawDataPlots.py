# exercise 2.1.1
import numpy as np
import csv
import matplotlib.pyplot as plt

count = 214

# Preallocate memory, then extract excel data to matrix X
X = np.mat(np.empty((count, 11)))

# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		X[i, :] = np.array(row)

# X = X / X.mean(0)

# for c in range(X.shape[1]-1):
# 	plot(X[:, 0], X[:, c+1], '.')
# 	xlabel('ID')
# 	ylabel('Attribute {0}'.format(c+1))


plt.figure(figsize=(7,3))
plt.subplots_adjust(left=0.1, bottom=0.2, right=0.95, top=0.9)
plt.rc('axes', axisbelow=True)
plt.grid('on')
plt.plot(X[:, 1], X[:, 7], '.')
plt.xlabel('RI')
plt.ylabel('Ca')
# Output result to screen
plt.savefig("figures/Correlated.eps")
plt.show()
