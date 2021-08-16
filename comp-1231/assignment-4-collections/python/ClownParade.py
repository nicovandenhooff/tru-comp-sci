# python implementation of Assignment 4: Collections (Question 1)
# see the headers in the .Java files for details about the assignment

class Clown:
    """Represents a Clown, that is identified by it's name"""

    def __init__(self, name):
        """Constructor: Sets up a Clown object and sets the Clown's name"""
        self.__name = name

    def get_name(self):
        """Name accessor"""
        return self.__name

    def set_name(self, name):
        """Name mutator"""
        self.__name = name

    def __eq__(self, clown):
        """Compares one clown object to anoter, based on their names"""

        return self.__name.lower() == clown.__name.lower()

    def __str__(self):
        """Used to print a Clown object (returns the Clown's name)"""
        return self.__name


class Parade:
    """Represents a parade of Clowns"""

    def __init__(self):
        """Constructor: Sets up an empty parade"""
        self.parade__ = []

    def add(self, clown):
        """Adds a Clown to the end of the Parade"""
        self.parade__.append(clown)

    def remove(self):
        """Removes the Clown from the head of the parade"""
        if len(self.parade__) != 0:
            self.parade__.pop(0)

    def size(self):
        """Returns the size of the parade"""
        return len(self.parade__)

    def is_front(self, clown):
        """Determines if a Clown is at the front of the parade"""
        return self.parade__[0] == clown

    def __str__(self):
        """Returns a nicely formatted representation of the Clown's in the parade"""
        description = ("Number of Clowns in the Parade: " + str(len(self.parade__)) + "\n" +
                       "Names and Positions of Clowns in Parade: \n")

        for clown in self.parade__:
            description += "Position: " + str(self.parade__.index(clown)) + "\t"
            description += "Name: " + clown.get_name() + "\n"

        return description


if __name__ == '__main__':
    # test driver

    # create a parade
    print("Creating a new Parade...")
    my_parade = Parade()

    # create some clowns
    print("Creating some Clowns...")
    clown1 = Clown("Nico")
    clown2 = Clown("Dominic")
    clown3 = Clown("Lela")
    clown4 = Clown("Jax")
    clown5 = Clown("Sophie")
    clown6 = Clown("Katie")

    # add 4 clowns to the parade
    print("Adding some Clowns to the parade")
    my_parade.add(clown1)
    my_parade.add(clown2)
    my_parade.add(clown3)
    my_parade.add(clown4)

    # print the parade
    print("Printing the parade")
    print()
    print(my_parade)

    # check if these clowns are at the head of the parade
    print("Checking if these Clowns are at the front of the parade...")
    print("Nico is at the front of the parade: " + str(my_parade.is_front(clown1)))
    print("Lela is at the front of the parade: " + str(my_parade.is_front(clown3)))

    # get the size of the parade
    print("Getting the size of the parade...")
    print("The current size of the parade is: " + str(my_parade.size))
    print()

    # remove some clowns from the parade
    print("Removing the first two Clowns from the Parade...")
    my_parade.remove()
    my_parade.remove()

    # reprint the parade
    print("Reprinting the parade")
    print()
    print(my_parade)

    # add some more clowns to the parade
    print("Adding some more Clowns to the Parade...")
    my_parade.add(clown5)
    my_parade.add(clown6)

    # reprint the parade
    print("Reprinting the parade")
    print()
    print(my_parade)

    # test Clown methods
    print("Testing methods of Clown class now...")
    print("Changing the names some Clowns")

    # reset a few clowns names
    clown5.set_name("Bill")
    clown6.set_name("Jack")

    # test equality of clowns names
    print()
    print("Testing to see if Clowns names are equal")
    print("clown5 name is " + str(clown5))
    print("clown6 name is " + str(clown6))
    print("Names are equal: " + str(clown5 == clown6))
