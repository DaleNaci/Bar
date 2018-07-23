<h1>Bar</h1>
<p><b>Bar</b> is an <a href="https://en.wikipedia.org/wiki/Esoteric_programming_language">esoteric programming language</a>, or esolang for short. This esolang was created purely as a joke, and serves as an amusing way to create extremely inefficient code. Bar consists entirely of vertical bars and spaces.</p>

---

<h2>Basics</h2>
Bar uses memory manipulation through the utilization of an array of single-byte memory blocks.

```
|| (0) = Increases value stored in memory block by 1.
| | (1) = Decreases value stored in memory block by 1.
|  | (2) = Moves pointer to the right.
|   | (3) = Moves pointer to the left.
|    | (4) = Prints ASCII character of value stored in memory block.
|     | (5) = Beginning of a loop.
|      | (6) = End of a loop.
|       | (7) = Prints value stored in memory block.
```

<h3>Example Programs</h3>

```
Prints "Hello, World!"
 |     |||     |   |||  | |  ||||  ||||   |   |      | | | | |  ||
      |   |   |   |   |    |   |   |   |   | |    |   |    |    |
   |   ||    |   |   |   |   |    |  |  |    |  |  |  | |    |   |
    ||||    |  |  |    |  | |    |   |   |   |   |   ||    |
```

```
Addition (7+5)
|||||||  ||||||   |     | |  ||   |      |  |       |
```

---

<h2>Interpreter Usage</h2>
Bar currently has a Java intepreter which reads a separate text file. The Java interpreter has the ability to read multiple files at once through the main function arguments. This repository has two text files, code.txt and helloworld.txt. To determine the output of each file, use this command:

```
java JavaInterpreter code.txt helloworld.txt
```