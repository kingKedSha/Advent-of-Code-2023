lines = open("Day10Input.txt").read().split("\n")
for i, line in enumerate(lines):
    if 'S' in line:
        ind = [i, line.index('S')]
        break
dir = "up"
looplength = 0
loopdone = False
directions = {"right": (0, 1), "left": (0, -1), "up": (-1, 0), "down": (1, 0)}
changes = {'F': {"up": "right", "left": "down"}, '7': {"up": "left", "right": "down"}, 'J': {"down": "left", "right": "up"}, 'L': {"down": "right", "left": "up"}}
while loopdone == False:
    ind[0] += directions[dir][0]
    ind[1] += directions[dir][1]
    if lines[ind[0]][ind[1]] in changes:
        dir = changes[lines[ind[0]][ind[1]]][dir]
    looplength += 1
    loopdone = lines[ind[0]][ind[1]] == 'S'
print(int(looplength/2))