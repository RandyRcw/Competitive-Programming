def main():
    a = list(input(""))
    b = input("")
    a.sort()
    a.reverse()
    maxNumber = ""

    if len(a) < len(str(b)):
        for num in a:
            maxNumber += num
    else:
        maxNumber = fillInDigit(a,b,[],"")
    print(maxNumber)

def fillInDigit(num1, num2, usedDigits, currentMaxNumber):
    maxLeadingDigit = "-1"
    secondLeadingDigit = int(num2[0])
    for x in num1:
        if int(x) <= secondLeadingDigit and int(x) > int(maxLeadingDigit):
            maxLeadingDigit = x

    maxNumber1 = currentMaxNumber
    maxNumber1 += maxLeadingDigit
    usedDigits.append(maxLeadingDigit)
    num1.remove(maxLeadingDigit)
    num2 = num2[1:]

    if len(num1) == 0:
        return maxNumber1
    elif int(maxLeadingDigit) < secondLeadingDigit:
        if len(num1) > 0:
            for num in num1:
                maxNumber1 += num
        return maxNumber1
    elif int(min(num1)) > int(num2[0]):
        for i in range(len(maxNumber1)-1,-1,-1):
            maxLeadingDigit2 = "-1"

            for x in num1:
                if int(x) < int(maxNumber1[i]) and int(x) > int(maxLeadingDigit2):
                    maxLeadingDigit2 = x
            if maxLeadingDigit2 == "-1":
                num1.append(usedDigits[len(usedDigits)-1])
                usedDigits.pop()
            else:
                num1.append(maxNumber1[i])
                maxNumber1 = maxNumber1[:i] + maxLeadingDigit2
                num1.remove(maxLeadingDigit2)
                num1.sort()
                num1.reverse()

                if len(num1) > 0:
                    for num in num1:
                        maxNumber1 += num
                return maxNumber1
    else:
        return fillInDigit(num1,num2,usedDigits,maxNumber1)

if __name__ == "__main__":
    main()