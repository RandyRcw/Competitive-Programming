# There are N people on the shore (from 1,.. N) and you have a boat with a capacity to transport K people.
# List all possible ways you can load the boat. The order in which you list the people taking the boat does not matter.
#
# Example1:
# Enter N and K? 4 2
# Output:   1 2    1 3    1 4    2 3    2 4    3 4
#
# Example2:
# Enter N and K? 5 3
# Output:  1 2 3	1 2 4    1 2 5    1 3 4    1 3 5    1 4 5    2 3 4   2 3 5   2 4 5   3 4 5
from itertools import combinations

var = input("Enter N and K?").split(" ")
N = int(var[0])
K = int(var[1])

boat = combinations(range(1, N+1), K)

for i in list(boat):
    print(i, end="")
    print(" ", end="")


