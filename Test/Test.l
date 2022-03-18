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

Letter = [A-Za-z]
Digit = [0-9]
Identifier = ({Letter}|_)[{Letter}{Digit}_]*

WhiteSpace     = {LineTerminator} | [ \t\f]
LineTerminator = \r|\n|\r\n

%%

<YYINITIAL> {

"int"                          { return TestLexer.INT; }
{Identifier}                   { return TestLexer.IDENTIFIER; }
";"                            { return TestLexer.SEMICOLON; }
{WhiteSpace}                   { /* ignore */ }

}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                yytext()+">"); }