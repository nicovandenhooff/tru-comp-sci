# python implementation of COMP 2231 Assignment 1: Part 1 (shell sort)
# and part 2 (more efficient bubble sort).  Please see Java file for
# detailed instructions

import copy


def swap(data, index1, index2):
    """Swaps two elements in a list.

    Parameters
    ----------
    data : list
        The data that contains the elements to swap.
        Must all be of the same type.
    index1, index2 : int
        The indicies of the items to swap.
    """
    temp = data[index1]
    data[index1] = data[index2]
    data[index2] = temp


def shell_sort(data):
    """Sorts a list with a shell sort.

    Parameters
    ----------
    data : list
        The data to sort.  Must all be of the same type.
    """
    # initial gap value
    gap = len(data) // 2

    # outer loop until final pass with gap = 1
    while gap > 0:
        swap_flag = True

        # if a swap has taken place continue checking for more swaps
        while swap_flag:
            swap_flag = False

            # compare elements accross gaps looking for a swap
            for s in range(len(data) - gap):
                if data[s] > data[s + gap]:
                    swap(data, s, s + gap)
                    swap_flag = True
                    print(data)

        # next gap size
        gap = gap // 2


def bubble_sort(data):
    """Sort a list with bubble sort.

    Parameters
    ----------
    data : list
        The data to sort.  Must all be of the same type.
    """
    for position in reversed(range(len(data))):
        print(data)

        # bubble largest value in currest iteration to end of list
        for scan in range(position - 1):
            if data[scan] > data[scan + 1]:
                swap(data, scan, scan + 1)


def bubble_sort_2(data):
    """Modified bubble sort that stops once the list is sorted.

    Parameters
    ----------
    data : list
        The data to sort.  Must all be of the same type.
    """
    position = len(data) - 1
    swap_flag = True

    # continue bubble sort if a swap has occured and position is valid
    while swap_flag and position >= 0:
        swap_flag = False
        print(data)

        # bubble largest value if needed and determine if swap occured
        for scan in range(position):
            if data[scan] > data[scan + 1]:
                swap(data, scan, scan + 1)
                swap_flag = True

        # next position to bubble to
        position -= 1


if __name__ == "__main__":

    array1_shell = [9, 6, 8, 12, 3, 1, 7]
    array1_bubble = array1_shell.copy()
    array1_bubble2 = array1_shell.copy()

    print("Before shell sort: " + str(array1_shell))
    shell_sort(array1_shell)
    print("After shell sort: " + str(array1_shell))

    print("Before bubble sort: " + str(array1_bubble))
    bubble_sort(array1_bubble)
    print("After bubble sort: " + str(array1_bubble))

    print("Before bubble sort2: " + str(array1_bubble2))
    bubble_sort_2(array1_bubble2)
    print("After bubble sort2: " + str(array1_bubble2))
