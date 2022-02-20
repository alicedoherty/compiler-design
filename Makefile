.SUFFIXES: .java .class
.java.class:
	javac $<

CLASSES = Yylex.java

TEST_FILES = testCases

default:
	clear
	jflex ToY.l
	javac *.java

test: $(CLASSES)
	set -e; \
	for file in $(TEST_FILES); do java Yylex $$file; done;

clean: 
	rm *.java *.class *.java\~