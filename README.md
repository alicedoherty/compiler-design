# compiler-design
ToY Compiler Project for CSU33071
- [Alice Doherty](https://github.com/alicedoherty)
- [Aoife Khan](https://github.com/aoife-K)

## Running the Compiler
### Using Makefile
```
make test=testFileName
# e.g make test=TestCases/PassCases/accessingStruct

```

### Full Compilation Commands
```
jflex ToY.l
bison ToY.y -L java
javac *.java
java ToY < validParserTestCases
```

## Resources
### To Do
- [x] Lexical Analysis 20/02
- [x] Parser 20/03
- [x] Semantic Analysis 10/04
- [x] (Test Suite)

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
- [Compiler Construction using Flex and Bison](https://www.admb-project.org/tools/flex/compiler.pdf)

### Part 3: Semantic Analysis
- [Parser and AST Assignment](https://courses.cs.washington.edu/courses/csep501/14sp/project/parser-ast.html)
- [Reflex Bison AST](https://github.com/UO-cis561/reflex-bison-ast)
- [AST Assignment](https://people.cs.pitt.edu/~jmisurda/teaching/cs2210/2134/cs2210-2134-project2.htm)
- [Compiler Slides](http://web.cecs.pdx.edu/~harry/compilers/slides/)
- [Bison Printing Semantic Values](https://www.gnu.org/software/bison/manual/bison.html#Printer-Decl)
- [Flex Bison Book Examples](https://github.com/mbbill/flexbison/tree/master/flexbison)
- [Symbol Table Assignment](https://cs.gmu.edu/~dnord/cs440-540/cpaxi2.html)
- [Simple Java Compiler Example](https://github.com/hartikainen/simple-compiler/blob/master/SymbolTable.java)
- [Bison Parser Algorithm](http://web.mit.edu/gnu/doc/html/bison_8.html#SEC76)