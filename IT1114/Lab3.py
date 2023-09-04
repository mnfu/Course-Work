# Program Name: Lab3.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab3
# Due Date: 09/10/2023
# Purpose: To calculate manager bonuses & total sales for the month
# Resources: Lecture Videos & docs.python.org

# User Input
salesGoal = int(input("Sales goal: "))

# Default Values
sales = 0
salesPerson = 1

# User Input Loops
while True:
    for x in range(4):
        sales += int(input("Salesperson " + str(salesPerson) + " week " + str(x+1) + ": "))
    another = input("Another salesperson?: ")
    if another == "n":
        break
    salesPerson += 1

# Calculations
managerBonus = sales * 0.02
if sales > salesGoal:
    managerBonus = sales * 0.05

# Output print statements
print("Number of Employees: " + str(salesPerson))
print("Department Sales Goal: $" + str(salesGoal))
print("Total Sales: $" + str(sales))
print("Mgr. Bonus: $" + str(managerBonus))
