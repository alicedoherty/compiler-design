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
%token ASSIGN
%token LEFTCURLY RIGHTCURLY SEMICOLON LEFT RIGHT
%token IDENTIFIER INTEGER_LITERAL STRING_LITERAL

/* These defintions declare the associativity as well as precedence from LOWEST to HIGHEST */
%left PERIOD
%left MOD AND OR
%nonassoc EQ LT GT LE GE NE
%left PLUS MINUS
%left TIMES DIVIDE

/* Need to be able to differentiate between unary minus and binary minus */
/* e.g add UMINUS token? */
%precedence NOT

/* To deal with shift/reduce conflict in IF/THEN statements */
/* The else branch belongs to the LAST if-statement (see p. 188 Intro to Flex and Bison) */
/* i.e read as: IF (cond) {IF (cond) stmt ELSE stmt} */
%nonassoc THEN
%nonassoc ELSE

%%  

pgm
    : proc pgm1
    | struct pgm 
;

pgm1
    : /* nothing */
    | proc pgm1
    | struct pgm1
;

/* Only struct identifiers count as a type - not all IDENTIFIERs */
type
    : INT 
    | BOOL 
    | STRING 
    | structId
;

/* Come back - identifiers of structs need to be treated different to other variable identifiers */
/* structId should be value of IDENTIFIER - but has extra check if it is a struct identifier */
structId
    : STRUCT IDENTIFIER         /*{ $$ = $2; }*/
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
    : /* nothing */
    | declaration
;

proc
    : returnType IDENTIFIER LEFT declaration1 RIGHT LEFTCURLY statement RIGHTCURLY
;

/* First statement inside for-construct is optional */
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
;

statementSeq
    : /* nothing */
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
    /*| exp op exp*/
    | MINUS exp 
    | calcExp
    | logicalExp
    | comparisonExp
    /*| NOT exp*/
    | lExp
    | LEFT exp RIGHT
;

/* Temporary - remove when calcExp, logicalExp, and comparisonExp are working */
/*op 
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
*/

calcExp
    : INTEGER_LITERAL
    | calcExp PLUS calcExp       /* { $$ = $1 + $3; } */
    | calcExp MINUS calcExp      /* { $$ = $1 - $3; } */
    | calcExp TIMES calcExp      /* { $$ = $1 * $3; } */
    | calcExp DIVIDE calcExp     /* { $$ = $1 / $3; } */
    | calcExp MOD calcExp        /* { $$ = $1 % $3; } */
;

/* Need to check it is a boolean expression */
logicalExp
    : exp AND exp        /*{ $$ = $1 && $3; }*/
    | exp OR exp         /*{ $$ = $1 || $3; }*/
    | NOT exp            /*{ $$ = ! $2; }*/

comparisonExp
    : exp EQ exp         /*{ $$ = $1 == $3; }*/
    | exp GT exp         /*{ $$ = $1 > $3; }*/
    | exp LT exp         /*{ $$ = $1 < $3; }*/
    | exp GE exp         /*{ $$ = $1 >= $3; }*/
    | exp LE exp         /*{ $$ = $1 <= $3; }*/
    | exp NE exp         /*{ $$ = $1 != $3; }*/

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