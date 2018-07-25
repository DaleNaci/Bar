import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class JavaInterpreter
{
	private static int ptr; // Data Pointer
	private static int count; // Counter for Loops
	private static byte memory[] = new byte[65536];

	private static String fileRead(String filePath) {
		String content = "";
		try {
			content = new String (Files.readAllBytes(Paths.get(filePath)));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	// Intepreter function with a string parameter
	private static void interpret(String s)
	{

		// Variable resets
		count = 0;
		ptr = 0;
		memory = new byte[memory.length];

		// Splitting string parameter by each instruction
		String[] split = s.split("\\|");

		// Loops through each instruction
		for (int i=0;i<split.length;i++) {
			switch(split[i]) {
				case "":  memory[ptr]++; break;
				case " ": memory[ptr]--; break;
				case "  ":
					if (ptr == memory.length - 1) 
						ptr = 0;
					else {
						ptr++;
					}
					break;
				case "   ":
					if (ptr == 0)
						ptr = memory.length - 1;
					else {
						ptr--;
					}
					break;
				case "    ":
					System.out.print((char)(memory[ptr])); break;
				case "     ":
					if (memory[ptr] == 0)
					{
						i++;
						while (count > 0 || !split[i].equals("      "))
						{
							if (split[i].equals("     "))
								count++;
							else if (split[i].equals("      "))
								count--;
							i++;
						}
					}
					break;
				case "      ":
					if (memory[ptr] != 0)
					{
						i--;
						while (count > 0 || !split[i].equals("     "))
						{
							if (split[i].equals("      "))
								count++;
							else if (split[i].equals("     "))
								count--;
							i--;
						}
						i--;
					}
					break;
				case "       ":
					System.out.print(memory[ptr]); break;
			}
		}
	}

	public static void main(String[] args)
	{
		for (int i=0;i<args.length;i++) {
			interpret(fileRead(args[i]));
			System.out.println();
		}
	}
}