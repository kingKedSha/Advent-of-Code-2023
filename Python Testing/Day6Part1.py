lines = open("Day6Input.txt").read().split("\n")
lines = [i.split(":")[1].split(" ") for i in lines]
lines = [[j for j in i if j != ""] for i in lines]
lines = list(map(list, zip(*lines)))
lines = [[int(j) for j in i] for i in lines]
total = 1
print(lines)
for i in range(len(lines)):
    tot = 0
    for j in range(lines[i][0]+1):
        if j*(lines[i][0]-j) > lines[i][1]:
            tot+=1
    total *= tot
print(total)