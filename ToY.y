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
    /* Variables declared to keep track of parser's current values */
    public static SymbolTable symbolTable;
    public static SymbolTable.Variable var;

    public String returnType;
    public SymbolTable.Function func;
    public SymbolTable.Struct struct;

    /* Keeps tracks of current struct's fields */
    public ArrayList<SymbolTable.Variable> fieldList = new ArrayList<SymbolTable.Variable>();

    /* Keeps track of current function's parameters and local variables */
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

        //printSymbolTables();
	} 
    
    public static void initialise() {
        symbolTable = new SymbolTable();
        var = symbolTable.new Variable();
    }

    // Print function for debugging
    public static void printSymbolTables() {
        symbolTable.printFunctionTable();
        symbolTable.printStructTable();
    }
}

/* First token listed has lowest precedence */
%token BOOL INT TRUE FALSE VOID PRINTF STRING STRUCT IF THEN ELSE FOR RETURN
%token LEFTCURLY RIGHTCURLY SEMICOLON LEFT RIGHT
%token INTEGER_LITERAL STRING_LITERAL
%left IDENTIFIER
%token COMMA QUOTE

%left PERIOD
%left MOD AND OR

%nonassoc EQ LT GT LE GE NE ASSIGN
%left TIMES DIVIDE
/* Note: PLUS/MINUS have higher precedence than TIMES/DIVIDE (as outlined in spec) */
%left PLUS MINUS
%left NOT UMINUS

/* To deal with shift/reduce conflict in IF/THEN statements */
%nonassoc THEN
%nonassoc ELSE

%%  

pgm
    : proc pgm1     { if(!symbolTable.checkForMain()) { throw new Error("Program must have at least one procedure with the signature \"void main {...}\""); } }                      
    | struct pgm    { if(!symbolTable.checkForMain()) { throw new Error("Program must have at least one procedure with the signature \"void main {...}\""); } }                       
;

pgm1
    : /* nothing */
    | proc pgm1            
    | struct pgm1
;

type
    : INT           { $$ = $1; }               
    | BOOL          { $$ = $1; }   
    | STRING        { $$ = $1; }    
    | structName    { $$ = $1; }    
;

structName
    : IDENTIFIER    { if(!symbolTable.isStructDeclared($1.value)) { throw new Error("Variable " + $1.value + " is not declared"); }}

returnType
    : type     { returnType = $1.value; }     
    | VOID     { returnType = $1.value; }  
;

struct
    : STRUCT IDENTIFIER LEFTCURLY structDeclarationOnePlus RIGHTCURLY   {
                                                                            struct = symbolTable.new Struct();
                                                                            struct.name = $2.value; struct.fields = (ArrayList)fieldList.clone();
                                                                            symbolTable.structSymbolTable.put(struct.name, struct);
                                                                            fieldList.clear();
                                                                        }  
;

/* Structs need to have at least one declaration */
structDeclarationOnePlus
    : structDeclaration                                                                                                      
    | structDeclaration COMMA structDeclarationOnePlus    
;

structDeclaration
    : type IDENTIFIER   {   
                            if(symbolTable.isVariableDeclared($2.value, fieldList)) { throw new Error("Variable " + $2.value + " is already declared"); }
                            else { 
                                var = symbolTable.new Variable($2.value, $1.value); 
                                fieldList.add(var);                            
                            }
                        }
;

declaration
    : type IDENTIFIER   {   
                            if(symbolTable.isVariableDeclared($2.value, localVariableList)) {
                                throw new Error("Variable " + $2.value + " is already declared");
                            } 
                            else { 
                                var = symbolTable.new Variable($2.value, $1.value);
                                localVariableList.add(var);                          
                            }
                        }
;

declarationZeroPlus
    : /* nothing */
    | declaration                                                           
    | declaration COMMA declarationOnePlus                              
;

declarationOnePlus
    : declaration                                                                                                      
    | declaration COMMA declarationOnePlus    
;

proc
    : returnType IDENTIFIER LEFT declarationZeroPlus RIGHT LEFTCURLY statement RIGHTCURLY  { 
                                                                                                if(symbolTable.isFunctionDeclared($2.value)) { throw new Error("Cannot redeclare function with same name"); }
                                                                                                func = symbolTable.new Function();
                                                                                                func.name = $2.value; func.returnType = $1.value; 
                                                                                                func.localVariables = (ArrayList)localVariableList.clone();
                                                                                                symbolTable.functionSymbolTable.put(func.name, func);
                                                                                                localVariableList.clear();
                                                                                           }  
;

statement
    : FOR LEFT IDENTIFIER ASSIGN exp SEMICOLON exp SEMICOLON statement RIGHT statement { 
                                                                                            if(!$7.value.equals("BOOL")) { throw new Error("Second component in for loop is boolean expression"); }
                                                                                            if(!symbolTable.isVariableDeclared($3.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }
                                                                                        }
    | IF LEFT exp RIGHT THEN statement      {
                                                if(!$3.value.equals("BOOL")) {
                                                    throw new Error("Second component in for loop must be boolean expression");
                                                }
                                            }
    | IF LEFT exp RIGHT THEN statement ELSE statement   {
                                                            if(!$3.value.equals("BOOL")) {
                                                                throw new Error("Second component in for loop is boolean expression");
                                                            }
                                                        }
    | PRINTF LEFT STRING_LITERAL RIGHT SEMICOLON
    | RETURN exp SEMICOLON   { 
                                String varType;
                                varType = $2.value;
                                if(!returnType.equals(varType)) {
                                    throw new Error("Return type does not match function defintion");
                                }
                             }
    | LEFTCURLY statementSeq RIGHTCURLY
    | type IDENTIFIER SEMICOLON             {
                                                if(symbolTable.isVariableDeclared($2.value, localVariableList)) { throw new Error("Variable " + $2.value + " is already declared"); }
                                                else { 
                                                    var = symbolTable.new Variable($2.value, $1.value); 
                                                    localVariableList.add(var);
                                                }
                                            }
    /*| lExp ASSIGN exp SEMICOLON*/
    | IDENTIFIER ASSIGN exp SEMICOLON       { 
                                                if(!symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                                    throw new Error("Variable " + $1.value + " is not declared"); 
                                                }
                                                    
                                                String varType;
                                                String exprType;
                                                if(symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                                    varType = symbolTable.getVariableType($1.value, localVariableList);                                    
                                                    exprType = $3.value;
                                                    if(!exprType.equals(varType)) {
                                                        throw new Error("Assignment is not well-typed");
                                                    }  
                                                }
                                            }
    | IDENTIFIER PERIOD IDENTIFIER ASSIGN exp SEMICOLON     {
                                                                String varType;
                                                                /* Check if there is variable called IDENTIFIER in the function's scope */
                                                                if (symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                                                    /* Get type of the variable */
                                                                    varType = symbolTable.getVariableType($1.value, localVariableList);
                                                                    /* Look for struct of that type and if it exists, check it has that field */
                                                                    if (symbolTable.isStructDeclared(varType)) {
                                                                        if (!symbolTable.isStructField(varType, $3.value)) {
                                                                            throw new Error("Struct " + varType + " does not have field " + $3.value);
                                                                        }

                                                                        String structFieldType = symbolTable.getStructFieldType(varType, $3.value);

                                                                        if (!structFieldType.equals($5.value)) { 
                                                                            throw new Error ("Struct field type does not match assignment"); 
                                                                        }
                                                                    } else {
                                                                        throw new Error("Struct " + varType + " does not have field " + $3.value);
                                                                    }
                                                                }
                                                           }
    | IDENTIFIER LEFT exp RIGHT SEMICOLON       { if(!symbolTable.isFunctionDeclared($1.value)) { 
                                                        throw new Error("Function is not declared"); 
                                                    }
                                                }
    | IDENTIFIER LEFT RIGHT SEMICOLON           { if(!symbolTable.isFunctionDeclared($1.value)) { 
                                                        throw new Error("Function is not declared"); 
                                                    }
                                                }
    | IDENTIFIER ASSIGN IDENTIFIER LEFT RIGHT SEMICOLON { 
                                                            if(!symbolTable.isFunctionDeclared($3.value) ) { 
                                                                throw new Error("Function is not declared"); 
                                                            }
                                                            String funcReturnType = symbolTable.getFunctionReturnType($3.value);
                                                            String variableType = symbolTable.getVariableType($1.value, localVariableList);
                                                            if(!funcReturnType.equals(variableType)) {
                                                                throw new Error("Function return type does not match variable type"); 
                                                            }
                                                        }
    | IDENTIFIER ASSIGN IDENTIFIER LEFT exp RIGHT SEMICOLON { 
                                                                if(!symbolTable.isFunctionDeclared($3.value)) { 
                                                                        throw new Error("Function is not declared"); 
                                                                    }
                                                                String funcReturnType = symbolTable.getFunctionReturnType($3.value);
                                                                String variableType = symbolTable.getVariableType($1.value, localVariableList);
                                                                if(!funcReturnType.equals(variableType)) {
                                                                    throw new Error("Function return type does not match variable type"); 
                                                                }
                                                            }
;

statementSeq
    : /* nothing */
    | statement statementSeq
;

exp
    : INTEGER_LITERAL           { $$.value = "INT"; }
    | STRING_LITERAL            { $$.value = "STRING"; }
    | TRUE                      { $$.value = "BOOL"; }
    | FALSE                     { $$.value = "BOOL"; }
    | MINUS exp %prec UMINUS    { $$.value = "INT"; }
    | NOT exp                   { 
                                    if(!symbolTable.isCorrectType($2.value, "BOOL", "BOOL")) {
                                        throw new Error("Negation can only be done on BOOLs");
                                    }
                                    $$.value = "BOOL"; 
                                }
    /*| lExp */
    | IDENTIFIER                { 
                                    if(!symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                        throw new Error("Variable " + $1.value + " is not declared");
                                    }
                                    $$.value = symbolTable.getVariableType($1.value, localVariableList); 
                                }
    | IDENTIFIER PERIOD IDENTIFIER 
    | LEFT exp RIGHT            { $$.value = $2.value; }
    | exp PLUS exp      { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("Addition can only be done on INTs");
                            }
                        }          
    | exp MINUS exp     { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("Subtraction can only be done on INTs");
                            }
                        } 
    | exp TIMES exp     { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("Multiplication can only be done on INTs");
                            }
                        } 
    | exp DIVIDE exp    { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("Division can only be done on INTs");
                            }
                        }
    | exp MOD exp       { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("Mod can only be done on INTs");
                            }
                        }
    | exp AND exp       { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "BOOL")) {
                                throw new Error("And can only be done on BOOLs");
                            }
                            $$.value = "BOOL";
                        }    
    | exp OR exp        { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "BOOL")) {
                                throw new Error("Or can only be done on BOOLs");
                            }
                            $$.value = "BOOL";
                        } 
    | exp EQ exp        { 
                            /* == can be used on any type but it evaluates to a BOOL expression */
                            $$.value = "BOOL";
                        } 
    | exp GT exp        { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("> can only be done on INTs");
                            }
                            $$.value = "BOOL";
                        } 
    | exp LT exp        { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("< can only be done on INTs");
                            }
                            $$.value = "BOOL";
                            
                        } 
    | exp GE exp        { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error(">= can only be done on INTs");
                            }
                            $$.value = "BOOL";
                        } 
    | exp LE exp        { 
                            if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("<= can only be done on INTs");
                            }
                            $$.value = "BOOL";
                        } 
    | exp NE exp        { 
                            /* != can be used on any type but it evaluates to a BOOL expression */
                            $$.value = "BOOL";
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