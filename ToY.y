%language "Java"

%define api.prefix {ToY}
%define api.parser.class {ToY}
%define api.value.type {Yytoken}
%define api.parser.public
%define parse.error verbose

%code imports {
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.Reader;
    import java.io.StreamTokenizer;
    import java.util.HashMap;
    import ToY.SymbolTable;
}

%code {
    public static SymbolTable symbolTable;
    public static SymbolTable.Variable var;

    public SymbolTable.Function func;
    public SymbolTable.Struct struct;

    public ArrayList<SymbolTable.Variable> paramList = new ArrayList<SymbolTable.Variable>();
    public ArrayList<SymbolTable.Variable> fieldList = new ArrayList<SymbolTable.Variable>();
    public ArrayList<SymbolTable.Variable> localVariableList = new ArrayList<SymbolTable.Variable>();

	public static void main (String args[]) throws IOException {
        ToYLexer lexer = new ToYLexer(System.in);
        ToY parser = new ToY(lexer);

        initialise();

        try {
            if (parser.parse())
                System.out.println("VALID");
            else
                System.out.println("ERROR");
        } catch (Error e) {
            System.out.println("ERROR");
        }
        printSymbolTables();
	} 
    
    public static void initialise() {
        symbolTable = new SymbolTable();
        var = symbolTable.new Variable();
    }

    public static void printSymbolTables() {
        symbolTable.printFunctionTable();
        symbolTable.printStructTable();
        //symbolTable.printVariableTable();
    }
}

/* First token has lowest precedence */
%token BOOL INT TRUE FALSE VOID PRINTF STRING STRUCT IF THEN ELSE FOR RETURN
%token LEFTCURLY RIGHTCURLY SEMICOLON LEFT RIGHT
%token INTEGER_LITERAL STRING_LITERAL
%left IDENTIFIER
%token COMMA QUOTE

/* Need to be able to differentiate between unary minus and binary minus */
%left PERIOD
%left MOD AND OR

%nonassoc EQ LT GT LE GE NE ASSIGN
%left TIMES DIVIDE
%left PLUS MINUS
%left NOT UMINUS

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
    : INT           { $$ = $1; }               
    | BOOL          { $$ = $1; }   
    | STRING        { $$ = $1; }    
    | structName    { $$ = $1; }    
;

structName
    : IDENTIFIER    { if(!symbolTable.isStructDeclared($1.value)) { throw new Error("Variable " + $1.value + " is not declared"); }}

/* STRUCT is keyword for defining a struct */
/* STRUCT cannot be used as a return type - rather value of struct, e.g Car is the return type*/
returnType
    : type          
    | VOID            
;

/* Struct has at least one declaration */
struct
    : STRUCT IDENTIFIER LEFTCURLY structDeclarationOnePlus RIGHTCURLY   {
                                                                            struct = symbolTable.new Struct();
                                                                            struct.name = $2.value; struct.fields = (ArrayList)fieldList.clone();
                                                                            symbolTable.structSymbolTable.put(struct.name, struct);
                                                                            fieldList.clear();
                                                                        }  
;

declaration
    : type IDENTIFIER   {   
                            if(symbolTable.isVariableDeclared($2.value, localVariableList)) { throw new Error("Variable " + $2.value + " is already declared"); }
                            else { 
                                //var = symbolTable.createVariable($2.value, $1.value); 
                                //var.name = $2.value; var.type = $1.value;
                                var = symbolTable.new Variable($2.value, $1.value); 
                                //System.out.println(var);
                                paramList.add(var);                            
                            }
                        }
;

/* Check if both declarationZeroPlus and declarationOnePlus */
declarationZeroPlus
    : /* nothing */
    | declaration                                                           
    | declaration COMMA declarationOnePlus                              
;

declarationOnePlus
    : declaration                                                                                                      
    | declaration COMMA declarationOnePlus    
;

structDeclaration
    : type IDENTIFIER   {   
                            if(symbolTable.isVariableDeclared($2.value, localVariableList)) { throw new Error("Variable " + $2.value + " is already declared"); }
                            else { 
                                //var = symbolTable.createVariable($2.value, $1.value); 
                                var = symbolTable.new Variable($2.value, $1.value); 
                                //var.name = $2.value; var.type = $1.value;
                                //System.out.println(var);
                                fieldList.add(var);                            
                            }
                        }
;

/* Structs need to have at least one declaration */
structDeclarationOnePlus
    : structDeclaration                                                                                                      
    | structDeclaration COMMA structDeclarationOnePlus    
;

proc
    : returnType IDENTIFIER LEFT declarationZeroPlus RIGHT LEFTCURLY statement RIGHTCURLY  { 
                                                                                                func = symbolTable.new Function();
                                                                                                func.name = $2.value; func.returnType = $1.value; 
                                                                                                func.parameters = (ArrayList)paramList.clone(); func.localVariables = (ArrayList)localVariableList.clone();
                                                                                                symbolTable.functionSymbolTable.put(func.name, func);
                                                                                                paramList.clear();
                                                                                                localVariableList.clear();
                                                                                           }                                                                                          

/* First statement inside for-construct is optional */
/* IDENTIFIER in assignment needs to already be declared */
/* Variables declared inside compound/for/if statement cannot be used outside of it */

statement
    : FOR LEFT IDENTIFIER ASSIGN exp SEMICOLON exp SEMICOLON statement RIGHT statement { if(!symbolTable.isVariableDeclared($3.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }}
    | IF LEFT exp RIGHT THEN statement
    | IF LEFT exp RIGHT THEN statement ELSE statement
    | PRINTF LEFT STRING_LITERAL RIGHT SEMICOLON
    | RETURN exp SEMICOLON
    | LEFTCURLY statementSeq RIGHTCURLY
    | type IDENTIFIER SEMICOLON             {
                                                if(symbolTable.isVariableDeclared($2.value, localVariableList)) { throw new Error("Variable " + $2.value + " is already declared"); }
                                                    else { 
                                                        //var.name = $2.value; var.type = $1.value;
                                                        //var = symbolTable.createVariable($2.value, $1.value); 
                                                        var = symbolTable.new Variable($2.value, $1.value); 
                                                        localVariableList.add(var);
                                                        //System.out.println(var);
                                                    }
                                            }
    /* Update below - to work with lExp */ 
    | IDENTIFIER PERIOD IDENTIFIER ASSIGN exp SEMICOLON     {
                                                                System.out.println("test");
                                                                /* Check if there is variable called IDENTIFIER in the function */
                                                                if (symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                                                    
                                                                    /* Get type of the variable */
                                                                    String varType = symbolTable.getVariableType($1.value, localVariableList);
                                                                    System.out.println("test2");
                                                                    /* Look for struct of that type and if it exists, check it has field lExp */
                                                                    if (!symbolTable.isStructDeclared(varType)) {
                                                                        System.out.println("test3");
                                                                        if (!symbolTable.isStructField(varType, $3.value)) {
                                                                            throw new Error("Struct " + varType + " does not have field " + $3.value);
                                                                        }
                                                                    }
                                                                }
                                                           }
    /*| lExp ASSIGN exp SEMICOLON*/
    | IDENTIFIER ASSIGN exp SEMICOLON       { if(!symbolTable.isVariableDeclared($1.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }}
    /* Add check to see if variable has been declared */
    /* TODO Below exp - they should allow for 0 exp */
    | IDENTIFIER LEFT exp RIGHT SEMICOLON 
    | IDENTIFIER ASSIGN IDENTIFIER LEFT exp RIGHT SEMICOLON { if(!symbolTable.isVariableDeclared($1.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }}
;

statementSeq
    : /* nothing */
    | statement statementSeq
;

/* Define different expressions for type checking or delegate to type checker */
/* See if different rules are needed for calculation, logical, comparison expressions */
exp
    : INTEGER_LITERAL
    | STRING_LITERAL
    | TRUE
    | FALSE
    | MINUS exp %prec UMINUS 
    | NOT exp
    | lExp
    | LEFT exp RIGHT
    | exp PLUS exp          
    | exp MINUS exp
    | exp TIMES exp 
    | exp DIVIDE exp
    | exp MOD exp 
    | exp AND exp 
    | exp OR exp
    | exp EQ exp 
    | exp GT exp
    | exp LT exp
    | exp GE exp
    | exp LE exp
    | exp NE exp
;

/* lExp below never matches */
lExp
    : IDENTIFIER                { 
                                    $$ = $1;
                                    if(!symbolTable.isVariableDeclared($1.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }
                                }                   
    | IDENTIFIER PERIOD lExp    { 
                                    System.out.println("test");
                                    /* Check if there is variable called IDENTIFIER in the function */
                                    if (symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                        
                                        /* Get type of the variable */
                                        String varType = symbolTable.getVariableType($1.value, localVariableList);

                                        /* Look for struct of that type and if it exists, check it has field lExp */
                                        if (!symbolTable.isStructDeclared(varType)) {
                                            if (!symbolTable.isStructField(varType, $3.value)) {
                                                throw new Error("Struct " + varType + " does not have field " + $3.value);
                                            }
                                        }
                                    }
                                }
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
    public Yytoken getLVal() {
        return token;
    }

    Yytoken token;

    @Override
    public int yylex() throws IOException{
        token = yylex.yylex();
        return token.type;
    }
}