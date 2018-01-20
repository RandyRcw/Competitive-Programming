input1 = input("").split(" ")
chores = [int(num) for num in input("").split(" ")]

numChores = int(input1[0])
numWorkHard = int(input1[1])
workHardTime = int(input1[2])

for i in range(len(chores),0,-1):
    if numWorkHard > 0:
        chores[i-1] = workHardTime
        numWorkHard -= 1
    else:
        i = 0

print(sum(chores))
