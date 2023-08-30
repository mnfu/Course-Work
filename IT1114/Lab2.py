# Program Name: Lab2.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab2
# Due Date: 09/03/2023
# Purpose: To calculate food costs for the KSU CCSE hackathon
# Resources: Lecture Videos & docs.python.org

# User Inputs
pizzas = int(input("Number of pizza orders "))
salads = int(input("Number of salad orders "))
# Calculations & Variables
# Checks to see if there is a partial pizza & rounds up to a full one
if pizzas % 4 > 0:
    pizzas = pizzas + (4 - pizzas % 4)

totalPizzas = int(pizzas/4)
pizzaCost = 15.99 * totalPizzas
saladCost = 7.99 * salads
totalCost = pizzaCost + saladCost
deliveryCharge = totalCost * 0.07
# Checks if delivery charge is under $20, and if so sets it to $20
if deliveryCharge < 20:
    deliveryCharge = 20.0
# If discount isn't applied, the calculated discount is zero once multiplied
pizzaDC = 0
saladDC = 0

if totalPizzas > 10:
    pizzaDC = 0.15
if salads > 10:
    saladDC = 0.15

discountedPizza = pizzaCost * pizzaDC
discountedSalad = saladCost * saladDC
totalDiscount = discountedPizza + discountedSalad
finalCost = totalCost + deliveryCharge - totalDiscount

# Output print statements
print("Pizzas ordered: " + str(totalPizzas))
print("Pizza cost $" + str(pizzaCost))
print("Salad cost $" + str(saladCost))
print("Total $" + str(totalCost))
print("Discount $" + str(totalDiscount))
print("Delivery fee $" + str(deliveryCharge))
print("Total amount due $" + str(finalCost))