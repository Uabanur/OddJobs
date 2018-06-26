# exercise 2.1.1
import numpy as np
import csv
from scipy.linalg import svd
import matplotlib.pyplot as plt

count = 214

classes = ["Building float", "Building", "Vehicle float", "Vehicle", "Container", "Tableware", "Headlamp"]

# Preallocate memory, then extract excel data to matrix X
X = np.mat(np.empty((count, 11)))

# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		X[i, :] = np.array(row)


table = X[:,1:-1]
Xmean = table - np.ones((table.shape[0],1))*table.mean(0)

data = Xmean / np.std(table, axis=0)

U,S,V = svd(data,full_matrices=False)
# Project the centered data onto principal component space
Z = data * (V.T)

# Indices of the principal components to be plotted
i = 0
j = 1

C = len(set(np.array(X[:,-1]).T[0]))

rho = (S*S) / (S*S).sum() 

rhoakk = np.zeros((rho.shape[0],1))

sum = 0
for i,v in enumerate(rho):
	sum += v
	rhoakk[i] = sum


print(rhoakk[5])
exit(0)
plt.figure(figsize=(7,3))
plt.subplots_adjust(left=0.1, bottom=0.2, right=0.95, top=0.9)
plt.rc('axes', axisbelow=True)
plt.grid('on')
plt.plot(range(1,rhoakk.shape[0]+1), rhoakk, 'o', color='blue')

plt.axis((0.5,9.5,0,1.1))
plt.xlabel("Number of principal components")
plt.ylabel("Variance explained")

# Output result to screen
# plt.savefig("figures/RhoAkk.eps")

plt.show()




