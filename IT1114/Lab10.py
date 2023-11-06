# Program Name: Lab10.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab10
# Due Date: 11/12/2023
# Purpose: Modify Lab 7
# Resources: Lecture Videos & docs.python.org

class Worker:
    def __init__(self):
        self.employee_number = 0
        self.office_number = 0
        self.name = ""
        self.birthdate = ""
        self.number_hours_worked = 0
        self.number_overtime_hours_worked = 0
        self.hourly_salary = 0
        self.overtime_hourly_salary = 0

    def get_employee_number(self):
        return self.employee_number

    def set_employee_number(self, x):
        if type(x) == int:
            self.employee_number = x
        else:
            raise Exception("Employee number must be an integer")

    def get_office_number(self):
        return self.office_number

    def set_office_number(self, x):
        if 100 <= x <= 500:
            self.office_number = x
        else:
            raise Exception("The office number given is less than 100 or greater than 500")

    def get_name(self):
        return self.name

    def set_name(self, x):
        if len(x) == 0:
            raise Exception("The name must be something")
        else:
            self.name = x.replace('_', '').replace('.', '').replace('-', '')

    def get_birthdate(self, m, d, y):
        self.birthdate = str(m) + str(d) + str(y)

    def set_birthdate(self, m, d, y):
        if m < 1 or m > 12:
            raise ValueError("Month can't be greater than 12 or less than 1")
        if d < 1 or d > 31:
            raise ValueError("Day can't be greater than 31 or less than 1")
        self.birthdate = str(m) + str(d) + str(y)

    def get_hours_worked(self):
        return self.number_hours_worked

    def add_hours(self, x):
        if x < 0:
            raise Exception("Hours cannot be less than 0")
        elif x > 9:
            self.number_hours_worked += 9
            self.number_overtime_hours_worked += x-9
        else:
            self.number_hours_worked += x

    def get_hours_overtime(self):
        return self.number_overtime_hours_worked

    def set_hourly_salary(self, x):
        if x >= 0:
            self.hourly_salary = x
            return True
        return False

    def set_overtime_salary(self, x):
        if x >= 0:
            self.overtime_hourly_salary = x
            return True
        return False

    def get_hourly_salary(self):
        return self.hourly_salary

    def get_overtime_salary(self):
        return self.overtime_hourly_salary

    def get_pay(self):
        return ((self.number_hours_worked*self.hourly_salary)
                + (self.number_overtime_hours_worked*self.overtime_hourly_salary))
