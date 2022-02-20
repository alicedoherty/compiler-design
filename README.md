# compiler-design
ToY Compiler Project for CSU33071

- [ ] Lexer Analysis 20/02
- [ ] Parser 20/03
- [ ] Semantic Analysis 10/04
- [ ] (Test Suite)

## Resources
### Lexer Format
```
	User Code (helper functions, import, pretty prints, error messages)
%%
	Directive
%%
	Regex Expressions + Actions (list of regex and specify to flex what actions you're going to do if there's a match)
```

### Links
- [Flex Manual - Pattern Matching](https://westes.github.io/flex/manual/Patterns.html#Patterns)
- [Regex Testing](https://regex101.com/)
- [Lexical Analysis w/ JFlex](https://www.cs.auckland.ac.nz/courses/compsci330s1c/lectures/330ChaptersPDF/Chapt1.pdf)
- [JFlex Simple Example](https://jflex.de/manual.html#Example)

## Commands
### Package Dependencies
```
brew install flex
brew install jflex
brew install bison
```

### Running Lexer and Parser
#### Using Makefile

1. Run `make` to compile code

2. Run `make test` to run code with test files

3. To clean up compiled files run `make clean`