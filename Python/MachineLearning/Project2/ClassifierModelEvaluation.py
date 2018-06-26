# exercise 6.3.1

from matplotlib.pyplot import figure, boxplot, xlabel, ylabel, show, axes, xlim, title, savefig, subplots_adjust, grid
import numpy as np
from scipy.io import loadmat
import sklearn.linear_model as lm
from sklearn import cross_validation, tree
from scipy import stats

# Load Matlab data file and extract variables of interest
ANN_data = loadmat('error_rate_in_percent_for_ttest_ANN_classification.mat')
error_ANN = ANN_data['error_rate_in_percent_for_ttest_ANN_classification']

KNN_DT_data = loadmat('TLLB_FREDE_A_NEW_HOPE.mat')
InnerTestSizes = KNN_DT_data['InnerTestSizes']
E_ttest_KNN = (100.0*KNN_DT_data['E_ttest_KNN'])/InnerTestSizes.T
E_ttest_DT = (100.0*KNN_DT_data['E_ttest_DT'])/InnerTestSizes.T

Largest_data = loadmat('LargestClass.mat')
error_largest = (100.0*Largest_data['Error_ttest_mode'])/InnerTestSizes.T

errors = [error_ANN, E_ttest_KNN, E_ttest_DT, error_largest]
names =  ["ANN", "KNN", "DT", "LargestClass"]

# for i, error in enumerate(errors):
# 	print("Model: {0} has generalisation error {1:.2f}".format(names[i], error.sum()/error.shape[0]))

# exit(0)
alpha = 0.05
for index1 in range(len(errors)):
	for index2 in range(len(errors)):
		if index1 >= index2:
			continue

		print("\nTesting models {0} and {1}:".format(names[index1], names[index2]))
		# Test if classifiers are significantly different using methods in section 9.3.3
		# by computing credibility interval. Notice this can also be accomplished by computing the p-value using
		[tstatistic, pvalue] = stats.ttest_ind(errors[index1],errors[index2])
		print('p-value: {0:.2e}'.format(pvalue[0]))
		if(pvalue<alpha):
			print("Ttest: Classifiers ARE significantly different.")
		else:
			print("Ttest: Classifiers ARE NOT significantly different.")

		# and test if the p-value is less than alpha=0.05. 
		z = errors[index1] - errors[index2]
		zb = z.mean()
		nu = z.shape[0]-1
		sig = (z-zb).std()  / nu

		zL = zb + sig * stats.t.ppf(alpha/2, nu);
		zH = zb + sig * stats.t.ppf(1-alpha/2, nu);
		print('zL:{0:.2f} and zH:{1:.2f}'.format(zL,zH))
		if zL <= 0 and 0 <= zH :
		    print('CI: Classifiers ARE NOT significantly different')        
		else:
		    print('CI: Classifiers ARE significantly different.')
		    
		# Boxplot to compare classifier error distributions
figure(num=None, figsize=(6, 2))
subplots_adjust(left=0.1, bottom=0.2, right=0.95, top=0.9, wspace=0.2, hspace=0.3)
ax = axes()
boxplot(E_ttest_DT,positions = [1], widths = 0.5)
boxplot(E_ttest_KNN,positions = [3], widths = 0.5)
boxplot(error_ANN, positions = [5], widths = 0.5)
boxplot(error_largest,positions = [7], widths = 0.5)
xlim(0,8)
ax.set_xticklabels(['DT','KNN', 'ANN', 'LargestClass'])
ax.set_xticks([1, 3, 5, 7])

# title('Model errors')
ylabel('Cross-validation error [%]')


savefig('plots/ClassifierEvaluation.pdf')
# 
show()