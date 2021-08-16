# python implementation of Assignment 1: Inheritance
# see the headers in the .Java files for details about the assignment

from abc import ABC, abstractmethod


class Shape(ABC):
    """Represents a three-dimensional shape.  To be used as the parent of a derived class.  Contains abstract
    methods to calculate volume and surface area which are defined in detail in each child class.  Also
    contains non-abstract methods to access a shape's volume or surface area, as well as to print a nicely
    formatted string representation of a shape.
    """

    def __init__(self, shape_type):
        """Constructor: Sets up a Shape object with the specified Shape type

        volume          the volume of a shape
        surface area    the surface area of a shape
        shape_type      the type of shape (e.g. cube)
        """

        self._volume = 0
        self._surface_area = 0
        self._shape_type = shape_type

    @abstractmethod
    def calc_volume(self):
        """Calculates the volume of a Shape.  Explicitly defined in each child class since the calculation
           of volume depends on the type of Shape."""

    @abstractmethod
    def calc_surface_area(self):
        """Calculates the surface area of a Shape.  Explicitly defined in each child class since the
           calculation of surface area depends on the type of Shape."""

    def get_volume(self):
        """Volume accessor"""
        return self._volume

    def get_surface_area(self):
        """Surface area accessor"""
        return self._surface_area

    def __str__(self):
        """Returns a nicely formatted string representation of a Shape, including the type of Shape, it's
           volume, and it's surface area."""

        description = ("Shape Type: " + self._shape_type + "\n" +
                       "Volume: " + str(round(self._volume, 2)) + "\n" +
                       "Surface Area: " + str(round(self._surface_area, 2)))

        return description


class Cube(Shape):
    """Represents a cube.  A child class of the Shape class.  Includes methods to calculate the volume and surface
       area of a Cube, access or change the side length of a Cube, and includes a method to update the string
       representation inherited from the parent class to also include the side length of the Cube."""

    def __init__(self, side_length):
        """"Constructor: Sets up a Cube object.  Call's the parent's constructor and set's the type of
            Shape to "Cube".  Call's the Cube method's to calculate volume and surface area, and stores
            these in the volume and surface area variables inherited from the parent class.

            side_length     the length of a side of a cube
            volume          the volume of a shape
            surface area    the surface area of a shape
            """

        super().__init__("Cube")

        self._side_length = side_length
        self._volume = self.calc_volume()
        self._surface_area = self.calc_surface_area()

    def calc_volume(self):
        """Calculates the volume of a Cube.  Overrides abstract parent method."""

        volume = self._side_length ** 3
        return volume

    def calc_surface_area(self):
        """Calculates the surface area of a Cube.  Overrides abstract parent method."""

        surface_area = 6 * self._side_length ** 2
        return surface_area

    def get_side_length(self):
        """Side length accessor"""

        return self._side_length

    def set_side_length(self, side_length):
        """Side length mutator.  Recalculates volume and surface area"""

        self._side_length = side_length
        self._volume = self.calc_volume()
        self._surface_area = self._surface_area

    def __str__(self):
        """Overrides parents __str__ method to also include a nicely formatted string representation of the
           side length of a Cube"""
        return super().__str__() + "\nSide Length: " + str(self._side_length)


if __name__ == '__main__':
    # counters for total volume and surface area
    total_volume = 0
    total_surface_area = 0

    # create two cube objects
    shapes = [Cube(1.7), Cube(10)]

    # print out all shapes
    for shape in shapes:
        print(shape)
        print()

    # calculate total volume and surface area
    for shape in shapes:
        total_volume += shape.get_volume()
        total_surface_area += shape.get_surface_area()

    # print out total volume and surface area
    print("Total volume: " + str(total_volume))
    print("Total surface area: " + str(total_surface_area))

    # set side length of one cube to new value
    shapes[0].set_side_length(100)

    # print out new summary of cube with updated side length value
    print()
    print(shapes[0])
