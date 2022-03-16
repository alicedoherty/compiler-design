# compiler-design
ToY Compiler Project for CSU33071

- [x] Lexical Analysis 20/02
- [ ] Parser 20/03
- [ ] Semantic Analysis 10/04
- [ ] (Test Suite)

## Resources
### Package Dependencies
```
brew install flex
brew install jflex
brew install bison
```

### Part 1: Lexical Analysis
- [Flex Manual - Pattern Matching](https://westes.github.io/flex/manual/Patterns.html#Patterns)
- [Regex Testing](https://regex101.com/)
- [Lexical Analysis w/ JFlex](https://www.cs.auckland.ac.nz/courses/compsci330s1c/lectures/330ChaptersPDF/Chapt1.pdf)
- [JFlex Simple Example](https://jflex.de/manual.html#Example)

### Part 2: Parser
- [Intro to Flex and Bison (C++)](https://www.oreilly.com/library/view/flex-bison/9780596805418/ch01.html)
- [GitHub Bison Examples](https://github.com/valecor95/bison-flex-jflex-examples)
- [Bison Manual](https://www.gnu.org/software/bison/manual/bison.html#Java-Parsers)

## Commands
### Using Makefile

1. Run `make` to compile code

2. Run `make test` to run code with test files

3. To clean up compiled files run `make clean`

### Compilation Commands
```
jflex ToY.l
bison ToY.y -L java
javac *.java
java Yylex input-file
```