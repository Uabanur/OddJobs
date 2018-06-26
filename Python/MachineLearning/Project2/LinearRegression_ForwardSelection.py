import matplotlib.pyplot as plt
from scipy.io import loadmat, savemat
import sklearn.linear_model as lm
from sklearn import cross_validation
from toolbox_02450 import feature_selector_lr, bmplot
import csv
import numpy as np

count = 214
# labels = ['RI', 'Na', 'Mg', 'Al', 'Si', 'K', 'Ca', 'Ba', 'Fe', 'Type']
labels = ['Na', 'Mg', 'Al', 'Si', 'K', 'Ca', 'Ba', 'Fe']
table = np.mat(np.empty((count, 11)))
addCombinations = False;
transformMean = True;
transformStd = True;
savefiles = True;
showPlot = True;

# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		table[i, :] = np.array(row)
csvfile.close()

# Transform data
if transformMean:
	table -= table.mean(axis=0)
if transformStd:
	table /= table.std(axis=0)


# X: All the glass contents 
X = table[:,2:-1]   

# y: the refractive index
y = table[:,1]

N, M = X.shape

if addCombinations:
	# Initialize combination data 
	combinations = np.zeros((N, M**2)) 
	labelcombinations = [None]*M**2

	for i in range(M):
		for j in range(M):
			combinations[:,i + j*M] = np.multiply(X[:,i], X[:,j]).reshape(1,-1)
			labelcombinations[i + j*M] = labels[i] + " | " + labels[j]


	# Add all combinations of attributes
	X = np.hstack((X,combinations))
	labels = np.hstack((labels,labelcombinations))

Error_nofeatures = np.square(y-y.mean()).sum()/y.shape[0]

selected_features, features_record, loss_record = feature_selector_lr(X, y, 10)

model = lm.LinearRegression(fit_intercept=True).fit(X[:,selected_features], y)

y_pred = model.predict(X[:,selected_features])

equation = "y = {0:.2e}".format(model.intercept_[0]);
	
for i in range(len(model.coef_[0])):
	if(model.coef_[0][i] < 0):
		equation += " - "
	else:
		equation += " + "
	equation += "{0:.2e} * {1}".format(abs(model.coef_[0][i]), labels[selected_features[i]])	

print("Final model:")
print(equation)	


# K = 10
# CV = cross_validation.KFold(X.shape[0],K,shuffle=True)
# Error_reg = np.empty((K,1))
# Error_mean = np.empty((K,1))

# k=0
# for train_index, test_index in CV:

#     X_test = X[test_index,:]
#     y_test = y[test_index]

#     # Fit and evaluate Decision Tree classifier
#     y_reg = model.predict(X_test[:,selected_features])

#     Error_reg[k] = np.square(y_reg-y_test).sum()
#     Error_mean[k] = np.square(y_test-y_test.mean()).sum()

#     k+=1

# a={}
# a['error_reg'] = Error_reg
# a['error_mean'] = Error_mean
# savemat('error_reg', a)


Rsquared = 1-loss_record/Error_nofeatures

if addCombinations:
	plt.figure(num=None, figsize=(4, 4))
else:
	plt.figure(num=None, figsize=(6, 3))

if addCombinations:
	plt.subplot(1,1,1)
else:
	plt.subplot(1,2,1)

if addCombinations:
	plt.subplots_adjust(left=0.15, bottom=0.3, right=0.9, top=0.85, wspace=0.01, hspace=0.3)
else:
	plt.subplots_adjust(left=0.1, bottom=0.3, right=0.9, top=0.90, wspace=0.00, hspace=0.3)

plt.plot(range(len(Rsquared)), Rsquared, '-o')

if addCombinations:
	plt.xticks(range(len(selected_features)+1), ["", "Ca","Si","Al","Ba","K | Si"])
	plt.xlabel('iteration (attribute added)', fontsize = 12)
else:
	plt.xticks(range(len(selected_features)+1))
	plt.xlabel('iteration')

plt.ylabel('R^2 (crossvalidation)', fontsize=12)    
plt.ylim(0, 1)
plt.grid('on')

if not addCombinations:
	plt.subplot(1,3,3)
	#Add the constant (no feature) evaluation to data
	bmplot(labels, range(features_record.shape[1]), -features_record)
	plt.clim(-1.5,0)
	plt.xlabel('Iteration')

filename = "reg"

if addCombinations:
	filename += "_allCombi"

filename += "_Trans"	

if transformMean:
	filename += "_Mean"

if transformStd:
	filename += "_Std"	

if not transformStd and not transformMean:
	filename += "_None"

if savefiles:
	plt.savefig('plots/'+filename+'.pdf')
	file = open('plots/'+filename+'.txt',"w")
	file.write(filename + "\n" + equation)
	file.write("\nFinal R^2: {}".format(Rsquared[-1]))
	file.close()

if showPlot:
	plt.show()
