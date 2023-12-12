from itertools import product

def getGroups(s):
    ret = []
    currtotal = 0
    for char in s:
        if char == '#':
            currtotal+=1
        elif currtotal != 0:
            ret.append(currtotal)
            currtotal = 0
    if currtotal != 0: ret.append(currtotal)
    return ret

def generate_strings(input_string):
    num_question_marks = input_string.count('?')
    replacements = product(['.', '#'], repeat=num_question_marks)
    result_strings = []
    for replacement in replacements:
        current_string = input_string
        for r in replacement:
            current_string = current_string.replace('?', r, 1)
        result_strings.append(current_string)
    return result_strings

with open("Day12Input.txt") as f: lines = f.read().split("\n")
nums = [line.split(" ")[1].split(",") for line in lines]
nums = [[int(j) for j in i] for i in nums]
lines = [line.split(" ")[0] for line in lines]
total = 0
for i, line in enumerate(lines):
    arr = generate_strings(line)
    for s in arr:
        num = getGroups(s)
        if num == nums[i]: total += 1
print(total)