lines = open("Day4Input.txt").read().split("\n")
total = 0
for line in lines:
    win = line.split("|")[0].split(":")[1].split(" ")
    have = line.split("|")[1].split(" ")
    points = [i for i in win if i in have and i != ""]
    if (len(points) != 0):
        total += 2 ** (len(points)-1)
print(total)