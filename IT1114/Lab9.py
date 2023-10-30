# Program Name: Lab9.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab9
# Due Date: 11/05/2023
# Purpose: Write a program that will verify that a password has the required characters.
# Resources: Lecture Videos & docs.python.org


def password_checker(string):
    if (password_length(string) and password_upper(string) and password_lower(string)
            and password_number(string) and password_special_char(string)):
        return "Valid Password"
    return "Invalid Password"


def password_length(string):
    if len(password) >= 9:
        return True
    return False


def password_upper(string):
    for x in password:
        if x.isupper():
            return True
    return False


def password_lower(string):
    for x in password:
        if x.islower():
            return True
    return False


def password_number(string):
    for x in password:
        if x.isnumeric():
            return True
    return False


def password_special_char(string):
    for x in password:
        if x == "#" or x == "!" or x == "$" or x == "_":
            return True
    return False


password = input(str("Password: "))
print(password_checker(password))
