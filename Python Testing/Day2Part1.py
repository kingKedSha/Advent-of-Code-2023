lines = open("Day2Input.txt").read().split("\n")
total = 0
for i in range(len(lines)):
    line = lines[i]
    sets = line.split(":")[1].split(";")
    bad = False
    for set in sets:
        nums = set.split(",")
        nums = [goob.split(" ") for goob in nums]
        nums = [i[1:] for i in nums]
        nums = [[int(i[0]), i[1]] for i in nums]
        colors = [0]*3
        for color in nums:
            if (color[1] == "red"):
                colors[0] = color[0]
            elif (color[1] == "green"):
                colors[1] = color[0]
            else:
                colors[2] = color[0]
        if colors[0] > 12 or colors[1] > 13 or colors[2] > 14:
            bad = True
    if bad == False:
        total += i + 1
print(total)