# Program Name: Lab8.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab8
# Due Date: 10/22/2023
# Purpose: Write a program to combine two integer arrays into one large array, remove duplicate values, & sort the final array
# Resources: Lecture Videos & docs.python.org
import random

# User Input
num = int(input("Enter an integer larger than 1: "))

a = [0] * num
b = [0] * num

# Fill both arrays with random numbers 0-500
for x in range(num):
    a.insert(x, random.randint(0, 500))
    b.insert(x, random.randint(0, 500))

# create an array with a set of values from both a & b to make sure there are no dupes
c = list(set(a+b))
c.sort()

# Program Output
for x in range(len(c)):
    print(c[x])
