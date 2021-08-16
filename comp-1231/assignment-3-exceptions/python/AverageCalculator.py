# python implementation of Assignment 3: Exceptions (Part 1)
# see the headers in the .Java files for details about the assignment

total, average, values = 0, 0, 0

number = input("Enter an integer (or stop to quit): ")

while number.lower() != "stop":
    try:
        number = int(number)
        total += number
        values += 1
        average = total / values
    except ValueError:
        print("Input is not an integer: " + number)
    finally:
        print("You have entered " + str(values) + " valid integers")
        print("The average of these values is: " + str(average))
        print()

    number = input("Enter an integer (or stop to quit): ")

print("Thank you for using the Average Calculator")
print("The program will now terminate")
