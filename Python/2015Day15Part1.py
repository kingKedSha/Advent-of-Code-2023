lines = open("2015Day15Input.txt").read().split("\n")
lines = [i.split(":")[1].split(",")[:4] for i in lines]
lines = [[int(j.split(" ")[2]) for j in i] for i in lines]
maximum = 0
lines = list(map(list, zip(*lines)))
print(lines)
for i in range(101):
    for j in range(101 - i):
        for k in range(101 - i - j):
            tot = 1
            l = 100 - i - j - k
            print(str(i+j+k+l) + " " + str(i) + " " + str(j) + " " + str(k) + " " + str(l))
            for line in lines:
                sum = i*line[0] + j*line[1] + k*line[2] + l*line[3]
                if sum < 0:
                    tot = 0
                else:
                    tot *= sum
            maximum = max(tot, maximum)
print(maximum)