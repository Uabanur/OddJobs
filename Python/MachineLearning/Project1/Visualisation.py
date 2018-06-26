# exercise 2.1.1
import numpy as np
import csv
from scipy.linalg import svd
import matplotlib.pyplot as plt

count = 214

classes = [ "Type1:\nBuilding windows float processed", 
		 	"Type2:\nBuilding windows non float processed", 
		 	"Type3:\nVehicle windows float processed", 
		 	"Type4:\nVehicle windows non float processed (none)", 
		 	"Type5:\nContainer", 
		 	"Type6:\nTableware", 
		 	"Type7:\nHeadlamp"]

colors = ['red', 'black', 'green', 'grey', 'blue', 'magenta', 'cyan']
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

C = list(set(np.array(X[:,-1]).T[0]))

# rho = (S*S) / (S*S).sum() 
# print(rho[0:2].sum())
fig = plt.figure(num=None, dpi=100, facecolor='w', edgecolor='k', figsize = (10,4))
ax = plt.subplot(111)

box = ax.get_position()
ax.set_position([box.x0, box.y0, box.width * 0.62, box.height])
plt.rc('axes', axisbelow=True)
plt.title('Glass data: PCA')
#Z = array(Z)
for c in C:
    # select indices belonging to class c:
    class_mask = X[:,-1].A.ravel()==c
    ax.plot(Z[class_mask,i], Z[class_mask,j], '.', color=colors[int(c-1)], label=classes[int(c-1)])

plt.xlabel('PC{0}'.format(i+1))
plt.ylabel('PC{0}'.format(j+1))
ax.legend(loc='center left', mode='expand', labelspacing=2, borderpad = 1, bbox_to_anchor=(1, 0.5), ncol=1, fancybox=True)

plt.subplots_adjust(left=0.06, right=0.67, top=0.93, bottom=0.12)
# Output result to screen
plt.grid('on')
# plt.savefig("figures/PCAStdNormed.eps")
plt.show()




