# Stage 1/4: Convert decimals
## Description
In daily life, we mostly use the decimal numeral system, but still, there are many other ways to represent numbers. For example, when working with computers, you'll probably deal with binary, octal, and hexadecimal numbers. It's really nice to have a tool that can help you easily and correctly convert numbers from one system to another: in this project, we will build such a tool step-by-step.

In the first stage, you need to implement conversion from decimal to binary, octal, and hexadecimal. The program will read the user's decimal number and the user's target <a href="https://en.wikipedia.org/wiki/Radix">radix</a> (or base). Then, it will output the given number in the corresponding base.

Converting from decimal to octal and hexadecimal isn't much different from converting to binary. The algorithm is really similar to binary conversion, only the base number is different with 8 or 16 in place of 2. See some examples of converting the number 110 from decimal to octal and hexadecimal below:

| Quotient |	Remainder of 8 |
| -------- | ----------------- |
| 110 | 6 |
| 13 | 5 |
| 1 | 1 |

Result: <b>11010</b> = <b>1568</b>

| Quotient | Remainder of 16 |
| -------- | --------------- |
| 110 | 14 (E) |
| 6 | 6 |

Result: <b>11010</b> = <b>6E16</b>

<i>In this project, you need to understand and implement the conversion algorithm.</i>

## Objectives
Your program's output should consist of the following three lines:

1. On the first line, the prompt Enter number in decimal system: is shown, and the user inputs a decimal number to be converted.
2. On the second one, the prompt Enter target base: is printed, and the user enters the target base (2, 8, or 16).
3. On the third one, the message Conversion result: is printed, followed by the correct number representation in the given base.

## Example
The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

### Example 1:
```
Enter number in decimal system: > 8
Enter target base: > 16
Conversion result: 8
```

### Example 2:
```
Enter number in decimal system: > 101
Enter target base: > 2
Conversion result: 1100101
```

### Example 3:
```
Enter number in decimal system: > 103
Enter target base: > 8
Conversion result: 147
```
