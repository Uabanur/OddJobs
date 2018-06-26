from scipy.io import loadmat, savemat
import matplotlib.pyplot as plt
import numpy as np
from toolbox_02450 import gausKernelDensity, clusterplot
from sklearn.neighbors import NearestNeighbors
from scipy.linalg import svd

import seaborn as sns
from scipy import stats, integrate
import pandas as pd
sns.set(color_codes=True)

matdata = loadmat('data/glass_data.mat')
labels = matdata['labels']
X = matdata['transformeddata']
Z = matdata['PC']

N, M = X.shape
densitySum = np.zeros((N,))
for K in range(3,N):
	print('KNN fold {}'.format(K))
	# K = 5

	# Find the k nearest neighbors
	knn = NearestNeighbors(n_neighbors=K).fit(X)
	D, i = knn.kneighbors(X)

	density = 1./(D.sum(axis=1)/K)
	densitySum += density


density = densitySum/(N-3)

print('density min: {0:.2e} density max: {1:.2e}'.format(density.min(), density.max()))
# Sort the scores
i = (density.argsort(axis=0)).ravel()
density = density[i].reshape(-1,)

# Plot k-neighbor estimate of outlier score (distances)
fig=plt.figure(1,  figsize=((4,2)))
plt.bar(range(20),density[:20])
plt.title('KNN density: Outlier score')
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/KNN_densitybarplot_lowest20.pdf')

fig=plt.figure(2,  figsize=((4,2)))
sns.distplot(density, bins=20, kde=False, rug=True);
plt.title('KNN density: distribution')
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/KNN_densitydistribution.pdf')

#Plot all observations and highlight the low density observations

# KNNdensities = {}
# KNNdensities['densities'] = density
# KNNdensities['indexes'] = i
# savemat('data/KNNdensities',KNNdensities)

fig=plt.figure(3, figsize=((6, 3)))
plt.plot(Z[:,0], Z[:,1], '.')
for outlier in range(N):
	plt.scatter(Z[i[outlier],0], Z[i[outlier],1], s=(density.max()/density[outlier])**3/10, color='red', alpha=0.3)

plt.xlabel('PC1')
plt.ylabel('PC2')
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/KNN_2DdensityPC.pdf')

