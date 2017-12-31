# Print the greatest prime numbers with 1 digit, 2 digits, up to 7 digits that have this property: as you read the
# number from left to right, wherever you stop, the number should be prime. (Program should run in less than 40 secs)
# Example:  ABCD should have this property:
# A is prime
# AB is prime
# ABC is prime
# ABCD is prime
# ABCD should be the greatest number on 4 digits with this property
#
# OUTPUT: seven integers on one line

# primes = ["7"]
#
# for i in range(6):
#
#     newPrime = primes[i] + "9"
def main():
    print(prime(73937))
    primes = [7]
    possibleDigits = [9,7,3,1]
    
    while len(primes) < 7:
        newPrime = primes[len(primes)-1]


def prime(num):
    if num % 2 == 0 or num % 5 == 0 or sumofnumber(num) % 3 == 0 or num % 7 == 0:
        return False
    else:
        for i in range(11,int(num/2)):
            if num % i == 0:
                return False
        return True


def sumofnumber(num):
    sum = 0
    while num > 0:
        sum += num % 10
        num = int(num/10)
    return sum

if __name__ == "__main__":
    main()