import numpy as np
with open("Day14Input.txt") as f: lines = f.read().split("\n")
lines = [[char for char in i] for i in lines]
roller_nums = [0] * len(lines[0])
for b in range(1000):
    for a in range(4):
        for i in range(len(lines)):
            for j in range(len(lines[i])):
                if lines[i][j] == 'O':
                    x, y = i, j
                    movingup = True
                    while movingup:
                        if x == 0:
                            movingup = False
                        elif lines[x-1][y] != '.':
                            movingup = False
                        else:
                            lines[x-1][y] = 'O'
                            lines[x][y] = '.'
                            x -= 1
        np_array = np.array(lines)
        lines = np.rot90(np_array, 3).tolist()
total = 0
for i, lines in enumerate(lines):
    total += (len(lines)-i) * lines.count('O')
print(total)