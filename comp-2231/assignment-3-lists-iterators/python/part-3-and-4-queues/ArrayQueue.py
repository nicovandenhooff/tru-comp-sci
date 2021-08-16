# COMP 2231 Assignment 3 - Python implementation of a Queue using a python
# list as the container


class CircularArrayQueue:
    """Implementation of a basic queue data structure using a python list
    as the container, treating the list as a circular array."""

    DEFAULT_CAPACITY = 5  # default capacity for circular implementation

    def __init__(self, capacity=DEFAULT_CAPACITY):
        """Create an empty queue"""
        self._queue = [None] * capacity
        self._front = 0  # front of queue
        self._rear = 0  # rear of queue
        self._count = 0  # number of elements in queue

    def enqueue(self, element):
        """Adds the specified element to the rear of this queue"""
        if self._count == len(self._queue):
            self._expand_capacity()

        # enqueue element
        self._queue[self._rear] = element

        # update rear tracker and increment number of items
        self._rear = (self._rear + 1) % len(self._queue)
        self._count += 1

    def dequeue(self):
        """Removes and returns the element from the front of this queue"""
        if self.is_empty():
            raise EmptyException("Queue is Empty")

        # store item to dequeue in temp variable
        result = self._queue[self._front]

        # remove front item
        self._queue[self._front] = None

        # update front tracker and decrement count
        self._front = (self._front + 1) % len(self._queue)
        self._count -= 1

        return result

    def first(self):
        """Returns without removing the front element of this queue"""
        if self.is_empty():
            raise EmptyException("Queue is Empty")

        return self._queue[self._front]

    def is_empty(self):
        """Returns true if this queue contains no elements"""
        return self._count == 0

    def _expand_capacity(self):
        """Expands the current capacity of the queue by a factor of 2x"""

        # create temporary list with 2x capacity
        temp = [None] * (len(self._queue) * 2)

        # transfer items from old queue to temp list
        for idx in range(self._count):
            temp[idx] = self._queue[self._front]
            self._front = (self._front + 1) % len(self._queue)

        # reset front to index 0, rear to number of items
        self._front = 0
        self._rear = self._count

        # reassign queue
        self._queue = temp

    def __len__(self):
        """Returns the number of elements in this queue"""
        return self._count

    def __str__(self):
        """Returns a string representation of this queue"""
        return "\n".join(filter(None, self._queue))


class EmptyException(Exception):
    """Thrown when an attempt is made to access an element from an empty
    container."""

    pass


if __name__ == "__main__":
    queue = CircularArrayQueue()

    queue.enqueue("A")
    queue.enqueue("B")
    queue.enqueue("C")

    print(queue)
    print("First element: " + str(queue.first()))
    print("Size: " + str(len(queue)))

    queue.enqueue("D")
    queue.enqueue("E")
    queue.enqueue("F")

    print(queue)
    print("First element: " + str(queue.first()))
    print("Size: " + str(len(queue)))

    queue.dequeue()
    queue.dequeue()
    queue.dequeue()

    print(queue)
    print("First element: " + str(queue.first()))
    print("Size: " + str(len(queue)))
