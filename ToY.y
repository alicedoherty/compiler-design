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

pgm
    : proc pgm1
    | struct pgm 
;

pgm1
    :
    | proc pgm1
    | struct pgm1
;

/* Only struct identifiers count as a type - not all IDENTIFIERs */
type
    : INT 
    | BOOL 
    | STRING 
    /*| IDENTIFIER*/
;

returnType
    : type 
    | VOID
;

/* Struct has at least one declaration */
struct
    : STRUCT IDENTIFIER LEFTCURLY declaration RIGHTCURLY
;

/* Multiple declarations are comma separated */
/* Cannot have declarations with same identifier */
declaration
    : type IDENTIFIER
;

declaration1
    : 
    | declaration
;

proc
    : returnType IDENTIFIER LEFT declaration1 RIGHT LEFTCURLY statement RIGHTCURLY
;

/* had to change stmt to statement and expr to exp, not sure if this is correct
also removed the (,...) in places, idk if this will affect things */

/* First statement inside for-construct is optional */
/* Look at lecture/books for info about shift-reduce/reduce-reduce conflicts */
/* IDENTIFIER in assignment needs to already be declared */
/* Variables declared inside compound/for/if statement cannot be used outside of it */
statement
    : FOR LEFT IDENTIFIER ASSIGN exp SEMICOLON exp SEMICOLON statement RIGHT statement
    | IF LEFT exp RIGHT THEN statement
    | IF LEFT exp RIGHT THEN statement ELSE statement
    | PRINTF LEFT STRING_LITERAL RIGHT SEMICOLON
    | RETURN exp SEMICOLON
    | LEFTCURLY statementSeq RIGHTCURLY
    | type IDENTIFIER SEMICOLON 
    | lExp ASSIGN exp SEMICOLON
    | IDENTIFIER LEFT exp RIGHT SEMICOLON 
    | IDENTIFIER ASSIGN IDENTIFIER LEFT exp RIGHT SEMICOLON 

statementSeq
    :
    | statement statementSeq
;


lExp
    : IDENTIFIER
    | IDENTIFIER PERIOD lExp 
;

/* Define different expressions for type checking or delegate to type checker */
exp
    : INTEGER_LITERAL
    | STRING_LITERAL
    | TRUE
    | FALSE
    | exp op exp 
    | MINUS exp 
    | NOT exp 
    | lExp
    | LEFT exp RIGHT
;

/* Add precedence and associativity rules */
op 
    : PLUS
    | MINUS
    | TIMES
    | DIVIDE
    | MOD
    | AND
    | OR
    | EQ
    | GT
    | LT
    | GE
    | LE
    | NE
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