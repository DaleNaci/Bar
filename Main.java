import java.util.*;

class Main
{

	private static int ptr;
	private static byte memory[] = new byte[65536];

	private static void interpret(String s)
	{
		int c = 0;
		ptr = 0;
		String[] split = s.split("\\|");
		// for (int i=0;i<split.length;i++) {
		// 	System.out.println(split[i]);
		// }
		for (int i=0;i<split.length;i++) {
			switch(split[i]) {
				case "":  memory[ptr]++; break; // Works
				case " ": memory[ptr]--; break; // Works
				case "  ": // Works
					if (ptr == memory.length - 1)
						ptr = 0;
					else
						ptr++;
					break;
				case "   ": // Works
					if (ptr == 0)
						ptr = memory.length - 1;
					else
						ptr--;
					break;
				case "    ": // Works (MODIFIED)
					System.out.print((char)(memory[ptr]+65)); break;
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
			}
		}
	}

	public static void main(String[] args)
	{

		interpret("|  |||     |");
		System.out.println();

	}

}