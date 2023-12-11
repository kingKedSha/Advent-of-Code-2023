with open("Day11Input.txt") as file: lines = file.read().split("\n")
lines = [[char for char in i] for i in lines]
index = 0
million_cols, million_rows = [], []
while index < len(lines):
    if all(char == '.' for char in lines[index]):
        million_cols.append(index)
    index += 1
lines = list(map(list, zip(*lines)))
index = 0
while index < len(lines):
    if all(char == '.' for char in lines[index]):
        million_rows.append(index)
    index += 1
points = []
for i in range(len(lines)):
    for j in range(len(lines[i])):
        if lines[i][j] == '#':
            points.append([i, j])
total = 0
for i in range(len(points)):
    for j in range(i+1, len(points), 1):
        rows = [points[i][0], points[j][0]]
        cols = [points[i][1], points[j][1]]
        for row in million_rows:
            if (rows[0] > row and rows[1] < row) or (rows[0] > row and rows[1] > row):
                total += 999999
        for col in million_cols:
            if (cols[0] > col and cols[1] < col) or (cols[0] < col and cols[1] > col):
                total += 999999
        total += abs(rows[0]-rows[1]) + abs(cols[0]-cols[1])
print(total)