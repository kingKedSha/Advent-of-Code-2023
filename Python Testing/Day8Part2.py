import math
lines = open("Day8Input.txt").read().split("\n")
directions = list(lines[0]) * 10000
lines = lines[2:]
names = [i[:3] for i in lines]
leftright = [[i[7:10], i[12:15]] for i in lines]
currpos = [names.index(i) for i in names if i[-1] == 'A']
print(currpos)
factors = [0]*len(currpos)
for i in range(len(currpos)):
    for j in range(len(directions)):
        thing = directions[j]
        if thing == 'L':
            currpos[i] = names.index(leftright[currpos[i]][0])
            factors[i]+=1
        else:
            currpos[i] = names.index(leftright[currpos[i]][1])
            factors[i]+=1
        if names[currpos[i]][-1]=='Z':
            break
print(factors)
print(math.lcm(*factors))