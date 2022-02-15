default:
	clear
	jflex ToY.l
	javac *.java
	java Yylex sampleInput

clean: 
	rm *.java *.class *.java\~