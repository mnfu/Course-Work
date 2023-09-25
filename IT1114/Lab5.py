# Program Name: Lab5.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab5
# Due Date: 10/03/2023
# Purpose: Calculate prime numbers in a range of numbers (including the range start & end)
# Resources: Lecture Videos & docs.python.org

def is_prime(number):
    if number > 0:  # makes sure number is non-negative
        for x in range(2, number):  # can start from 2 b/c we already know all numbers bigger than 0 are divisible by 1
            if (number % x) == 0:
                return False
        return True
    return False


# User Input
start_num = int(input("Starting Number: "))
end_num = int(input("Ending Number: "))

for num in range(start_num, end_num+1):  # add a one to the end number to make the range inclusive
    if is_prime(num):
        print(num)  # Output
