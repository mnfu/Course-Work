# Program Name: Lab12.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab12
# Due Date: 12/03/2023
# Purpose: Create a program that analyzes grades using the provided grades.txt file
# Resources: Lecture Videos & docs.python.org

def convert_grade(letter):  # Function to convert letter grades numerically
    if letter == 'A':
        return 100
    elif letter == 'B':
        return 89
    elif letter == 'C':
        return 79
    elif letter == 'D':
        return 74
    elif letter == 'F':
        return 69
    return 0


max_section = 0
lines = []

try:
    file = open("grades.txt", "r")
    lines = file.readlines()
    file.close()
except FileNotFoundError:
    print("Error finding file")

for line in lines:  # Determine the highest section number in file
    data = line.split()
    section = int(data[1])
    max_section = max(max_section, section)

total_section_grades = [0] * max_section
total_section_assignments = [0] * max_section

for line in lines:  # Add data from file into total grades & assignment counter arrays
    data = line.split()
    total_section_assignments[int(data[1]) - 1] += 1
    total_section_grades[int(data[1]) - 1] += convert_grade(data[2])

for grades in total_section_grades:
    i = total_section_grades.index(grades)
    average = grades / total_section_assignments[i]
    print("Section "
          + str(i + 1)
          + " average: "
          + str(average))
