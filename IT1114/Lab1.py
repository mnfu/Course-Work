# Program Name: Lab1.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab1
# Due Date: 08/27/2023
# Purpose: To calculate amount & cost of flooring
# Resources: Lecture Videos & docs.python.org

# User Inputs
length = float(input("Room Length: "))
width = float(input("Room Width: "))
costpersqft = float(input("Cost per Sq. Foot: "))
# Calculations stored in variables for manipulation
sqft = length*width
flooring = sqft*costpersqft
tax = flooring*0.07
# Output print statements
print("Square feet: " + str(sqft))
print("Flooring: " + str(flooring))
print("Tax: " + str(tax))
print("Total: " + str(flooring+tax))
