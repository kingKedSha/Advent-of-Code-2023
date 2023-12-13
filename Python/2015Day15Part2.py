lines = open("2015Day15Input.txt").read().split("\n")
lines = [i.split(":")[1].split(",") for i in lines]
lines = [[int(j.split(" ")[2]) for j in i] for i in lines]
maximum = 0
lines = list(map(list, zip(*lines)))
for i in range(101):
    for j in range(101 - i):
        for k in range(101 - i - j):
            tot = 1
            l = 100 - i - j - k
            cal = i*lines[4][0] + j*lines[4][1] + k*lines[4][2] + l*lines[4][3]
            for m in range(4):
                line = lines[m]
                sum = i*line[0] + j*line[1] + k*line[2] + l*line[3]
                if sum < 0:
                    tot = 0
                else:
                    tot *= sum
            if cal == 500:
                maximum = max(tot, maximum)
print(maximum)