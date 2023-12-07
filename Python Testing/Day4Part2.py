lines = open("Day4Input.txt").read().split("\n")
cardnums = [1] * len(lines)
for i in range(len(lines)):
    line = lines[i]
    card = cardnums[i]
    win = line.split("|")[0].split(":")[1].split(" ")
    have = line.split("|")[1].split(" ")
    points = len([i for i in win if i in have and i != ""])
    if (points != 0):
        cardnums[i+1:i+points+1] = [x + cardnums[i] for x in cardnums[i+1:i+points+1]]
print(sum(cardnums))