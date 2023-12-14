lines = open("Day06Input.txt").read().split("\n")
lines = [int(i.split(":")[1].replace(" ", "")) for i in lines]
total = 0
for i in range(lines[0]+1):
    if i*(lines[0]-i) > lines[1]:
        total+=1
print(f"{total:,}")