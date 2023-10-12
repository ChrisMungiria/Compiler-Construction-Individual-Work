# Compiler Construction Asssignment for the days 09/10/2023 to 13/10/2023

This README is a guide on the code submitted in this repo. The questions are numbered with a reference to the code.

## Question 1

Using the file `CommentIdentifier.java`, I was able to come up with a solution for the question.

### Logic Used

Comments in code are usually declared at the beginning of the line, for example in Java, we start single line comments with `//` and multi-line comments with `/*` and end with `*/`. Therefore, if a string starts with either of them it must be a comment. \
**Lexical analysis** –lexical analysis is used to break down an input string into tokens, this was not done explicitly but was used to check what the beginning of a string contained.\
**Syntax analysis** – syntax analysis is the process of checking the order and structure of the tokens, this was also not used explicitly, but if a string begins with anything other than `//` or `/*`, then has it somewhere in the string, it more often than not results in an error, unless the string beginning with `//` or `/*` is on a separate line.

## Question 2

The file for this question is `IdentifierValidator.java`. There are comments highlighting a bried description of my thought process. \
**Rules for valid Identifiers in Java**

1. The only allowed characters for identifiers are all alphanumeric characters([A-Z],[a-z],[0-9]), ‘$‘(dollar sign) and ‘\_‘ (underscore). '#ChrisMungiria' is not a valid identifier as it has '#' symbol.
2. Identifiers should not start with digits([0-9]). '123Chris' is not a valid Java identifier.
3. Reserved Words can’t be used as an identifier, these include 'String', 'int', 'while' and more.

- Java identifiers are also case sensitive
  The flex file for this is in `IdentifierValidator.l`

## Question 3

The file for this question is in `LL1ParsingTable.java`. A simple hashmap was used to store the entries as key-value pairs and then print them into an LL(1) parsing LL1ParsingTable

## Question 4 (Optional Task)

### 1. Part (a)

The files for this task are in `calculator.l`and`calculator.y`

### 2. Part (b)

The file for this question is in `OperatorPrecedenceParser.java`.

[135925 Mungiria Christopher Thiru](https://github.com/ChrisMungiria/Compiler-Construction-Individual-Work)\
130905 Muchira Munene\
132686 Royne Thuo \
136245 Kariuki Edwin\
