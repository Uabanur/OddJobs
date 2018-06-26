# exercise 6.3.1

from matplotlib.pyplot import figure, boxplot, xlabel, ylabel, show, axes, xlim, title, savefig, subplots_adjust
import numpy as np
from scipy.io import loadmat
import sklearn.linear_model as lm
from sklearn import cross_validation, tree
from scipy import stats

# Load Matlab data file and extract variables of interest
ANN_data = loadmat('error_for_ttest_ANN_regression_excluding_type_attributes.mat')
error_ANN = ANN_data['error_for_ttest_ANN_regression_excluding_type_attributes']

LR_data = loadmat('error_reg.mat')
error_LR = LR_data['error_reg']
error_mean = LR_data['error_mean']


errors = [error_ANN, error_LR, error_mean]
names =  ["ANN", "LR", "Mean"]
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
		print('zL:{0:.2e} and zH:{1:.2e}'.format(zL,zH))
		if zL <= 0 and 0 <= zH :
		    print('CI: Classifiers ARE NOT significantly different')        
		else:
		    print('CI: Classifiers ARE significantly different.')
		    
		# Boxplot to compare classifier error distributions
figure(num=None, figsize=(6, 2))
subplots_adjust(left=0.2, bottom=0.2, right=0.95, top=0.9, wspace=0.2, hspace=0.3)
ax = axes()
boxplot(error_ANN*10000,positions = [1], widths = 0.5)
boxplot(error_LR*10000,positions = [2], widths = 0.5)
boxplot(error_mean*10000,positions = [3], widths = 0.5)
xlim(0,4)
ax.set_xticklabels(['ANN', 'LR', 'Mean'])
# ax.set_xticklabels(['ANN', 'LR'])
ax.set_xticks([1, 2, 3])
# ax.set_xticks([1, 2])

# title('Model errors')
ylabel('Cross-validation\nerror', fontsize=14)

# savefig('plots/RegressionEvaluation.pdf')
savefig('plots/RegressionEvaluationWMEan.pdf')
# 
show()