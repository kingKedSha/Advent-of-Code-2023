lines = open("Day10Input.txt").read().split("\n")
for i, line in enumerate(lines):
    if 'S' in line:
        ind = [i, line.index('S')]
        break
beg = [ind[0], ind[1]]
lines[ind[0]] = lines[ind[0]].replace('S', 'J')
points = [[False] * len(lines[0]) for _ in range(len(lines))]
dirs = [["null"] * len(lines[0]) for _ in range(len(lines))]
dir = "up"
loopdone = False
directions = {"right": (0, 1), "left": (0, -1), "up": (-1, 0), "down": (1, 0)}
changes = {'F': {"up": "right", "left": "down"}, 
           '7': {"up": "left", "right": "down"}, 
           'J': {"down": "left", "right": "up"}, 
           'L': {"down": "right", "left": "up"}}
while loopdone == False:
    points[ind[0]][ind[1]] = True
    dirs[ind[0]][ind[1]] = dir
    ind[0] += directions[dir][0]
    ind[1] += directions[dir][1]
    if lines[ind[0]][ind[1]] in changes:
        dir = changes[lines[ind[0]][ind[1]]][dir]
    loopdone = (ind == beg)
total = 0
downs = ['|', 'F', '7']
for i, line in enumerate(lines):
    pol = 0
    for j, char in enumerate(line):
        if points[i][j] == True:
            if lines[i][j] == '|':
                pol += 1 if dirs[i][j] == "up" else -1
            elif lines[i][j] == 'F':
                pol += 1 if dirs[i][j] == "right" else -1
            elif lines[i][j] == '7':
                pol += 1 if dirs[i][j] == "left" else -1
        elif pol != 0:
            total += 1
print(total)