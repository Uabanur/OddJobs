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

KDEdensities 	= loadmat('data/KDEdensities.mat')['densities'].T.reshape(-1,)
KDEi 			= loadmat('data/KDEdensities.mat')['indexes'].T.reshape(-1,)
KNNdensities 	= loadmat('data/KNNdensities.mat')['densities'].T.reshape(-1,)
KNNi 			= loadmat('data/KNNdensities.mat')['indexes'].T.reshape(-1,)
ARDdensities 	= loadmat('data/ARDdensities.mat')['densities'].T.reshape(-1,)
ARDi 			= loadmat('data/ARDdensities.mat')['indexes'].T.reshape(-1,)
Z 				= loadmat('data/glass_data.mat')['PC']
N, M = Z.shape

#Accent, Accent_r, Blues, Blues_r, BrBG, BrBG_r, BuGn, BuGn_r, BuPu, BuPu_r, CMRmap, CMRmap_r, Dark2, Dark2_r, GnBu, GnBu_r, Greens, Greens_r, Greys, Greys_r, OrRd, OrRd_r, Oranges, Oranges_r, PRGn, PRGn_r, Paired, Paired_r, Pastel1, Pastel1_r, Pastel2, Pastel2_r, PiYG, PiYG_r, PuBu, PuBuGn, PuBuGn_r, PuBu_r, PuOr, PuOr_r, PuRd, PuRd_r, Purples, Purples_r, RdBu, RdBu_r, RdGy, RdGy_r, RdPu, RdPu_r, RdYlBu, RdYlBu_r, RdYlGn, RdYlGn_r, Reds, Reds_r, Set1, Set1_r, Set2, Set2_r, Set3, Set3_r, Spectral, Spectral_r, Vega10, Vega10_r, Vega20, Vega20_r, Vega20b, Vega20b_r, Vega20c, Vega20c_r, Wistia, Wistia_r, YlGn, YlGnBu, YlGnBu_r, YlGn_r, YlOrBr, YlOrBr_r, YlOrRd, YlOrRd_r, afmhot, afmhot_r, autumn, autumn_r, binary, binary_r, bone, bone_r, brg, brg_r, bwr, bwr_r, cool, cool_r, coolwarm, coolwarm_r, copper, copper_r, cubehelix, cubehelix_r, flag, flag_r, gist_earth, gist_earth_r, gist_gray, gist_gray_r, gist_heat, gist_heat_r, gist_ncar, gist_ncar_r, gist_rainbow, gist_rainbow_r, gist_stern, gist_stern_r, gist_yarg, gist_yarg_r, gnuplot, gnuplot2, gnuplot2_r, gnuplot_r, gray, gray_r, hot, hot_r, hsv, hsv_r, inferno, inferno_r, jet, jet_r, magma, magma_r, nipy_spectral, nipy_spectral_r, ocean, ocean_r, pink, pink_r, plasma, plasma_r, prism, prism_r, rainbow, rainbow_r, seismic, seismic_r, spectral, spectral_r, spring, spring_r, summer, summer_r, tab10, tab10_r, tab20, tab20_r, tab20b, tab20b_r, tab20c, tab20c_r, terrain, terrain_r, viridis, viridis_r, winter, winter_r

#Plot all observations and highlight the low density observations
g = sns.JointGrid(Z[:,0], Z[:,1], ratio=100)
g = g.plot_joint(sns.kdeplot, bw=0.211, cmap="gnuplot2", shade=True, shade_lowest=False)
g.ax_marg_x.set_axis_off()
g.ax_marg_y.set_axis_off()
g = g.plot_joint(plt.scatter, s=5)

linewidth = 1
alpha = 0.5
facecolors = 'none'
sizelimit = 15

for outlier in range(N):
	if((KNNdensities.max()/KNNdensities[outlier])**3/10 < sizelimit):
		break
	plt.scatter(Z[KNNi[outlier],0], Z[KNNi[outlier],1], s=(KNNdensities.max()/KNNdensities[outlier])**3/10, linewidth=linewidth, facecolors=facecolors, edgecolors='green', alpha=alpha)	

for outlier in range(N):
	if((ARDdensities.max()/ARDdensities[outlier])**3 < sizelimit):
		break
	plt.scatter(Z[ARDi[outlier],0], Z[ARDi[outlier],1], s=(ARDdensities.max()/ARDdensities[outlier])**3, linewidth=linewidth,facecolors=facecolors, edgecolors='yellow', alpha=alpha)

for outlier in range(N):
	if(100*np.log(KDEdensities[outlier])/np.log(KDEdensities[0]) < sizelimit):
		break
	plt.scatter(Z[KDEi[outlier],0], Z[KDEi[outlier],1], s=200*np.log(KDEdensities[outlier])/np.log(KDEdensities[0]), linewidth=linewidth,facecolors=facecolors, edgecolors='red', alpha=alpha)

g.ax_joint.collections[0].set_alpha(0)
fig = plt.gcf()
plt.xlabel("PC1")
plt.ylabel("PC2")
plt.ticklabel_format(style='sci', scilimits=(-2,2))
fig.set_figwidth(6)
fig.set_figheight(3)
fig.tight_layout()
plt.savefig('figures/2DdensityPC.pdf')


