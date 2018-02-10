# Randy Wang
# Nashua High School North
# Senior-3
# Contest 2: Enclosure

def main():

    test1 = input("Enter string of characters representing mathematical expression:")  #Collect inputs
    determineLocations(test1)

    test2 = input("Enter string of characters representing mathematical expression:")
    determineLocations(test2)

    test3 = input("Enter string of characters representing mathematical expression:")
    determineLocations(test3)

    test4 = input("Enter string of characters representing mathematical expression:")
    determineLocations(test4)

    test5 = input("Enter string of characters representing mathematical expression:")
    determineLocations(test5)


def determineLocations(stringCharacters):

    expression = [x for x in stringCharacters]      #List representing expression
    operators = ["+", "-", "*", "/"]
    enclosures = ["{", "[", "(", ")", "]", "}"]
    missingPair = ""
    locations = []

    presentEnclosures = []          #Find enclosures currently in expression
    for enclosure in enclosures:
        if expression.count(enclosure) != 0:
            presentEnclosures.append(enclosure)

    for enclosure in presentEnclosures:
        if presentEnclosures.count(enclosures[len(enclosures)-1 - enclosures.index(enclosure)]) == 0:
            missingPair = enclosure

    missingEnclosure = enclosures[len(enclosures)-1 - enclosures.index(missingPair)]

    if enclosures[3:].count(missingEnclosure) > 0:      #Closing enclosure is missing

        location = expression.index(missingPair)+1
        operatorLocation = 0

        while location < len(expression):

            if enclosures[:3].count(expression[location]) > 0:
                location = expression.index(enclosures[len(enclosures)-1 - enclosures.index(expression[location])]) + 1
                locations.append(location+1)

            elif enclosures[3:].count(expression[location]) > 0:
                location = len(expression)

            else:                                                #Find operator and number after
                for i in range(location, len(expression)):
                    if operators.count(expression[i]) > 0:
                        operatorLocation = i
                        break

                if enclosures.count(expression[operatorLocation+1]) > 0:      #Encounters opening enclosure
                    location = expression.index(
                        enclosures[len(enclosures) - 1 - enclosures.index(expression[operatorLocation+1])]) + 1
                    locations.append(location+1)
                else:
                    for i in range(operatorLocation+1, len(expression)):  #Find end of number
                        if not expression[i].isdigit():
                            location = i
                            locations.append(i+1)
                            break
                        if len(expression)-1 == i and expression[i].isdigit():
                            location = i+1
                            locations.append(location+1)
    else:                                                         #Opening enclosure is missing
        location = expression.index(missingPair)-1
        operatorLocation = 0

        while location >= 0:

            if enclosures[3:].count(expression[location]) > 0:
                location = expression.index(enclosures[len(enclosures)-1 - enclosures.index(expression[location])]) - 1
                locations.append(location+2)

            elif enclosures[:3].count(expression[location]) > 0:
                location = -1

            else:                                               #Find operator and number after
                for i in range(location, -1, -1):
                    if operators.count(expression[i]) > 0:
                        operatorLocation = i
                        break

                if enclosures.count(expression[operatorLocation-1]) > 0:      #Encounters opening enclosure
                    location = expression.index(
                        enclosures[len(enclosures) - 1 - enclosures.index(expression[operatorLocation-1])]) - 1
                    locations.append(location+2)
                else:
                    for i in range(operatorLocation-1, -1, -1):  #Find end of number
                        if not expression[i].isdigit():
                            location = i
                            locations.append(i+2)
                            break
                        if 0 == i and expression[i].isdigit():
                            location = i-1
                            locations.append(location+2)
        locations.reverse()

    output = ""
    for i in range(len(locations)):
        if i == 0:
            output += str(locations[i])
        else:
            output += ", " + str(locations[i])
    print(output)


if __name__ == "__main__":
    main()

    # {[(2+3)*6/10}
    # {[7*25/5+14)*51]+6}
    # {60+[15*(520-505)]/5-23
    # {32*510+(8/4)*2+43]/24}
    # {[(24+900/300*64]}
