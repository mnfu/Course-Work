# Program Name: Lab6.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab6
# Due Date: 10/08/2023
# Purpose: Create a worker class for Lab 7 & 10
# Resources: Lecture Videos & docs.python.org

class Worker:
    def __init__(self):
        self.employee_number = 0
        self.office_number = 0
        self.name = ""
        self.birthdate = ""
        self.number_hours_worked = 0
        self.number_overtime_hours_worked = 0

    def get_employee_number(self):
        return self.employee_number

    def set_employee_number(self, x):
        self.employee_number = x

    def get_office_number(self):
        return self.office_number

    def set_office_number(self, x):
        if 100 <= x <= 500:
            self.office_number = x
            return True
        return False

    def get_name(self):
        return self.name

    def set_name(self, x):
        self.name = x

    def get_birthdate(self, m, d, y):
        self.birthdate = str(m) + str(d) + str(y)

    def set_birthdate(self, m, d, y):
        if (1 <= m <= 12) and (1 <= d <= 31):
            self.birthdate = str(m) + str(d) + str(y)
            return True
        return False

    def get_hours_worked(self):
        return self.number_hours_worked

    def add_hours(self, x):
        if x > 9:
            self.number_hours_worked += 9
            self.number_overtime_hours_worked += x-9
        else:
            self.number_hours_worked += x

    def get_hours_overtime(self):
        return self.number_overtime_hours_worked
