# Randy Wang
# Nashua High School North
# Senior-3
# Contest 3: Walk (Python)

def main():

    board = input("Enter in 8 hex values for row values of the array: ")    # Collect inputs

    test1 = input("Enter starting location/direction/number of moves: ")
    findLocation(board, test1)

    test2 = input("Enter starting location/direction/number of moves: ")
    findLocation(board, test2)

    test3 = input("Enter starting location/direction/number of moves: ")
    findLocation(board, test3)

    test4 = input("Enter starting location/direction/number of moves: ")
    findLocation(board, test4)

    test5 = input("Enter starting location/direction/number of moves: ")
    findLocation(board, test5)


def findLocation(arrayBoard, directions):    # Find final location of walker

    array = arrayBoard.split(",")
    startingLocation = directions[:3].split(",")
    direction = directions[4]
    moves = int(directions[6:])

    for i in range(len(array)):                 # Convert hex cell values to octal
        array[i] = oct(int(array[i], 16))[2:]

    board = []                              # Create 2D array representing the board
    for row in array:
        board.append([int(x) for x in row])

    currentLocation = [int(startingLocation[0])-1, int(startingLocation[1])-1]
    directionEntered = {"A": 0, "B": 180, "L": 270, "R": 90}
    cellMove = {0: [1,0], 45: [1,1], 90: [0,1], 135: [-1,1], 180: [-1,0], 225: [-1,-1], 270: [0,-1], 315: [1,-1]}
    angleEntered = directionEntered[direction]

    while moves > 0:
        directionMove = (angleEntered + board[currentLocation[0]][currentLocation[1]] * 45) % 360  # Find direction to move
        currentLocation[0] += cellMove[directionMove][0]
        currentLocation[1] += cellMove[directionMove][1]

        angleEntered = (directionMove + 180) % 360          # Find angle entered for next move
        moves -= 1

    finalLocation = str(currentLocation[0]+1) + ", " + str(currentLocation[1]+1)
    print(finalLocation)


if __name__ == "__main__":
    main()

    # 4F9D39,DEB456,3DA8B9,A57CA7,26A84A,2FCFA3,3AAB09,89CBF5
    # 1,2,L,2       2,4
    # 5,3,A,4       6,4
    # 3,5,B,2       4,6
    # 6,7,R,5       8,7
    # 4,7,L,6       3,7
