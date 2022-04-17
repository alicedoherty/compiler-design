# To compile and run code:
# `make test=testFileName`
# e.g `make test=TestCases/PassCases/accessingStruct`

default:
	clear
	jflex ToY.l
	bison ToY.y -L java
	javac *.java
	java ToY < $(test)

clean:
	rm ToY.java *.class Yylex.java Yylex.java\~