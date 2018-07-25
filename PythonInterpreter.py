import sys

def fileRead(filePath):
	f = open(filePath, 'r')
	with open(filePath) as f:
		read_data = f.read()
	f.close()
	return read_data

def stringSplit(s):
	split = []
	for c in s:


def interpret(s):
	count = 0
	ptr = 0
	memory = [0]

	#split = s.split("|")

	print (split)

	for i in range(0, len(split)):
		command = split[i]
		if command == "":
			memory[ptr] = memory[ptr] + 1

		if command == " ":
			memory[ptr] = memory[ptr] - 1

		if command == "  ":
			ptr += 1
			if ptr == len(memory): cells.append(0)

		if command == "   ":
			ptr -= 1

		if command == "    ":
			print (char(memory[ptr]), end='')

		if command == "     ":
			if memory[ptr] == 0:
				i += 1
				while count > 0 or command != "      ":
					if command == "     ":
						count += 1
					elif command == "      ":
						count -= 1
					i += 1
		if command == "      ":
			if memory[ptr] != 0:
				i -= 1
				while count > 0 or command != "     ":
					if command == "      ":
						count += 1
					elif command == "     ":
						count -= 1
					i -= 1

		if command == "       ":
			print (memory[ptr], end='')

if __name__ == "__main__":
	for i in range(1,len(sys.argv)):
		interpret(fileRead(sys.argv[i]))
		print()