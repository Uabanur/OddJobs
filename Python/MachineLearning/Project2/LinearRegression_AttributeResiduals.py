import matplotlib.pyplot as plt
from scipy.io import loadmat
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



# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		table[i, :] = np.array(row)


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

	for j in range(M):
		for i in range(M):
			combinations[:,i + j*M] = np.multiply(X[:,i], X[:,j]).reshape(1,-1)
			labelcombinations[i + j*M] = labels[j] + " | " + labels[i]


	# Add all combinations of attributes
	X = np.hstack((X,combinations))
	labels = np.hstack((labels,labelcombinations))

Error_nofeatures = np.square(y-y.mean()).sum()/y.shape[0]

selected_features, features_record, loss_record = feature_selector_lr(X, y, 10)

model = lm.LinearRegression(fit_intercept=True).fit(X[:,selected_features], y)

equation = "y = ";
	
for i in range(len(model.coef_[0])):
	if(model.coef_[0][i] < 0):
		equation += " - "
	elif (i>0):
		equation += " + "

	equation += "{0:.2e} * {1}".format(abs(model.coef_[0][i]), labels[selected_features[i]])	

print("Final model:")
print(equation)	

Rsquared = 1-loss_record/Error_nofeatures


data = X[:,selected_features]

m = lm.LinearRegression(fit_intercept=True).fit(data, y)

y_est= m.predict(data)
residual=y-y_est

tabnr = len(selected_features)

plt.figure(0, figsize=(10, 2.5))
plt.title('Residual error vs. Attributes for features selected')
plt.subplots_adjust(left=0.1, bottom=0.25, right=0.95, top=0.95, wspace=0.2, hspace=0.3)
for i in range(0,data.shape[1]):
	plt.subplot(1,tabnr,i+1)
	plt.plot(data[:,i],residual,'.')
	plt.xlabel(labels[selected_features[i]], fontsize = 15)
	plt.grid(True)
	# plt.ylabel('residual error')


plt.text(-37, 0.6, 'Residual error', fontsize=15, rotation=90)



plt.savefig('reg_residuals.pdf')
# file = open(filename+'.txt',"w")
# file.write(filename + "\n" + equation)
# file.close()


plt.show()
