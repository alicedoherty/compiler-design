# compiler-design
ToY Compiler Project for CSU33071

- [ ] Lexer Analysis 20/02
- [ ] Parser 20/03
- [ ] Semantic Analysis 10/04
- [ ] (Test Suite)

## Commands
### Package Dependencies
```
brew install flex
brew install jflex
brew install bison
```

### Running Lexer and Parser
#### Using Makefile

Run `make`

To clean up compiled files run `make clean`


#### Long way (from project spec)

```
bison ToY.y -L java     \\ ignore for now, not yet implemented
jflex ToY.l
javac *.java
java -cp ToY $@         \\ $@ means all command-line arguments
                        \\ e.g run java -cp ToY sampleInput
```

## Lexer Format
```
	User Code (helper functions, import, pretty prints, error messages)
%%
	Directive
%%
	Regex Expressions + Actions (list of regex and specify to flex what actions you're going to do if there's a match)
```
