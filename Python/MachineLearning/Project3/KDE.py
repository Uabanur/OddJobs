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

#Calculate optimal width for Gaussian kernel density estimation
widths = X.var(axis=0).max() * (2.0**np.arange(-10,10, 0.1))/100
logP = np.zeros(np.size(widths))
for i,w in enumerate(widths):
	print('Fold {:2d}, w={:.2f}'.format(i,w))
	density, log_density = gausKernelDensity(X,w)
	logP[i] = log_density.sum()
   
val = logP.max()
ind = logP.argmax()

fig=plt.figure(0, figsize=((4,2)))
plt.plot(widths, logP, '.', color='b')
plt.xticks(np.arange(min(widths), max(widths)+1, 1))
plt.xlabel('Kernel width')
plt.ylabel('LOO log likelihood')
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.tight_layout()
plt.savefig('figures/KDE_LOO.pdf')

width=widths[ind]
print('Optimal estimated width is: {0:.3}'.format(width))

#Calculate the density with the efficient algorithm 
density, log_density = gausKernelDensity(X,width)
i = (density.argsort(axis=0)).ravel()
density = density[i].reshape(-1,)

print('density min: {0:.2e} density max: {1:.2e}'.format(density.min(), density.max()))

#Plot densities for the observations
fig = plt.figure(1, figsize=((4,2)))
plt.bar(range(20),density[:20])
plt.title('KDE density: Outlier score')
plt.ticklabel_format(style='sci', scilimits=(-2,3))
fig.tight_layout()
plt.savefig('figures/KDE_densitybarplot_lowest20.pdf')

fig = plt.figure(2,  figsize=((4,2)))
sns.distplot(density, bins=20, kde=False, rug=True);
plt.title('KDE density: distribution')
plt.ticklabel_format(style='sci', scilimits=(-2,3))
fig.tight_layout()
plt.savefig('figures/KDE_densitydistribution.pdf')

# KDEdensities = {}
# KDEdensities['densities'] = density
# KDEdensities['indexes'] = i
# savemat('data/KDEdensities',KDEdensities)



#Plot all observations and highlight the low density observations
g = sns.JointGrid(Z[:,0], Z[:,1], ratio=100)
g = g.plot_joint(sns.kdeplot, bw=width, cmap="Blues", shade=True, shade_lowest=False)
g.ax_marg_x.set_axis_off()
g.ax_marg_y.set_axis_off()
g = g.plot_joint(plt.scatter, s=5)
for outlier in range(N):
	if(100*np.log(density[outlier])/np.log(density[0]) < 10):
		break
	plt.scatter(Z[i[outlier],0], Z[i[outlier],1], s=200*np.log(density[outlier])/np.log(density[0]), color='red', alpha=0.3)
g.ax_joint.collections[0].set_alpha(0)
fig = plt.gcf()
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.set_figwidth(6)
fig.set_figheight(3)
fig.tight_layout()
plt.savefig('figures/KDE_2DdensityPC.pdf')


