with open("Day13Input.txt") as f: lines = f.read().split("\n\n")
lines = [i.split("\n") for i in lines]
lines = [[[char for char in j] for j in i] for i in lines]
total = 0
for group in lines:
    for a in range(len(group)):
        foondit = False
        for b in range(len(group[a])):
            group[a][b] = '.' if group[a][b] == '#' else '#'
            foundit = False
            for i in range(1, len(group[0]), 1):
                width = min(i, len(group[0])-i)
                arr1 = [j[i-width:i] for j in group]
                arr2 = [j[i:i+width] for j in group]
                arr2 = [j[::-1] for j in arr2]
                match = True
                for k in range(len(arr1)):
                    for j in range(len(arr1[0])):
                        if arr1[k][j] != arr2[k][j]: match = False
                if match:
                    total += i
                    foundit, foondit = True, True
            for i in range(1, len(group), 1):
                height = min(i, len(group)-i)
                arr1 = group[i-height:i]
                arr2 = group[i:i+height]
                arr2 = arr2[::-1]
                match = True
                for k in range(len(arr1)):
                    for j in range(len(arr1[0])):
                        if arr1[k][j] != arr2[k][j]: match = False
                if match:
                    total += 100 * (i)
                    foundit, foondit = True, True
            group[a][b] = '.' if group[a][b] == '#' else '#'
            if foundit: break
        if foondit: break
print(total-2)