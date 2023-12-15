with open("Day15Input.txt") as f: lines = f.read().split(",")
arr = [{} for _ in range(256)]
for line in lines:
    if line[-1] == '-': hasher = line[:-1]
    else: hasher = line[:-2]
    val = 0
    for char in hasher:
        val += ord(char)
        val *= 17
        val = val % 256
    if line[-1] == '-':
        line = line[:-1]
        if line in arr[val]:
            arr[val].pop(line)
    else:
        poop = int(line[-1])
        line = line[:-2]
        if line in arr[val]: arr[val][line] = poop
        else: arr[val][line] = poop
total = 0
for i, box in enumerate(arr):
    for j, (key, value) in enumerate(box.items()):
        total += int((i+1))*int((j+1))*int(value)
print(total)