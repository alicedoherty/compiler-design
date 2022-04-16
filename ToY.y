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

        // printSymbolTables();
	} 
    
    public static void initialise() {
        symbolTable = new SymbolTable();
        var = symbolTable.new Variable();
    }

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
    : proc pgm1                           
    | struct pgm 
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
                            if((symbolTable.isVariableDeclared($2.value, localVariableList)) || (symbolTable.isVariableDeclared($2.value, paramList))) { throw new Error("Variable " + $2.value + " is already declared"); }
                            else { 
                                var = symbolTable.new Variable($2.value, $1.value); 
                                paramList.add(var);                            
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
                                                                                                func = symbolTable.new Function();
                                                                                                func.name = $2.value; func.returnType = $1.value; 
                                                                                                //func.localVariables = (ArrayList)localVariableList.clone();
                                                                                                func.parameters = (ArrayList)paramList.clone(); func.localVariables = (ArrayList)localVariableList.clone();
                                                                                                symbolTable.functionSymbolTable.put(func.name, func);
                                                                                                paramList.clear();
                                                                                                localVariableList.clear();
                                                                                           }  
;

statement
    : FOR LEFT IDENTIFIER ASSIGN exp SEMICOLON exp SEMICOLON statement RIGHT statement { 
                                                                                            if(!$7.value.equals("BOOL")) { throw new Error("Second component in for loop is boolean expression"); }
                                                                                            if(!symbolTable.isVariableDeclared($3.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }
                                                                                        }
    | IF LEFT exp RIGHT THEN statement      {
                                                if(!$3.value.equals("BOOL")) {throw new Error("Second component in for loop is boolean expression");}
                                                /*if(!symbolTable.isVariableDeclared($3.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }*/
                                            }
    | IF LEFT exp RIGHT THEN statement ELSE statement   {
                                                            if(!$3.value.equals("BOOL")) {throw new Error("Second component in for loop is boolean expression");}
                                                            /*if(!symbolTable.isVariableDeclared($3.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }*/
                                                        }
    | PRINTF LEFT STRING_LITERAL RIGHT SEMICOLON
    | RETURN exp SEMICOLON   { 
                                String varType;
                                /*
                                if($2.type == 278) {
                                    varType = symbolTable.getVariableType($2.value, localVariableList);   
                                } else {
                                    varType = $2.value;
                                }*/
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
                                                if((!symbolTable.isVariableDeclared($1.value, localVariableList)) && (!symbolTable.isVariableDeclared($1.value, paramList))) {
                                                    throw new Error("Variable " + $1.value + " is not declared"); 
                                                }
                                                String varType;
                                                String exprType;
                                                if(symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                                    varType = symbolTable.getVariableType($1.value, localVariableList);                                    
                                                    /*if($3.type == 278) {
                                                        System.out.println($3.value);
                                                        exprType = symbolTable.getVariableType($3.value, localVariableList);                                    
                                                    } else { 
                                                        exprType = $3.value;
                                                    }*/
                                                    exprType = $3.value;
                                                    if(!exprType.equals(varType)) {
                                                        throw new Error("Assignment is not well-typed");
                                                    }  
                                                } else if (symbolTable.isVariableDeclared($1.value, paramList)) {
                                                    varType = symbolTable.getVariableType($1.value, paramList);                                    
                                                    /*if($3.type == 278) {
                                                        exprType = symbolTable.getVariableType($3.value, paramList);                                    
                                                    } else { 
                                                        exprType = $3.value;
                                                    }*/
                                                    exprType = $3.value;
                                                    if(!exprType.equals(varType)) {
                                                        throw new Error("Assignment is not well-typed");
                                                    }  
                                                }
                                            }
    | IDENTIFIER PERIOD IDENTIFIER ASSIGN exp SEMICOLON     {
                                                                String varType;
                                                                /* Check if there is variable called IDENTIFIER in the function */
                                                                if (symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                                                    /* Get type of the variable */
                                                                    varType = symbolTable.getVariableType($1.value, localVariableList);
                                                                    /* Look for struct of that type and if it exists, check it has field lExp */
                                                                    if (symbolTable.isStructDeclared(varType)) {
                                                                        if (!symbolTable.isStructField(varType, $3.value)) {
                                                                            throw new Error("Struct " + varType + " does not have field " + $3.value);
                                                                        }
                                                                    } else {
                                                                        throw new Error("Struct " + varType + " does not have field " + $3.value);
                                                                    }
                                                                /* Check if there is variable called IDENTIFIER passed in as a parameter */
                                                                } else if (symbolTable.isVariableDeclared($1.value, paramList)) {
                                                                    varType = symbolTable.getVariableType($1.value, paramList);
                                                                    //Look for struct of that type and if it exists, check it has field lExp
                                                                    if (symbolTable.isStructDeclared(varType)) {
                                                                        if (!symbolTable.isStructField(varType, $3.value)) {
                                                                            throw new Error("Struct " + varType + " does not have field " + $3.value);
                                                                        }
                                                                    } else {
                                                                        throw new Error("Struct " + varType + " does not have field " + $3.value);
                                                                    }
                                                                }
                                                           }
    /* TODO Below exp - they should allow for 0 exp */
    | IDENTIFIER LEFT exp RIGHT SEMICOLON 
    | IDENTIFIER ASSIGN IDENTIFIER LEFT exp RIGHT SEMICOLON // Needs to be changed for function instead
                                                            { if((!symbolTable.isVariableDeclared($1.value, localVariableList)) && (!symbolTable.isVariableDeclared($1.value, paramList))) 
                                                                { 
                                                                    throw new Error("Variable " + $1.value + " is not declared"); 
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
                                    if((!symbolTable.isVariableDeclared($1.value, localVariableList)) && (!symbolTable.isVariableDeclared($1.value, paramList))) 
                                        { throw new Error("Variable " + $1.value + " is not declared"); }
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
                            /*if(!symbolTable.isCorrectType($1.value, $3.value, "BOOL")) {
                                throw new Error("Equals can only be done on BOOLs");
                            }*/
                            /* != can be used on any type */
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
                            /*if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("!= can only be done on INTs");
                            }*/
                            /* != can be used on any type */
                            $$.value = "BOOL";
                        } 
;

/* lExp below never matches */
/*
lExp
    : IDENTIFIER                { 
                                    if(!symbolTable.isVariableDeclared($1.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }
                                }                   
    | IDENTIFIER PERIOD lExp    { 
                                    // Check if there is variable called IDENTIFIER in the function
                                    if (symbolTable.isVariableDeclared($1.value, localVariableList)) {
                                        
                                        // Get type of the variable
                                        String varType = symbolTable.getVariableType($1.value, localVariableList);

                                        // Look for struct of that type and if it exists, check it has field lExp
                                        if (!symbolTable.isStructDeclared(varType)) {
                                            if (!symbolTable.isStructField(varType, $3.value)) {
                                                throw new Error("Struct " + varType + " does not have field " + $3.value);
                                            }
                                        }
                                    }
                                }
;
*/

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