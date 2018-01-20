input1 = input("")
input2 = input("")

listInput1 = input1.split(" ")
totalGroups = int(listInput1[0])
oneTables = int(listInput1[1])
twoTables = int(listInput1[2])
twoTablesSingle = 0
clients = [int(client) for client in input2.split(" ")]
clientsDenied = []

for i in range(totalGroups):
    if clients[i] == 1:
        if oneTables > 0:
            oneTables -= 1
        elif twoTables > 0:
            twoTables -= 1
            twoTablesSingle += 1
        elif twoTablesSingle > 0:
            twoTablesSingle -= 1
        else:
            clientsDenied.append(clients[i])
    else:
        if twoTables > 0:
            twoTables -= 1
        else:
            clientsDenied.append(clients[i])

print(sum(clientsDenied))