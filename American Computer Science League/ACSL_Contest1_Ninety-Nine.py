# Randy Wang
# Nashua High School North
# Senior-3
# Contest 1 Ninety-Nine

def main():

    cards = input("Enter starting cards: ").split(",")   # Collect inputs

    game1 = input("Enter cards for game 1:").split(",")
    playGame(cards,game1)

    game2 = input("Enter cards for game 2:").split(",")
    playGame(cards, game2)

    game3 = input("Enter cards for game 3:").split(",")
    playGame(cards, game3)

    game4 = input("Enter cards for game 4:").split(",")
    playGame(cards, game4)

    game5 = input("Enter cards for game 5:").split(",")
    playGame(cards, game5)


def playGame(cardsDealt, cardsPicked):    # Method to play game and print winner

    cards1 = cardsDealt
    cards2 = cardsPicked

    for i in range(0,len(cards1)):     #Convert face cards to number values
        if cards1[i] == "T":
            cards1[i] = "10"
        if cards1[i] == "J":
            cards1[i] = "11"
        if cards1[i] == "Q":
            cards1[i] = "12"
        if cards1[i] == "K":
            cards1[i] = "13"
        if cards1[i] == "A":
            cards1[i] = "14"

    for i in range(0,len(cards2)):
        if cards2[i] == "T":
            cards2[i] = "10"
        if cards2[i] == "J":
            cards2[i] = "11"
        if cards2[i] == "Q":
            cards2[i] = "12"
        if cards2[i] == "K":
            cards2[i] = "13"
        if cards2[i] == "A":
            cards2[i] = "14"

    player1Hand = [int(x) for x in cards1[:5]]    # Lists representing player 1 and 2's current hand
    player2Hand = [int(x) for x in cards1[5:]]

    cardPile = [int(x) for x in cards2[1:]]   # Pile of cards to be drawn from
    pointTotal = int(cardsPicked[0])          # Variable to determine winner when total eclipses 99

    player1Turn = True         # Variable determining either player 1 or 2's turn

    while pointTotal <= 99:

        initialPointTotal = pointTotal

        if player1Turn:      # Player1 plays and draws

            player1Hand.sort()
            card = player1Hand[2]    # Median card

            # print("Card: " + str(card))
            # print("Initial: " + str(initialPointTotal))

            if card == 9:           # Special card cases

                pointTotal += 0

            elif card == 10:

                pointTotal -= 10

            elif card == 7:

                if pointTotal + 7 <= 99:
                    pointTotal += 7
                else:
                    pointTotal += 1

            else:                   # Default card case

                pointTotal += card

            # Crossing point total border 33:34, 55:56, and 77:78 in either direction

            if (initialPointTotal <= 33 and pointTotal >= 34) or (initialPointTotal <= 55 and pointTotal >= 56) or (initialPointTotal <= 77 and pointTotal >= 78):
                pointTotal += 5
            elif (pointTotal <= 33 and initialPointTotal >= 34) or (pointTotal <= 55 and initialPointTotal >= 56) or (pointTotal <= 77 and initialPointTotal >= 78):
                pointTotal += 5

            player1Hand.remove(card)       # Remove card played
            if len(cardPile) > 0:
                player1Hand.append(cardPile.pop(0))     # Draw new card from top of deck
            player1Turn = False

        else:                # Player2 plays and draws

            player2Hand.sort()
            card = player2Hand[2]   # Median card

            # print("Card: " + str(card))
            # print("Initial: " + str(initialPointTotal))

            if card == 9:

                pointTotal += 0

            elif card == 10:

                pointTotal -= 10

            elif card == 7:

                if pointTotal + 7 <= 99:
                    pointTotal += 7
                else:
                    pointTotal += 1
            else:

                pointTotal += card

            if (initialPointTotal <= 33 and pointTotal >= 34) or (initialPointTotal <= 55 and pointTotal >= 56) or (initialPointTotal <= 77 and pointTotal >= 78):
                pointTotal += 5
            elif (pointTotal <= 33 and initialPointTotal >= 34) or (pointTotal <= 55 and initialPointTotal >= 56) or (pointTotal <= 77 and initialPointTotal >= 78):
                pointTotal += 5

            player2Hand.remove(card)
            if len(cardPile) > 0:
                player2Hand.append(cardPile.pop(0))
            player1Turn = True


        #print("Point total: " + str(pointTotal))


    if player1Turn:        #Print winner and final score
        print(str(pointTotal) + ", Player #1")
    else:
        print(str(pointTotal) + ", Player #2")


if __name__ == "__main__":
    main()


    # 8,9,Q,6,7,K,A,5,9,8
    # 75,J,7,Q,T,A,6,2,3,4,5                      107, Player 2
    # 50,7,K,T,8,3,Q,9,7,2,3                      109, Player 1
    # 63,3,6,8,T,7,7,T,3,5,8                      103, Player 1
    # 79,A,9,7,T,A,9,T,A,6,4                      100, Player 2
    # 50,A,T,Q,A,T,K,J,T,A,7                      102, Player 2
