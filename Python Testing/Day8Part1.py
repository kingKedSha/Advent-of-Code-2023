lines = open("Day8Input.txt").read().split("\n")
directions = list(lines[0])*1000
lines = lines[2:]
names = [i[:3] for i in lines]
print(names)
leftright = [[i[7:10], i[12:15]] for i in lines]
currpos = names.index('XDA')
total = 0
foundit = False
for i in range(len(directions)):
    thing = directions[i]
    if thing == 'L':
        currpos = names.index(leftright[currpos][0])
        total+=1
    else:
        currpos = names.index(leftright[currpos][1])
        total+=1
    if names[currpos] == 'ZZZ':
        break
print(total)