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
%public
%standalone

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
"bool"                         { return ToYLexer.BOOL; }
"int"                          { return ToYLexer.INT; }
"true"                         { return ToYLexer.TRUE; }
"false"                        { return ToYLexer.FALSE; }
"void"                         { return ToYLexer.VOID; }
"printf"                       { return ToYLexer.PRINTF; }
"string"                       { return ToYLexer.STRING; }
"struct"                       { return ToYLexer.STRUCT; }
"if"                           { return ToYLexer.IF; }
"then"                         { return ToYLexer.THEN; }
"else"                         { return ToYLexer.ELSE; }
"for"                          { return ToYLexer.FOR; }
"return"                       { return ToYLexer.RETURN; }

/* operators */
"+"                            { return ToYLexer.PLUS; }
"-"                            { return ToYLexer.MINUS; }
"*"                            { return ToYLexer.TIMES; }
"/"                            { return ToYLexer.DIVIDE; }
"mod"                          { return ToYLexer.MOD; }
"and"                          { return ToYLexer.AND; }
"or"                           { return ToYLexer.OR; }
/* ! at top of projetc spec but 'not' later */
"not"                          { return ToYLexer.NOT; }
"=="                           { return ToYLexer.EQ; }
"<"                            { return ToYLexer.LT; }
">"                            { return ToYLexer.GT; }
"<="                           { return ToYLexer.LE; }
">="                           { return ToYLexer.GE; }
"!="                           { return ToYLexer.NE; }
"="                            { return ToYLexer.ASSIGN; }

/* symbols */
"{"                            { return ToYLexer.LEFTCURLY; }
"}"                            { return ToYLexer.RIGHTCURLY; }
";"                            { return ToYLexer.SEMICOLON; }
"("                            { return ToYLexer.LEFT; }
")"                            { return ToYLexer.RIGHT; }
"."                            { return ToYLexer.PERIOD; }

/* comments */
"//".*                         { }
"##".*                         { }

/* whitespace */
{WhiteSpace}                   { }

/* identifier <id> */
{Identifier}                   { return ToYLexer.IDENTIFIER; }

/* integer literals */
{Integer}                      { String input = yytext();
                                 Integer inputInt = Integer.parseInt(input);
                                 if (inputInt < -32768 || inputInt > 32767) {
                                   throw new Error("Integer <"+yytext()+"> out of bounds");         
                                 } else {
                                   return ToYLexer.INTEGER_LITERAL;
                                 }
                               }

/* string literals */
\"{StringCharacter}\"          { return ToYLexer.STRING_LITERAL; }

}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }
