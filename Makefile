default:
	clear
	jflex ToY.l
	bison ToY.y -L java
	javac *.java
	
clean:
	rm ToY.java *.class Yylex.java Yylex.java\~