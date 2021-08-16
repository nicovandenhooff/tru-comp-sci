# python implementation of Assignment 4: Collections (Question 2)
# see the headers in the .Java files for details about the assignment

import random


class Box:
    """Represents a box that can contain objects"""

    def __init__(self):
        """Constructor, creates an empty box"""
        self.__box = []

    def add(self, element):
        """Adds the specified element to the box"""
        self.__box.append(element)

    def is_empty(self):
        """Checks if a box is empty"""
        return len(self.__box) == 0

    def draw_item(self):
        """Draws a random item from the box"""
        if self.is_empty():
            return None
        else:
            random_num = random.randint(0, len(self.__box)-1)

        temp = self.__box[random_num]
        self.__box.remove(temp)
        return temp

    def size(self):
        """Returns the size of a box"""
        return len(self.__box)

    def __str__(self):
        """Used to print the contents of a box"""
        description = ""

        if len(self.__box) == 0:
            description = "The box is currently empty"
            return description

        else:
            for element in self.__box:
                description += element.__str__() + "\n"
            return description


if __name__ == '__main__':
    # test driver

    # create a names and numbers box
    print("Creating a Box to hold names, and Box to hold numbers...")
    names = Box()
    numbers = Box()

    # add some names to the names box
    print()
    print("Adding some names to the names box...")
    names.add("Nico")
    names.add("John")
    names.add("Jayden")
    names.add("David")
    names.add("Rachel")

    # add some numbers to the number box
    print("Adding some numbers to the number box...")
    for i in range(1, 6):
        numbers.add(i)

    # test if the boxes are empty
    print()
    print("Testing if the boxes are empty...")
    print("The names box is empty: " + str(names.is_empty()))
    print("The numbers box is empty: " + str(numbers.is_empty()))

    # print the contents of the boxes
    print()
    print("Printing the contents of the boxes...")
    print("The names box contains: \n" + str(names))
    print("The numbers box contains: \n" + str(numbers))

    # decide who will sit at each seat and print
    print("Deciding who will sit at each seat...")
    for i in range(0, 5):
        print(str(names.draw_item()) + " will sit at seat " + str(numbers.draw_item()))

    # test if the boxes are empty
    print()
    print("Testing if the boxes are empty...")
    print("The names box is empty: " + str(names.is_empty()))
    print("The numbers box is empty: " + str(numbers.is_empty()))

    # print the contents of the boxes
    print()
    print("Printing the contents of the boxes...")
    print("The names box contains: \n" + str(names))
    print("The numbers box contains: \n" + str(numbers))

    # attempt to draw an item from the empty boxes
    print()
    print("Attemping to draw an item from the empty boxes...")
    print("Names box draw: " + str(names.draw_item()))
    print("Numbers box draw: " + str(numbers.draw_item()))
