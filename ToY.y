%language "Java"

/* Definitions */
%define api.parser.class {ToYParser}
%define api.parser.public
%define parse.error verbose

/* Libraries to import */
%code imports {
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.Reader;
    import java.io.StreamTokenizer;
}

/* Main code */
%code {
	public static void main (String args[]) throws IOException {
        ToYLexer lexer = new ToYLexer(System.in);
        ToYParser parser = new ToYParser(lexer);
        if (!parser.parse())
            System.out.println("INVALID");
	} 
}

/* Bison declarations */
%token <Integer> NUM
%type <Integer> exp
%type <Integer> int
%type <Boolean> bool
%type <String> string
%type id
%type void
%token FOR IF ELSE THEN RETURN PRINTF NEG TRUE FALSE MOD AND OR


%%  

/* Grammar rules section */
input: line | input line;

line
    : '\n'
    | exp '\n'              { System.out.println($exp); }
    | error '\n'
    ;

//are intLiteral and stringLiteral types to be declared? 
exp
    : NUM                   { $$ = $1; }
    | exp '=' exp           { if ($1.intValue() != $3.intValue()) yyerror("calc: error: " + $1 + " != " + $3); }
    | exp '+' exp           { $$ = $1 + $3; }
    | exp '-' exp           { $$ = $1 - $3; }
    | exp '*' exp           { $$ = $1 * $3; }
    | exp '/' exp           { $$ = $1 / $3; }
    | '-' exp %prec NEG     { $$ = -$2; }
    | exp '^' exp           { $$ = (int) Math.pow($1, $3); }
    | '(' exp ')'           { $$ = $2; }
    | '(' error ')'         { $$ = 1111; }
    | '!'                   { $$ = 0; return YYERROR; }
    | '-' error             { $$ = 0; return YYERROR; }
    | intLiteral
    | stringLiteral
    | TRUE
    | FALSE
    | exp op exp 
    | '-' exp 
    | '!' exp 
    | lExp
    | '(exp)'
    ;

type : int | bool | string | id;

returnType : type | void;

struct : struct id          { < declaration >, < declaration > ,... };

declaration : type id;

proc : returnType id '(' declaration ')' { < statement > };

//had to change stmt to statement and expr to exp, not sure if this is correct
//also removed the (,...) in places, idk if this will affect things
statement : FOR '('id '=' exp ; exp ; statement ')' statement
| IF '('exp')' THEN statement
| IF '('exp')' THEN statement ELSE statement
| PRINTF '('string')';
| RETURN exp;
| { statementSeq } 
| type id ; 
| lExp '=' exp ; 
| id '('exp ')'; 
| id '=' id '(' exp ')'; 


statementSeq :
| statement statementSeq
;


lExp : id | id '.' lExp 
;

pgm : proc pgm1
| struct pgm 
;

pgm1 :
| proc pgm1
| struct pgm1
;

//Combined this with previous declaration of exp
/* exp : intLiteral
| stringLiteral
| true
| false
| exp op exp 
| '-' exp 
| '!' exp 
| lExp
| '(exp)'
; */

//Are these operators meant to be in quotation marks?
op : '+' | '-'| '*'| '/' | MOD | AND | OR | '==' | '>' | '<' | '>=' | '<='| '!='
;

%%

/* Additional Java code */
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

    ParserToken yylval;
    @Override
    public Object getLVal() {
        /* Returns the semantic value of the last token that yylex returned. */
        return yylval;
    }

    @Override
    public int yylex () throws IOException{
        /* Returns the next token. Here we get the next Token from the Lexer. */
        return yylex.yylex();
    }
}