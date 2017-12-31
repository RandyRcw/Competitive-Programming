# There are N of children sitting in a circle. You go around the circle and eliminate the Kth child until all children
# have been removed. Write a program that simulates the elimination process. The user should be prompted to enter
# values for N and K. The output should list the children in the order in which they are removed. You assume the initial
# order of children is 1 2 .. N
#
# Example1.	INPUT: Enter number of children, N? 5
#  	Enter K? 3
# OUTPUT: 3 1 5 2 4
#
# Example2.	INPUT: Enter number of children, N? 7
#  	Enter K? 3
# OUTPUT: 3 6 2 7 5 1 4

num = int(input("Enter the number of children, N"))
k = int(input("Enter K?"))
index = k-1

children = []
removed = ""

for i in range(num):
    children.append(i+1)

while len(children) > 0:
    removed += str(children.pop(index)) + " "
    if len(children) > 0:
        index = (index + k-1) % len(children)

print(removed)