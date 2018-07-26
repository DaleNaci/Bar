import sys

def fileRead(filePath):
	f = open(filePath, 'r')
	with open(filePath) as f:
		read_data = f.read()
	f.close()
	return read_data

def stringSplit(s):
	splitReturn = []
	queue = ""
	for c in s:
		if c == " ":
			queue += " "
		elif c == "|":
			splitReturn.append(queue)
			queue = ""
	return splitReturn

def interpret(s):
	count = 0
	ptr = 0
	memory = [0]

	split = stringSplit(s)
	print(split)

	for i in range(0, 65536):
		memory.append(0)

	for i in range(0, len(split)):
		# print(str(i) + " ", end='')
		# print(len(split))
		# print("Ptr: ",end='')
		# print(ptr)
		command = split[i]
		if command == "":
			if ptr == len(memory):
				ptr = 0
			else:
				memory[ptr] = memory[ptr] + 1
		if command == " ":
			if ptr == 0:
				ptr = len(memory) - 1
			else:
				memory[ptr] = memory[ptr] - 1
		if command == "  ":
			ptr += 1
		if command == "   ":
			ptr -= 1
		if command == "    ":
			print (chr(memory[ptr]), end='')
		if command == "     ":
			if memory[ptr] == 0:
				i += 1
				while count > 0 or split[i] != "      ":
					if split[i] == "     ":
						count += 1
					elif split[i] == "      ":
						count -= 1
					i += 1
		if command == "      ":
			if memory[ptr] != 0:
				i -= 1
				while count > 0 or split[i] != "     ":
					if split[i] == "      ":
						count += 1
					elif split[i] == "     ":
						count -= 1
					i -= 12
		if command == "       ":
			print (memory[ptr], end='')


if __name__ == "__main__":
	for i in range(1,len(sys.argv)):
		interpret(fileRead(sys.argv[1]))
		print()
	print("End")