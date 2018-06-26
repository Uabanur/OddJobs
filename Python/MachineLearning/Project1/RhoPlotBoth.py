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

U,S,V = svd(Xmean,full_matrices=False)
U2,S2,V2 = svd(data, full_matrices=False)
# Project the centered data onto principal component space
Z = Xmean * (V.T)
Z2 = data *(V2.T)

# Indices of the principal components to be plotted
i = 0
j = 1

C = len(set(np.array(X[:,-1]).T[0]))

rho = (S*S) / (S*S).sum() 
rho2 = (S2*S2) / (S2*S2).sum() 

rhoakk = np.zeros((rho.shape[0],1))
rhoakk2 = np.zeros((rho.shape[0],1))

sum = 0
for i,v in enumerate(rho):
	sum += v
	rhoakk[i] = sum

sum = 0
for i,v in enumerate(rho2):
	sum += v
	rhoakk2[i] = sum

# print(rhoakk[1].sum())
# exit(0)
plt.figure(figsize=(7,3))
plt.subplots_adjust(left=0.1, bottom=0.2, right=0.95, top=0.9)
plt.rc('axes', axisbelow=True)
plt.grid('on')
plt.plot(range(1,rhoakk2.shape[0]+1), rhoakk2, 'o', color='green')
plt.plot(range(1,rhoakk.shape[0]+1), rhoakk, 'o', color='blue')

plt.axis((0.5,9.5,0,1.1))
plt.xlabel("Number of principal components")
plt.ylabel("Variance explained")
plt.legend(["std normed", "Not std normed"], loc=4)

# Output result to screen
plt.savefig("figures/RhoAkk.eps")

plt.show()




