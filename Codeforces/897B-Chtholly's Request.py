input1 = input("").split(" ")

k = int(input1[0])
p = int(input1[1])

sumNumbers = 0

for i in range(1,k+1,1):
    num = int(str(i) + str(i)[::-1])
    sumNumbers += num

print(sumNumbers % p)