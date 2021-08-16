# COMP 2231 Assignment 3 - Python implementation of a Stack using a
# python list as the container.


class ArrayStack:
    """Implementation of a basic stack data structure using a python list
    as the container."""

    def __init__(self):
        """Create an empty stack"""
        self._stack = []

    def push(self, element):
        """Adds the specified element to the top of this stack"""
        self._stack.append(element)

    def pop(self):
        """Removes and returns the top element from this stack"""
        if self.is_empty():
            raise EmptyException("Stack is Empty")

        return self._stack.pop()

    def peek(self):
        """Returns without removing the top element of this stack"""
        if self.is_empty():
            raise EmptyException("Stack is Empty")

        return self._stack[-1]

    def is_empty(self):
        """Returns true if this stack contains no elements"""
        return len(self._stack) == 0

    def __len__(self):
        """Returns the number of elements in this stack"""
        return len(self._stack)

    def __str__(self):
        """Returns a string representation of this stack"""
        return "\n".join(self._stack)


class EmptyException(Exception):
    """Thrown when an attempt is made to access an element from an empty
    container."""

    pass
