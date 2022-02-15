default:
	clear
	jflex ToY.l
	javac *.java
	java Yylex testCases

clean: 
	rm *.java *.class *.java\~