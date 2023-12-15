with open("Day15Input.txt") as f: lines = f.read().split(",")
total = 0
for line in lines:
    val = 0
    for char in line:
        val += ord(char)
        val *= 17
        val = val % 256
    total += val
print(total)