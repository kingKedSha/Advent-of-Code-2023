with open("Day11Input.txt") as file: lines = file.read().split("\n")
lines = [[char for char in i] for i in lines]
million_cols, million_rows, points = [], [], []
million_cols = [i for i in range(len(lines)) if '#' not in lines[i]]
lines = list(map(list, zip(*lines)))
million_rows = [i for i in range(len(lines)) if '#' not in lines[i]]
points = [[i, j] for i in range(len(lines)) for j in range(len(lines[i])) if lines[i][j] == '#']
total = 0
for i in range(len(points)):
    for j in range(i+1, len(points), 1):
        rows = [points[i][0], points[j][0]]
        cols = [max(points[i][1], points[j][1]), min(points[i][1], points[j][1])]
        total += sum(999_999 for row in million_rows if rows[0] > row and rows[1] > row)
        total += sum(999_999 for col in million_cols if cols[0] > col and cols[1] < col)
        total += rows[0]-rows[1] + cols[0]-cols[1]
print(total)