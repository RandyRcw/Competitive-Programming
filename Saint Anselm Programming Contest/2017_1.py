# Write a program that computes the total time needed to finish all n problems at a coding contest.
# The program will ask for the number of problems n, and the corresponding time needed to solve each problem.
# Times should be input in the format HH:MM where H, M are digits (0-9).
# The program will display the resulting time in 2 formats: in minutes (ex:127 min) and hour and minutes (ex:2 h 7 min).
# The answer 2 h 67 min is not acceptable, it should be 3 h 7 min.
# Also the answer 3 h 0 min is not acceptable, it should be just 3 h.
#
# Example1. 	Input: 	Enter n? 3
# Enter hours worked? 01:23 00:34 00:07
#             Output: 	124 min = 2 h 4 min
#
# Example2. 	Input: 	Enter n? 4
# 				Enter hours worked? 01:03 00:34 00:07 02:00
#             Output: 	224 min = 3 h 44 min
#
# Example3. 	Input: 	Enter n? 3
# 				Enter hours worked? 00:00 01:11 02:22
#             Output: 	213 min = 3 h 33 min

n = input("Enter n?")
hoursWorked = input("Enter hours worked?")

hours = hoursWorked.split(" ")

totalMinutes = 0

for hour in hours:
    h = hour[:hour.find(":")]
    m = hour[hour.find(":")+1:]
    totalMinutes += int(h)*60 + int(m)

HH = int(totalMinutes / 60)
MM = totalMinutes % 60

if HH == 0:
    print(str(totalMinutes) + " min = " + str(MM) + " min")
elif MM == 0:
    print(str(totalMinutes) + " min = " + str(HH) + " h")
else:
    print(str(totalMinutes) + " min = " + str(HH) + " h " + str(MM) + " min")