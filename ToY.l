import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Integer;

class Yytoken {
  public String type;
  public Object value;

  public Yytoken(String type) {
    this.type = type;
  }
  public Yytoken(String type, Object value) {
    this.type = type;
    this.value = value;
  }
}

%%

%unicode

%{
StringBuffer stringBuffer = new StringBuffer();

public static void main(String[] args) throws FileNotFoundException, IOException{
    FileReader yyin = new FileReader(args[0]);
    Yylex yy = new Yylex(yyin);
    Yytoken t;
    try {
      while ((t = yy.yylex()) != null) {
        System.out.println(t.type);
      }
      System.out.println("VALID");
    } catch (Error e) {
        System.out.println("ERROR");
    }
           
}
%}

Letter = [A-Za-z]
Digit = [0-9]
Identifier = ({Letter}|_)[{Letter}{Digit}_]*

Zero = 0
DecInt = [1-9][0-9]*

WhiteSpace     = {LineTerminator} | [ \t\f]

/* TODO removing/keeping whitespace at end {WhiteSpace}
  Will recognise 0123 as valid - two separate Integers */
Integer = [\-]?({Zero}|{DecInt})

Escape = \\[ntbrf\\\'\"]
StringCharacter = [^\"\\\n\r]+ | {Escape}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

%state STRING

%%
<YYINITIAL> {

/* reserved words */
"bool"                         { return new Yytoken("BOOL"); }
"int"                          { return new Yytoken("INT"); }
"true"                         { return new Yytoken("TRUE"); }
"false"                        { return new Yytoken("FALSE"); }
"void"                         { return new Yytoken("VOID"); }
"printf"                       { return new Yytoken("PRINTF"); }
"string"                       { return new Yytoken("STRING"); }
"struct"                       { return new Yytoken("STRUCT"); }
"if"                           { return new Yytoken("IF"); }
"then"                         { return new Yytoken("THEN"); }
"else"                         { return new Yytoken("ELSE"); }
"for"                          { return new Yytoken("FOR"); }
"return"                       { return new Yytoken("RETURN"); }

/* identifier <id> */
{Identifier}                   { return new Yytoken("IDENTIFIER"); }

/* integer literals */
{Integer}                      { String input = yytext();
                                 Integer inputInt = Integer.parseInt(input);
                                 if (inputInt < -32768 || inputInt > 32767) {
                                   throw new Error("Integer <"+yytext()+"> out of bounds");         
                                 } else {
                                   return new Yytoken("INTEGER_LITERAL");
                                 }
                               }

/* whitespace */
{WhiteSpace}                   { /* ignore */ }

/* operators */
"="                            { return new Yytoken("ASSIGN"); }
"-"                            { return new Yytoken("MINUS"); }
"*"                            { return new Yytoken("TIMES"); }
"/"                            { return new Yytoken("DIVIDE"); }
"mod"                          { return new Yytoken("MOD"); }
"and"                          { return new Yytoken("AND"); }
"or"                           { return new Yytoken("OR"); }
"not"                          { return new Yytoken("NOT"); }
"=="                           { return new Yytoken("EQ"); }
"<"                            { return new Yytoken("LT"); }
">"                            { return new Yytoken("GT"); }
"<="                           { return new Yytoken("LE"); }
">="                           { return new Yytoken("GE"); }
"!="                           { return new Yytoken("NE"); }

/* comments */
"//".*                         { }
"##".*                         { }

/* string literals */
\"{StringCharacter}\"          { return new Yytoken("STRING_LITERAL"); }

}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }
