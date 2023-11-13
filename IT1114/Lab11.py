# Program Name: Lab11.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab11
# Due Date: 11/19/2023
# Purpose: Create and edit a text file called users.txt
# Resources: Lecture Videos & docs.python.org


def create_file():
    try:
        file = open("users.txt", "x")  # create an empty file
        file.close()
    except FileExistsError:
        return


def add_user(user):
    try:
        file = open("users.txt", "a")
        file.write(user + "\n")  # append a user to the file, with a newline to keep going down
        file.close()
    except FileNotFoundError:
        print("Error finding file")


def update_user(old_user, new_user):
    try:
        file = open("users.txt", "r")
        lines = file.readlines()
        file.close()
        file = open("users.txt", "w")
        for line in lines:
            if line.strip() == old_user:  # if the line equals the old username, replace with new one (and a new /n)
                file.write(new_user + "\n")
            else:
                file.write(line)  # write the same line otherwise
        file.close()
    except FileNotFoundError:
        print("Error finding file")


def remove_user(user):
    try:
        file = open("users.txt", "r")
        lines = file.readlines()
        file.close()
        file = open("users.txt", "w")
        for line in lines:
            if line.strip() != user:  # if the line doesn't equal the user, write the same line, otherwise it gets cut
                file.write(line)
        file.close()
    except FileNotFoundError:
        print("Error finding file")
