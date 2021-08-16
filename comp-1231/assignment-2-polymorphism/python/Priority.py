from abc import ABC, abstractmethod
from random import randint


class Priority(ABC):
    """Represents an interface for purposes of establishing a numeric priority among a set of objects.
    Contains constants for priority levels and methods to set/get a priority."""

    LOW = 1
    MEDIUM = 5
    HIGH = 8

    @abstractmethod
    def get_priority(self):
        """Returns the priority of an object"""

    @abstractmethod
    def set_priority(self, priority):
        """Used to set the priority of an object"""


class Task(Priority):

    def __init__(self, description, priority=Priority.LOW):
        """Constructor #1: Sets up a Task object.  Accepts a Task's description as a string and priority
           level as an integer.  Calls support method setPriorityText to initially set a Task's text
           representation of it's numeric priority."""

        self.description = description
        self.priority = priority

        if self.priority >= Priority.LOW & self.priority < Priority.MEDIUM:
            self.priority_text = "LOW"

        elif self.priority >= Priority.MEDIUM & self.priority < Priority.HIGH:
            self.priority_text = "MEDIUM"

        else:
            self.priority_text = "HIGH"

    def get_priority(self):
        """Priority accessor."""

        return self.priority

    def set_priority(self, priority):
        """Priority mutator."""

        self.priority = priority

    def get_description(self):
        """Description accessor."""

        return self.description

    def set_description(self, description):
        """Description mutator."""

        self.description = description

    def __lt__(self, other):
        """Less than compare operator for a Task object"""

        return self.priority < other.priority

    def __gt__(self, other):
        """Greater than compare operator for a Task object"""

        return self.priority > other.priority

    def __eq__(self, other):
        """Equal to compare operator for a Task object"""

        return self.priority == other.priority

    def __str__(self):
        """Returns a nicely formatted string representation of a Task's description and priority."""

        return ("Task Priority: " + str(self.priority) + " - " + self.priority_text + "\n"
                + "Task Description: " + self.description)


if __name__ == "__main__":

    tasks = []

    print("Creating some tasks...")

    tasks.append(Task("Do Homework", 8))
    tasks.append(Task("Grocery Shopping", 4))
    tasks.append(Task("Buy new shoes", 1))
    tasks.append(Task("Call mom", 10))
    tasks.append(Task("Workout"))

    tasks[4].set_priority(7)

    print("Printing the tasks...")
    for task in tasks:
        print("-------------------------------------")
        print(task)
        print("-------------------------------------")

    print("Randomly reassigning priorities...")
    for task in tasks:
        task.set_priority(randint(1, 10))

    print("Reprinting the tasks...")
    for task in tasks:
        print("-------------------------------------")
        print(task)
        print("-------------------------------------")

    print("Sorting the tasks...")
    tasks.sort(reverse=True)

    print("Reprinting the sorted tasks...")
    for task in tasks:
        print("-------------------------------------")
        print(task)
        print("-------------------------------------")

    task1 = Task("High priority", 10)
    task2 = Task("Low priority", 1)

    print(task1 == task2)
    print(task1 > task2)
    print(task1 < task2)
