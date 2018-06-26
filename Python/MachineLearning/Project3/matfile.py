from scipy.io import savemat, loadmat
import numpy as np
import csv

count = 214
labels = ['RI', 'Na', 'Mg', 'Al', 'Si', 'K', 'Ca', 'Ba', 'Fe', 'Type']
table = np.mat(np.empty((count, 11)))

# Load xls sheet with data
with open('glass_data.csv') as csvfile:
	reader = csv.reader(csvfile)

	# Populate X
	for i, row in enumerate(reader):
		table[i, :] = np.array(row)

content = {}

content['table'] = table
content['labels'] = labels

savemat('glass_data', content)
