## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Algorithm in this article

- Find first occurrence of "ATG" and call its index startIndex
- Find the "TAA" starting from (startIndex + 3), call this result currIndex
- As long as
  + Check if (currIndex - startIndex) is a multiple of 3
    + If so, the text between startIndex and currIndex + 3 is your answer
    + If not, update currIndex to the index of the next "TAA,” starting from (curr Index + 1)

## Update Algorithm
**Method : findStopCodon (dnaStr, startIndex, stopCodon)**
- Find stopCodon starting from (startIndex + 3), call this result curr Index
- As long as curr Index is not equal to -1
  + Check if (curr Index - startIndex) is a multiple of 3
    + If so, curr Index is your answer
    + If not, update curr Index to the index of the next stopCodon, starting from (currIndex + 1)
- Your answer is dnaStr.length()

**Split into Two Problems (Abstract Out)**

- Find first occurrence of "ATG," call its index startIndex
- If startIndex is -1, then your answer is the empty string
- findStopCodon (dnaStr, startIndex, "TAA") and call the result TAAindex
- findStopCodon (dnaStr, startIndex, "TAG") and call the result TAGindex
- findStopCodon (dnaStr, startIndex, "TGA") and call the result TGAindex
- Take the smallest of taaIndex, tgaIndex, and tagIndex: call it min
- If minIndex is dnaStr.length(), your answer is the empty string
- Your answer is the text from startIndex to minIndex + 3

**Logical AND/OR**

- Compare taaIndex and tgaIndex, choose the smaller value, and store it in minIndex.
- Compare minIndex and tagIndex, choose the smaller value, and store it in minIndex.
- If minIndex is still -1, return an empty string as there is no valid gene.
- Otherwise, return the substring from StartIndex to minIndex + 3 as the valid gene.



