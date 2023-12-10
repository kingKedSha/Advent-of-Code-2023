lines = open("Day10Input.txt").read().split("\n")
for i, line in enumerate(lines):
    if 'S' in line:
        ind = [i, line.index('S')]
        break
dir = "up"
looplength = 0
loopdone = False
print(lines[ind[0]][ind[1]])
print(lines)
while loopdone == False:
    if dir == "right":
        ind[1] += 1
    elif dir == "left":
        ind[1] -= 1
    elif dir == "up":
        ind[0] -= 1
    elif dir == "down":
        ind[0] += 1
    if lines[ind[0]][ind[1]] == 'F':
        if dir == "up":
            dir = "right"
        else:
            dir = "down"
    elif lines[ind[0]][ind[1]] == "7":
        if dir == "up":
            dir = "left"
        else:
            dir = "down"
    elif lines[ind[0]][ind[1]] == "J":
        if dir == "down":
            dir = "left"
        else:
            dir = "up"
    elif lines[ind[0]][ind[1]] == "L":
        if dir == "down":
            dir = "right"
        else:
            dir = "up"
    looplength+=1
    if lines[ind[0]][ind[1]] == 'S':
        loopdone = True
    print(dir)
print(looplength/2)