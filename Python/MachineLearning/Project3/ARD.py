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

# K = 5
densitySum = np.zeros((N,))
for K in range(3,N):
	print('KNN fold {}'.format(K))
	# K = 5

	# Find the k nearest neighbors
	knn = NearestNeighbors(n_neighbors=K).fit(X)
	D, i = knn.kneighbors(X)

	density = 1./(D.sum(axis=1)/K)
	avg_rel_density = density/(density[i[:,1:]].sum(axis=1)/K)
	densitySum += avg_rel_density

avg_rel_density = densitySum/(N-3)
print('density min: {0:.2e} density max: {1:.2e}'.format(densitySum.min(), densitySum.max()))
# Sort the scores
i = (avg_rel_density.argsort(axis=0)).ravel()
avg_rel_density = avg_rel_density[i].reshape(-1,)


# Plot k-neighbor estimate of outlier score (distances)
fig=plt.figure(1, figsize=((4, 2)))
plt.bar(range(20),avg_rel_density[:20])
plt.title('ARD density: Outlier score')
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/ARD_densitybarplot_lowest20.pdf')

fig=plt.figure(2, figsize=((4, 2)))
sns.distplot(avg_rel_density, bins=20, kde=False, rug=True);
plt.title('ARD density: distribution')
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/ARD_densitydistribution.pdf')

#Plot all observations and highlight the low density observations

# ARDdensities = {}
# ARDdensities['densities'] = avg_rel_density
# ARDdensities['indexes'] = i
# savemat('data/ARDdensities',ARDdensities)

fig=plt.figure(3, figsize=((6, 3)))
plt.plot(Z[:,0], Z[:,1], '.')
for outlier in range(N):
	plt.scatter(Z[i[outlier],0], Z[i[outlier],1], s=(avg_rel_density.max()/avg_rel_density[outlier])**3, color='red', alpha=0.3)

plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/ARD_2DdensityPC.pdf')

fig=plt.figure(4, figsize=((6, 3)))
plt.plot(Z[:,0], Z[:,1], '.')
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/2DdensityPC.pdf')
