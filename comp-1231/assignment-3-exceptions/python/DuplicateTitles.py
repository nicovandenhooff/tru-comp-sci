# python implementation of Assignment 3: Exceptions (Part 2)
# see the headers in the .Java files for details about the assignment

from collections import Counter

input_file_path = "bookTitles.inp"
output_file_path = "duplicateTitles.out"

titles = []

with open(input_file_path, 'r') as input_file:
    for title in input_file:
        titles.append(title)

duplicates = [k for k, v in Counter(titles).items() if v > 1]

with open(output_file_path, 'w') as output_file:
    for title in duplicates:
        output_file.write(title)
