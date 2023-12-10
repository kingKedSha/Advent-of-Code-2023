lines = open("Day9Input.txt").read().split("\n")
lines = [i.split(" ")[::-1] for i in lines]
lines = [[int(j) for j in i] for i in lines]
total = 0
for line in lines:
    rows = [line]
    while all(i == 0 for i in rows[-1]) == False:
        rows.append([])
        for i in range(len(rows[-2])-1):
            rows[-1].append(rows[-2][i+1] - rows[-2][i])
    for i in range(len(rows)-2, -1, -1):
        rows[i].append(rows[i][-1] + rows[i+1][-1])
    total += rows[0][-1]
print(total)