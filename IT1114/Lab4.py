# Program Name: Lab3.py
# Course: IT1114/Section W05
# Student Name: Rob
# Assignment Number: Lab3
# Due Date: 09/17/2023
# Purpose: Determine the cost of a resort vacation
# Resources: Lecture Videos & docs.python.org

def room_cost(num_nights, room_expense):
    return num_nights * room_expense


def meal_cost(num_brunches, num_dinners):
    return (num_brunches * 25 + num_dinners * 75) * 1.15


def excursion_cost(opt_picnic, opt_snorkeling, opt_guided_hike, opt_boat_dinner):
    return (opt_picnic * 50 +
            opt_snorkeling * 25 * num_of_people +
            opt_guided_hike * 17 * num_of_people +
            opt_boat_dinner * 200)


# User Inputs
num_of_nights = int(input("Number of nights: "))
num_of_people = int(input("Number of people: "))

# Rooms
print("Room Types:")
print("    (1) - Two Queen Beds")
print("    (2) - One King Bed")
print("    (3) - Queen Suite")
print("    (4) - King Suit")
room_type = int(input("Select Type: "))
room = 0
if room_type == 1:
    room = 375
elif room_type == 2:
    room = 350
elif room_type == 3:
    room = 525
elif room_type == 4:
    room = 475

# Food
brunches = int(input("How many Brunches: "))
dinners = int(input("How many Dinners: "))

# Excursions
picnic = 0
if str(input("Picnic?: ")) == "y":
    picnic = 1
snorkeling = 0
if str(input("Snorkeling?: ")) == "y":
    snorkeling = 1
guided_hike = 0
if str(input("Guided Hike?: ")) == "y":
    guided_hike = 1
boat_dinner = 0
if str(input("Boat Dinner?: ")) == "y":
    boat_dinner = 1

# Cost Calculations
room_price = room_cost(num_of_nights, room)
meal_price = meal_cost(brunches, dinners)
excursion_price = excursion_cost(picnic, snorkeling, guided_hike, boat_dinner)
total_cost = room_price + meal_price + excursion_price

# Output Statements
print("Room Cost: $" + str(room_price))
print("Meal Cost: $" + str(meal_price))
print("Excursion Cost: $" + str(excursion_price))
print("Total Cost: $" + str(total_cost))
