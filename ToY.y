%language "Java"

%define api.prefix {ToY}
%define api.parser.class {ToY}
%define api.parser.public
%define parse.error verbose

%code imports {
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.Reader;
    import java.io.StreamTokenizer;
}

%code {
	public static void main (String args[]) throws IOException {
        ToYLexer lexer = new ToYLexer(System.in);
        ToY parser = new ToY(lexer);
        if (parser.parse())
            System.out.println("VALID");
        else {
            System.out.println("ERROR");
        }
        return;
	} 
}

%token BOOL INT TRUE FALSE VOID PRINTF STRING STRUCT IF THEN ELSE FOR RETURN
%token PLUS MINUS TIMES DIVIDE MOD AND OR NOT EQ LT GT LE GE NE ASSIGN
%token LEFTCURLY RIGHTCURLY SEMICOLON LEFT RIGHT PERIOD
%token IDENTIFIER INTEGER_LITERAL STRING_LITERAL


%%  

assignment
    : INT IDENTIFIER SEMICOLON
;

type : INT | BOOL | STRING | IDENTIFIER;

returnType : type | VOID;

struct : struct IDENTIFIER          { < declaration >, < declaration > ,... };

declaration : type IDENTIFIER;

proc : returnType IDENTIFIER '(' declaration ')' { < statement > };

//had to change stmt to statement and expr to exp, not sure if this is correct
//also removed the (,...) in places, idk if this will affect things
statement : FOR '('IDENTIFIER '=' exp ; exp ; statement ')' statement
| IF '('exp')' THEN statement
| IF '('exp')' THEN statement ELSE statement
| PRINTF '('STRING')';
| RETURN exp;
| { statementSeq } 
| type IDENTIFIER ; 
| lExp '=' exp ; 
| IDENTIFIER '('exp ')'; 
| IDENTIFIER '=' IDENTIFIER '(' exp ')'; 


statementSeq :
| statement statementSeq
;


lExp : IDENTIFIER | IDENTIFIER '.' lExp 
;

pgm : proc pgm1
| struct pgm 
;

pgm1 :
| proc pgm1
| struct pgm1
;

exp : INTEGER_LITERAL
| STRING_LITERAL
| TRUE
| FALSE
| exp op exp 
| '-' exp 
| '!' exp 
| lExp
| '(exp)'
;

op : PLUS | MINUS| TIMES| DIVIDE | MOD | AND | OR | EQ | GT | LT | GE | LE| NE
;

%%

class ToYLexer implements ToY.Lexer {
    InputStreamReader it;
    Yylex yylex;

    public ToYLexer(InputStream is) {
        it = new InputStreamReader(is);
        yylex = new Yylex(it);
    }

    @Override
    public void yyerror (String s) {
        System.err.println(s);
    }

    @Override
    public Object getLVal() {
        return null;
    }

    @Override
    public int yylex() throws IOException{
        return yylex.yylex();
    }
}