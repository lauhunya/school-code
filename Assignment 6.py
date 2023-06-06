# -*- coding: utf-8 -*-
"""
Created on Tue Dec 15 00:11:58 2020

@author: laure
"""

from pandas import DataFrame
import matplotlib.pyplot as plt
from sklearn import linear_model
import statsmodels.api as sm

Height_Weight = {'Height': [64,63,67,60,52,58,56,52,79,73,56,71],
                'Weight': [159, 155,157,125,103,122,101,82,228,199,195,110],
                }

df = DataFrame(Height_Weight,columns=['Height','Weight']) 

print (df)

plt.scatter(df['Height'], df['Weight'], color='red')
plt.title('Height and Weight', fontsize=14)
plt.xlabel('Height', fontsize=14)
plt.ylabel('Weight', fontsize=14)
plt.grid(True)
plt.show()

"""
X = df[['Height']] # here we have 2 variables for multiple regression. If you just want 
# to use one variable for simple linear regression, then use X = df['Interest_Rate'] for example.Alternatively, you may
#  add additional variables within the brackets
Y = df['Weight']

regr = linear_model.LinearRegression()
regr.fit(X, Y)

print('Intercept: \n', regr.intercept_)
print('Coefficients: \n', regr.coef_)


# prediction with sklearn
New_Interest_Rate = 2.75
New_Unemployment_Rate = 5.3
print ('Predicted Stock Index Price: \n', regr.predict([[New_Interest_Rate ,New_Unemployment_Rate]]))


# with statsmodels
X = sm.add_constant(X) # adding a constant

# Using ordinary least squares to fit the model and develop predictions
model = sm.OLS(Y, X).fit()
predictions = model.predict(X) 
 
print_model = model.summary()
print(print_model)
"""
