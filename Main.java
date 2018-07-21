import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main
{
	private static int ptr;
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

	private static void interpret(String s)
	{
		int c = 0;
		ptr = 0;
		String[] split = s.split("\\|");

		for (int i=0;i<split.length;i++) {
			switch(split[i]) {
				case "":  memory[ptr]++; break;
				case " ": memory[ptr]--; break;
				case "  ":
					if (ptr == memory.length - 1)
						ptr = 0;
					else
						ptr++;
					break;
				case "   ":
					if (ptr == 0)
						ptr = memory.length - 1;
					else
						ptr--;
					break;
				case "    ":
					//System.out.print((char)(memory[ptr]+65)); break;
					System.out.print(memory[ptr]);break;
				case "     ":
					if (memory[ptr] == 0)
					{
						i++;
						while (c > 0 || split[i].equals("      "))
						{
							if (split[i].equals("     "))
								c++;
							else if (split[i].equals("      "))
								c--;
							i++;
						}
					}
					break;
				case "      ":
					if (memory[ptr] != 0)
					{
						i--;
						while (c > 0 || split[i].equals("     "))
						{
							if (split[i].equals("      "))
								c++;
							else if (split[i].equals("     "))
								c--;
							i--;
						}
						i--;
					}
					break;
				case "       ":
					System.out.println();
					System.out.println("Pointer: " + ptr);
					break;
			}
		}
	}

	public static void main(String[] args)
	{
		interpret(fileRead("code.txt"));
		System.out.println();
	}

}