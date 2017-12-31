# Write a program that accepts a word of length N (1 <= N <= 30) and draws concentric squares as borders in the
# following manner:for each character a border is made, from outside to inside and filled with the corresponding letter.
# Example1.   INPUT: Enter string?  JOE
# 		OUTPUT:	    JJJJJ
#             		JOOOJ
#             		JOEOJ
#             		JOOOJ
#             		JJJJJ

word = input("Enter string?")

vortex = []
for i in range((len(word)-1)*2+1):
    vortex.append([])
    for j in range((len(word)-1)*2+1):
        vortex[i].append("-1")

row = 0
col = 0
endRow = len(vortex)
endCol = len(vortex)
count = 0

while count < len(word):

    for i in range(col,endCol):
        vortex[row][i] = word[count]
    row += 1

    for i in range(row,endRow):
        vortex[i][endCol-1] = word[count]
    endCol -= 1

    for i in range(endCol-1,col-1,-1):
        vortex[endRow-1][i] = word[count]
    endRow -= 1

    for i in range(endRow-1,row-1,-1):
        vortex[i][col] = word[count]
    col += 1

    count += 1

for i in vortex:
    for j in i:
        print(j, end="")
    print()