import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Integer;

class Yytoken {
  public int type;
  public String value;

  public Yytoken(int type) {
    this.type = type;
  }
  public Yytoken(int type, String value) {
    this.type = type;
    this.value = value;
  }
}

%%

%unicode
%public
/*%standalone*/

/*
%{
StringBuffer stringBuffer = new StringBuffer();

public static void main(String[] args) throws FileNotFoundException, IOException{
    FileReader yyin = new FileReader(args[0]);
    Yylex yy = new Yylex(yyin);
    Yytoken t;
    try {
      while ((t = yy.yylex()) != null) {
        // System.out.println(t.type);
      }
      System.out.println("VALID");
    } catch (Error e) {
        System.out.println("ERROR");
    }
           
}
%}
*/

Letter = [A-Za-z]
Digit = [0-9]
/* "." can't be in identifier name - i.e can't have variable test.myVariable 
* because can be mistaken for struct variable
*/
Identifier = ({Letter}|_)[{Letter}{Digit}_]*

Zero = 0
DecInt = [1-9][0-9]*

/* TODO removing/keeping whitespace at end {WhiteSpace}
  Will recognise 0123 as valid - two separate Integers */
Integer = [\-]?({Zero}|{DecInt})

Escape = \\[ntbrf\\\'\"]
StringCharacter = [^\"\\\n\r]+

WhiteSpace     = {LineTerminator} | [ \t\f]
LineTerminator = \r|\n|\r\n

%%

<YYINITIAL> {

/* reserved words */
"bool"                         { return new Yytoken(ToYLexer.BOOL, "BOOL"); }
"int"                          { return new Yytoken(ToYLexer.INT); }
"true"                         { return new Yytoken(ToYLexer.TRUE); }
"false"                        { return new Yytoken(ToYLexer.FALSE); }
"void"                         { return new Yytoken(ToYLexer.VOID); }
"printf"                       { return new Yytoken(ToYLexer.PRINTF); }
"string"                       { return new Yytoken(ToYLexer.STRING, "STRING"); }
"struct"                       { return new Yytoken(ToYLexer.STRUCT, "STRUCT"); }
"if"                           { return new Yytoken(ToYLexer.IF); }
"then"                         { return new Yytoken(ToYLexer.THEN); }
"else"                         { return new Yytoken(ToYLexer.ELSE); }
"for"                          { return new Yytoken(ToYLexer.FOR); }
"return"                       { return new Yytoken(ToYLexer.RETURN); }

/* operators */
"+"                            { return new Yytoken(ToYLexer.PLUS); }
"-"                            { return new Yytoken(ToYLexer.MINUS); }
"*"                            { return new Yytoken(ToYLexer.TIMES); }
"/"                            { return new Yytoken(ToYLexer.DIVIDE); }
"mod"                          { return new Yytoken(ToYLexer.MOD); }
"and"                          { return new Yytoken(ToYLexer.AND); }
"or"                           { return new Yytoken(ToYLexer.OR); }
/* ! at top of projetc spec but 'not' later */
"!"                            { return new Yytoken(ToYLexer.NOT); }
"=="                           { return new Yytoken(ToYLexer.EQ); }
"<"                            { return new Yytoken(ToYLexer.LT); }
">"                            { return new Yytoken(ToYLexer.GT); }
"<="                           { return new Yytoken(ToYLexer.LE); }
">="                           { return new Yytoken(ToYLexer.GE); }
"!="                           { return new Yytoken(ToYLexer.NE); }
"="                            { return new Yytoken(ToYLexer.ASSIGN); }

/* symbols */
"{"                            { return new Yytoken(ToYLexer.LEFTCURLY); }
"}"                            { return new Yytoken(ToYLexer.RIGHTCURLY); }
";"                            { return new Yytoken(ToYLexer.SEMICOLON); }
"("                            { return new Yytoken(ToYLexer.LEFT); }
")"                            { return new Yytoken(ToYLexer.RIGHT); }
"."                            { return new Yytoken(ToYLexer.PERIOD); }
","                            { return new Yytoken(ToYLexer.COMMA); }
"\""                           { return new Yytoken(ToYLexer.QUOTE); }

/* comments */
"//".*                        { }
"##".*                        { }

/* whitespace */
{WhiteSpace}                   { }

/* identifier <id> */
{Identifier}                   { return new Yytoken(ToYLexer.IDENTIFIER, yytext()); }

/* integer literals */
{Integer}                      { String input = yytext();
                                 Integer inputInt = Integer.parseInt(input);
                                 if (inputInt < -32768 || inputInt > 32767) {
                                   throw new Error("Integer <"+yytext()+"> out of bounds");         
                                 } else {
                                   return new Yytoken(ToYLexer.INTEGER_LITERAL);
                                 }
                               }

/* string literals */
\"{StringCharacter}\"          { return new Yytoken(ToYLexer.STRING_LITERAL, yytext()); }

}

<<EOF>>                        { return new Yytoken(ToYLexer.EOF); }

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }
