/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */




import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "ToY.y":9  */

    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.Reader;
    import java.io.StreamTokenizer;
    import java.util.HashMap;
    import ToY.SymbolTable;

/* "ToY.java":54  */

/**
 * A Bison parser, automatically generated from <tt>ToY.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class ToY
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";



  /**
   * True if verbose error messages are enabled.
   */
  private boolean yyErrorVerbose = true;

  /**
   * Whether verbose error messages are enabled.
   */
  public final boolean getErrorVerbose() { return yyErrorVerbose; }

  /**
   * Set the verbosity of error messages.
   * @param verbose True to request verbose error messages.
   */
  public final void setErrorVerbose(boolean verbose)
  { yyErrorVerbose = verbose; }




  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_BOOL(3),                     /* BOOL  */
    S_INT(4),                      /* INT  */
    S_TRUE(5),                     /* TRUE  */
    S_FALSE(6),                    /* FALSE  */
    S_VOID(7),                     /* VOID  */
    S_PRINTF(8),                   /* PRINTF  */
    S_STRING(9),                   /* STRING  */
    S_STRUCT(10),                  /* STRUCT  */
    S_IF(11),                      /* IF  */
    S_THEN(12),                    /* THEN  */
    S_ELSE(13),                    /* ELSE  */
    S_FOR(14),                     /* FOR  */
    S_RETURN(15),                  /* RETURN  */
    S_LEFTCURLY(16),               /* LEFTCURLY  */
    S_RIGHTCURLY(17),              /* RIGHTCURLY  */
    S_SEMICOLON(18),               /* SEMICOLON  */
    S_LEFT(19),                    /* LEFT  */
    S_RIGHT(20),                   /* RIGHT  */
    S_INTEGER_LITERAL(21),         /* INTEGER_LITERAL  */
    S_STRING_LITERAL(22),          /* STRING_LITERAL  */
    S_IDENTIFIER(23),              /* IDENTIFIER  */
    S_COMMA(24),                   /* COMMA  */
    S_QUOTE(25),                   /* QUOTE  */
    S_PERIOD(26),                  /* PERIOD  */
    S_MOD(27),                     /* MOD  */
    S_AND(28),                     /* AND  */
    S_OR(29),                      /* OR  */
    S_EQ(30),                      /* EQ  */
    S_LT(31),                      /* LT  */
    S_GT(32),                      /* GT  */
    S_LE(33),                      /* LE  */
    S_GE(34),                      /* GE  */
    S_NE(35),                      /* NE  */
    S_ASSIGN(36),                  /* ASSIGN  */
    S_TIMES(37),                   /* TIMES  */
    S_DIVIDE(38),                  /* DIVIDE  */
    S_PLUS(39),                    /* PLUS  */
    S_MINUS(40),                   /* MINUS  */
    S_NOT(41),                     /* NOT  */
    S_UMINUS(42),                  /* UMINUS  */
    S_YYACCEPT(43),                /* $accept  */
    S_pgm(44),                     /* pgm  */
    S_pgm1(45),                    /* pgm1  */
    S_type(46),                    /* type  */
    S_structName(47),              /* structName  */
    S_returnType(48),              /* returnType  */
    S_struct(49),                  /* struct  */
    S_structDeclarationOnePlus(50), /* structDeclarationOnePlus  */
    S_structDeclaration(51),       /* structDeclaration  */
    S_declaration(52),             /* declaration  */
    S_declarationZeroPlus(53),     /* declarationZeroPlus  */
    S_declarationOnePlus(54),      /* declarationOnePlus  */
    S_proc(55),                    /* proc  */
    S_statement(56),               /* statement  */
    S_statementSeq(57),            /* statementSeq  */
    S_exp(58);                     /* exp  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_BOOL,
      SymbolKind.S_INT,
      SymbolKind.S_TRUE,
      SymbolKind.S_FALSE,
      SymbolKind.S_VOID,
      SymbolKind.S_PRINTF,
      SymbolKind.S_STRING,
      SymbolKind.S_STRUCT,
      SymbolKind.S_IF,
      SymbolKind.S_THEN,
      SymbolKind.S_ELSE,
      SymbolKind.S_FOR,
      SymbolKind.S_RETURN,
      SymbolKind.S_LEFTCURLY,
      SymbolKind.S_RIGHTCURLY,
      SymbolKind.S_SEMICOLON,
      SymbolKind.S_LEFT,
      SymbolKind.S_RIGHT,
      SymbolKind.S_INTEGER_LITERAL,
      SymbolKind.S_STRING_LITERAL,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_COMMA,
      SymbolKind.S_QUOTE,
      SymbolKind.S_PERIOD,
      SymbolKind.S_MOD,
      SymbolKind.S_AND,
      SymbolKind.S_OR,
      SymbolKind.S_EQ,
      SymbolKind.S_LT,
      SymbolKind.S_GT,
      SymbolKind.S_LE,
      SymbolKind.S_GE,
      SymbolKind.S_NE,
      SymbolKind.S_ASSIGN,
      SymbolKind.S_TIMES,
      SymbolKind.S_DIVIDE,
      SymbolKind.S_PLUS,
      SymbolKind.S_MINUS,
      SymbolKind.S_NOT,
      SymbolKind.S_UMINUS,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_pgm,
      SymbolKind.S_pgm1,
      SymbolKind.S_type,
      SymbolKind.S_structName,
      SymbolKind.S_returnType,
      SymbolKind.S_struct,
      SymbolKind.S_structDeclarationOnePlus,
      SymbolKind.S_structDeclaration,
      SymbolKind.S_declaration,
      SymbolKind.S_declarationZeroPlus,
      SymbolKind.S_declarationOnePlus,
      SymbolKind.S_proc,
      SymbolKind.S_statement,
      SymbolKind.S_statementSeq,
      SymbolKind.S_exp
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "\"end of file\"", "error", "\"invalid token\"", "BOOL", "INT", "TRUE",
  "FALSE", "VOID", "PRINTF", "STRING", "STRUCT", "IF", "THEN", "ELSE",
  "FOR", "RETURN", "LEFTCURLY", "RIGHTCURLY", "SEMICOLON", "LEFT", "RIGHT",
  "INTEGER_LITERAL", "STRING_LITERAL", "IDENTIFIER", "COMMA", "QUOTE",
  "PERIOD", "MOD", "AND", "OR", "EQ", "LT", "GT", "LE", "GE", "NE",
  "ASSIGN", "TIMES", "DIVIDE", "PLUS", "MINUS", "NOT", "UMINUS", "$accept",
  "pgm", "pgm1", "type", "structName", "returnType", "struct",
  "structDeclarationOnePlus", "structDeclaration", "declaration",
  "declarationZeroPlus", "declarationOnePlus", "proc", "statement",
  "statementSeq", "exp", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>ToY</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token BOOL, to be returned by the scanner.  */
    static final int BOOL = 258;
    /** Token INT, to be returned by the scanner.  */
    static final int INT = 259;
    /** Token TRUE, to be returned by the scanner.  */
    static final int TRUE = 260;
    /** Token FALSE, to be returned by the scanner.  */
    static final int FALSE = 261;
    /** Token VOID, to be returned by the scanner.  */
    static final int VOID = 262;
    /** Token PRINTF, to be returned by the scanner.  */
    static final int PRINTF = 263;
    /** Token STRING, to be returned by the scanner.  */
    static final int STRING = 264;
    /** Token STRUCT, to be returned by the scanner.  */
    static final int STRUCT = 265;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 266;
    /** Token THEN, to be returned by the scanner.  */
    static final int THEN = 267;
    /** Token ELSE, to be returned by the scanner.  */
    static final int ELSE = 268;
    /** Token FOR, to be returned by the scanner.  */
    static final int FOR = 269;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 270;
    /** Token LEFTCURLY, to be returned by the scanner.  */
    static final int LEFTCURLY = 271;
    /** Token RIGHTCURLY, to be returned by the scanner.  */
    static final int RIGHTCURLY = 272;
    /** Token SEMICOLON, to be returned by the scanner.  */
    static final int SEMICOLON = 273;
    /** Token LEFT, to be returned by the scanner.  */
    static final int LEFT = 274;
    /** Token RIGHT, to be returned by the scanner.  */
    static final int RIGHT = 275;
    /** Token INTEGER_LITERAL, to be returned by the scanner.  */
    static final int INTEGER_LITERAL = 276;
    /** Token STRING_LITERAL, to be returned by the scanner.  */
    static final int STRING_LITERAL = 277;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 278;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 279;
    /** Token QUOTE, to be returned by the scanner.  */
    static final int QUOTE = 280;
    /** Token PERIOD, to be returned by the scanner.  */
    static final int PERIOD = 281;
    /** Token MOD, to be returned by the scanner.  */
    static final int MOD = 282;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 283;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 284;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 285;
    /** Token LT, to be returned by the scanner.  */
    static final int LT = 286;
    /** Token GT, to be returned by the scanner.  */
    static final int GT = 287;
    /** Token LE, to be returned by the scanner.  */
    static final int LE = 288;
    /** Token GE, to be returned by the scanner.  */
    static final int GE = 289;
    /** Token NE, to be returned by the scanner.  */
    static final int NE = 290;
    /** Token ASSIGN, to be returned by the scanner.  */
    static final int ASSIGN = 291;
    /** Token TIMES, to be returned by the scanner.  */
    static final int TIMES = 292;
    /** Token DIVIDE, to be returned by the scanner.  */
    static final int DIVIDE = 293;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 294;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 295;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 296;
    /** Token UMINUS, to be returned by the scanner.  */
    static final int UMINUS = 297;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Yytoken getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public ToY(Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private Yytoken[] valueStack = new Yytoken[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Yytoken value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Yytoken[] newValueStack = new Yytoken[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }

    public final Yytoken valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Yytoken yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 2: /* pgm: proc pgm1  */
  if (yyn == 2)
    /* "ToY.y":84  */
                    { if(!symbolTable.checkForMain()) { throw new Error("Program must have at least one procedure with the signature \"void main {...}\""); } };
  break;


  case 3: /* pgm: struct pgm  */
  if (yyn == 3)
    /* "ToY.y":85  */
                    { if(!symbolTable.checkForMain()) { throw new Error("Program must have at least one procedure with the signature \"void main {...}\""); } };
  break;


  case 7: /* type: INT  */
  if (yyn == 7)
    /* "ToY.y":95  */
                    { yyval = yystack.valueAt (0); };
  break;


  case 8: /* type: BOOL  */
  if (yyn == 8)
    /* "ToY.y":96  */
                    { yyval = yystack.valueAt (0); };
  break;


  case 9: /* type: STRING  */
  if (yyn == 9)
    /* "ToY.y":97  */
                    { yyval = yystack.valueAt (0); };
  break;


  case 10: /* type: structName  */
  if (yyn == 10)
    /* "ToY.y":98  */
                    { yyval = yystack.valueAt (0); };
  break;


  case 11: /* structName: IDENTIFIER  */
  if (yyn == 11)
    /* "ToY.y":102  */
                    { if(!symbolTable.isStructDeclared(yystack.valueAt (0).value)) { throw new Error("Variable " + yystack.valueAt (0).value + " is not declared"); }};
  break;


  case 12: /* returnType: type  */
  if (yyn == 12)
    /* "ToY.y":105  */
               { returnType = yystack.valueAt (0).value; };
  break;


  case 13: /* returnType: VOID  */
  if (yyn == 13)
    /* "ToY.y":106  */
               { returnType = yystack.valueAt (0).value; };
  break;


  case 14: /* struct: STRUCT IDENTIFIER LEFTCURLY structDeclarationOnePlus RIGHTCURLY  */
  if (yyn == 14)
    /* "ToY.y":110  */
                                                                        {
                                                                            struct = symbolTable.new Struct();
                                                                            struct.name = yystack.valueAt (3).value; struct.fields = (ArrayList)fieldList.clone();
                                                                            symbolTable.structSymbolTable.put(struct.name, struct);
                                                                            fieldList.clear();
                                                                        };
  break;


  case 17: /* structDeclaration: type IDENTIFIER  */
  if (yyn == 17)
    /* "ToY.y":125  */
                        {   
                            if(symbolTable.isVariableDeclared(yystack.valueAt (0).value, fieldList)) { throw new Error("Variable " + yystack.valueAt (0).value + " is already declared"); }
                            else { 
                                var = symbolTable.new Variable(yystack.valueAt (0).value, yystack.valueAt (1).value); 
                                fieldList.add(var);                            
                            }
                        };
  break;


  case 18: /* declaration: type IDENTIFIER  */
  if (yyn == 18)
    /* "ToY.y":135  */
                        {   
                            if((symbolTable.isVariableDeclared(yystack.valueAt (0).value, localVariableList)) || (symbolTable.isVariableDeclared(yystack.valueAt (0).value, paramList))) { throw new Error("Variable " + yystack.valueAt (0).value + " is already declared"); }
                            else { 
                                var = symbolTable.new Variable(yystack.valueAt (0).value, yystack.valueAt (1).value); 
                                paramList.add(var);                            
                            }
                        };
  break;


  case 24: /* proc: returnType IDENTIFIER LEFT declarationZeroPlus RIGHT LEFTCURLY statement RIGHTCURLY  */
  if (yyn == 24)
    /* "ToY.y":156  */
                                                                                           { 
                                                                                                if(symbolTable.isFunctionDeclared(yystack.valueAt (6).value)) { throw new Error("Cannot redeclare function with same name"); }
                                                                                                func = symbolTable.new Function();
                                                                                                func.name = yystack.valueAt (6).value; func.returnType = yystack.valueAt (7).value; 
                                                                                                //func.localVariables = (ArrayList)localVariableList.clone();
                                                                                                func.parameters = (ArrayList)paramList.clone(); func.localVariables = (ArrayList)localVariableList.clone();
                                                                                                symbolTable.functionSymbolTable.put(func.name, func);
                                                                                                paramList.clear();
                                                                                                localVariableList.clear();
                                                                                           };
  break;


  case 25: /* statement: FOR LEFT IDENTIFIER ASSIGN exp SEMICOLON exp SEMICOLON statement RIGHT statement  */
  if (yyn == 25)
    /* "ToY.y":169  */
                                                                                       { 
                                                                                            if(!yystack.valueAt (4).value.equals("BOOL")) { throw new Error("Second component in for loop is boolean expression"); }
                                                                                            if(!symbolTable.isVariableDeclared(yystack.valueAt (8).value, localVariableList)) { throw new Error("Variable " + yystack.valueAt (10).value + " is not declared"); }
                                                                                        };
  break;


  case 26: /* statement: IF LEFT exp RIGHT THEN statement  */
  if (yyn == 26)
    /* "ToY.y":173  */
                                            {
                                                if(!yystack.valueAt (3).value.equals("BOOL")) {throw new Error("Second component in for loop is boolean expression");}
                                                /*if(!symbolTable.isVariableDeclared($3.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }*/
                                            };
  break;


  case 27: /* statement: IF LEFT exp RIGHT THEN statement ELSE statement  */
  if (yyn == 27)
    /* "ToY.y":177  */
                                                        {
                                                            if(!yystack.valueAt (5).value.equals("BOOL")) {throw new Error("Second component in for loop is boolean expression");}
                                                            /*if(!symbolTable.isVariableDeclared($3.value, localVariableList)) { throw new Error("Variable " + $1.value + " is not declared"); }*/
                                                        };
  break;


  case 29: /* statement: RETURN exp SEMICOLON  */
  if (yyn == 29)
    /* "ToY.y":182  */
                             { 
                                String varType;
                                /*
                                if($2.type == 278) {
                                    varType = symbolTable.getVariableType($2.value, localVariableList);   
                                } else {
                                    varType = $2.value;
                                }*/
                                varType = yystack.valueAt (1).value;
                                if(!returnType.equals(varType)) {
                                    throw new Error("Return type does not match function defintion");
                                }
                             };
  break;


  case 31: /* statement: type IDENTIFIER SEMICOLON  */
  if (yyn == 31)
    /* "ToY.y":196  */
                                            {
                                                if(symbolTable.isVariableDeclared(yystack.valueAt (1).value, localVariableList)) { throw new Error("Variable " + yystack.valueAt (1).value + " is already declared"); }
                                                else { 
                                                    var = symbolTable.new Variable(yystack.valueAt (1).value, yystack.valueAt (2).value); 
                                                    localVariableList.add(var);
                                                }
                                            };
  break;


  case 32: /* statement: IDENTIFIER ASSIGN exp SEMICOLON  */
  if (yyn == 32)
    /* "ToY.y":204  */
                                            { 
                                                if((!symbolTable.isVariableDeclared(yystack.valueAt (3).value, localVariableList)) && (!symbolTable.isVariableDeclared(yystack.valueAt (3).value, paramList))) {
                                                    throw new Error("Variable " + yystack.valueAt (3).value + " is not declared"); 
                                                }
                                                String varType;
                                                String exprType;
                                                if(symbolTable.isVariableDeclared(yystack.valueAt (3).value, localVariableList)) {
                                                    varType = symbolTable.getVariableType(yystack.valueAt (3).value, localVariableList);                                    
                                                    exprType = yystack.valueAt (1).value;
                                                    if(!exprType.equals(varType)) {
                                                        throw new Error("Assignment is not well-typed");
                                                    }  
                                                } else if (symbolTable.isVariableDeclared(yystack.valueAt (3).value, paramList)) {
                                                    varType = symbolTable.getVariableType(yystack.valueAt (3).value, paramList);                                    
                                                    exprType = yystack.valueAt (1).value;
                                                    if(!exprType.equals(varType)) {
                                                        throw new Error("Assignment is not well-typed");
                                                    }  
                                                }
                                            };
  break;


  case 33: /* statement: IDENTIFIER PERIOD IDENTIFIER ASSIGN exp SEMICOLON  */
  if (yyn == 33)
    /* "ToY.y":224  */
                                                            {
                                                                String varType;
                                                                /* Check if there is variable called IDENTIFIER in the function */
                                                                if (symbolTable.isVariableDeclared(yystack.valueAt (5).value, localVariableList)) {
                                                                    /* Get type of the variable */
                                                                    varType = symbolTable.getVariableType(yystack.valueAt (5).value, localVariableList);
                                                                    /* Look for struct of that type and if it exists, check it has field lExp */
                                                                    if (symbolTable.isStructDeclared(varType)) {
                                                                        if (!symbolTable.isStructField(varType, yystack.valueAt (3).value)) {
                                                                            throw new Error("Struct " + varType + " does not have field " + yystack.valueAt (3).value);
                                                                        }
                                                                    } else {
                                                                        throw new Error("Struct " + varType + " does not have field " + yystack.valueAt (3).value);
                                                                    }
                                                                /* Check if there is variable called IDENTIFIER passed in as a parameter */
                                                                } else if (symbolTable.isVariableDeclared(yystack.valueAt (5).value, paramList)) {
                                                                    varType = symbolTable.getVariableType(yystack.valueAt (5).value, paramList);
                                                                    //Look for struct of that type and if it exists, check it has field lExp
                                                                    if (symbolTable.isStructDeclared(varType)) {
                                                                        if (!symbolTable.isStructField(varType, yystack.valueAt (3).value)) {
                                                                            throw new Error("Struct " + varType + " does not have field " + yystack.valueAt (3).value);
                                                                        }
                                                                    } else {
                                                                        throw new Error("Struct " + varType + " does not have field " + yystack.valueAt (3).value);
                                                                    }
                                                                }
                                                           };
  break;


  case 34: /* statement: IDENTIFIER LEFT exp RIGHT SEMICOLON  */
  if (yyn == 34)
    /* "ToY.y":251  */
                                                { if(!symbolTable.isFunctionDeclared(yystack.valueAt (4).value) ) 
                                                    { 
                                                        throw new Error("Function is not declared"); 
                                                    }
                                                };
  break;


  case 35: /* statement: IDENTIFIER LEFT RIGHT SEMICOLON  */
  if (yyn == 35)
    /* "ToY.y":256  */
                                                { if(!symbolTable.isFunctionDeclared(yystack.valueAt (3).value) ) 
                                                    { 
                                                        throw new Error("Function is not declared"); 
                                                    }
                                                };
  break;


  case 36: /* statement: IDENTIFIER ASSIGN IDENTIFIER LEFT RIGHT SEMICOLON  */
  if (yyn == 36)
    /* "ToY.y":261  */
                                                        { 
                                                            if(!symbolTable.isFunctionDeclared(yystack.valueAt (3).value) ) { 
                                                                throw new Error("Function is not declared"); 
                                                            }
                                                            String funcReturnType = symbolTable.getFunctionReturnType(yystack.valueAt (3).value);
                                                            String variableType = symbolTable.getVariableType(yystack.valueAt (5).value, localVariableList);
                                                            if(!funcReturnType.equals(variableType)) {
                                                                throw new Error("Function return type does not match variable type"); 
                                                            }
                                                        };
  break;


  case 37: /* statement: IDENTIFIER ASSIGN IDENTIFIER LEFT exp RIGHT SEMICOLON  */
  if (yyn == 37)
    /* "ToY.y":271  */
                                                            { 
                                                                if(!symbolTable.isFunctionDeclared(yystack.valueAt (4).value) ) 
                                                                    { 
                                                                        throw new Error("Function is not declared"); 
                                                                    }
                                                                String funcReturnType = symbolTable.getFunctionReturnType(yystack.valueAt (4).value);
                                                                String variableType = symbolTable.getVariableType(yystack.valueAt (6).value, localVariableList);
                                                                if(!funcReturnType.equals(variableType)) {
                                                                    throw new Error("Function return type does not match variable type"); 
                                                                }
                                                            };
  break;


  case 40: /* exp: INTEGER_LITERAL  */
  if (yyn == 40)
    /* "ToY.y":290  */
                                { yyval.value = "INT"; };
  break;


  case 41: /* exp: STRING_LITERAL  */
  if (yyn == 41)
    /* "ToY.y":291  */
                                { yyval.value = "STRING"; };
  break;


  case 42: /* exp: TRUE  */
  if (yyn == 42)
    /* "ToY.y":292  */
                                { yyval.value = "BOOL"; };
  break;


  case 43: /* exp: FALSE  */
  if (yyn == 43)
    /* "ToY.y":293  */
                                { yyval.value = "BOOL"; };
  break;


  case 44: /* exp: MINUS exp  */
  if (yyn == 44)
    /* "ToY.y":294  */
                                { yyval.value = "INT"; };
  break;


  case 45: /* exp: NOT exp  */
  if (yyn == 45)
    /* "ToY.y":295  */
                                { 
                                    if(!symbolTable.isCorrectType(yystack.valueAt (0).value, "BOOL", "BOOL")) {
                                        throw new Error("Negation can only be done on BOOLs");
                                    }
                                    yyval.value = "BOOL"; 
                                };
  break;


  case 46: /* exp: IDENTIFIER  */
  if (yyn == 46)
    /* "ToY.y":302  */
                                { 
                                    if((!symbolTable.isVariableDeclared(yystack.valueAt (0).value, localVariableList)) && (!symbolTable.isVariableDeclared(yystack.valueAt (0).value, paramList))) 
                                        { throw new Error("Variable " + yystack.valueAt (0).value + " is not declared"); }
                                    yyval.value = symbolTable.getVariableType(yystack.valueAt (0).value, localVariableList); 
                                };
  break;


  case 48: /* exp: LEFT exp RIGHT  */
  if (yyn == 48)
    /* "ToY.y":308  */
                                { yyval.value = yystack.valueAt (1).value; };
  break;


  case 49: /* exp: exp PLUS exp  */
  if (yyn == 49)
    /* "ToY.y":309  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("Addition can only be done on INTs");
                            }
                        };
  break;


  case 50: /* exp: exp MINUS exp  */
  if (yyn == 50)
    /* "ToY.y":314  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("Subtraction can only be done on INTs");
                            }
                        };
  break;


  case 51: /* exp: exp TIMES exp  */
  if (yyn == 51)
    /* "ToY.y":319  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("Multiplication can only be done on INTs");
                            }
                        };
  break;


  case 52: /* exp: exp DIVIDE exp  */
  if (yyn == 52)
    /* "ToY.y":324  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("Division can only be done on INTs");
                            }
                        };
  break;


  case 53: /* exp: exp MOD exp  */
  if (yyn == 53)
    /* "ToY.y":329  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("Mod can only be done on INTs");
                            }
                        };
  break;


  case 54: /* exp: exp AND exp  */
  if (yyn == 54)
    /* "ToY.y":334  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "BOOL")) {
                                throw new Error("And can only be done on BOOLs");
                            }
                            yyval.value = "BOOL";
                        };
  break;


  case 55: /* exp: exp OR exp  */
  if (yyn == 55)
    /* "ToY.y":340  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "BOOL")) {
                                throw new Error("Or can only be done on BOOLs");
                            }
                            yyval.value = "BOOL";
                        };
  break;


  case 56: /* exp: exp EQ exp  */
  if (yyn == 56)
    /* "ToY.y":346  */
                        { 
                            /*if(!symbolTable.isCorrectType($1.value, $3.value, "BOOL")) {
                                throw new Error("Equals can only be done on BOOLs");
                            }*/
                            /* != can be used on any type */
                            yyval.value = "BOOL";
                        };
  break;


  case 57: /* exp: exp GT exp  */
  if (yyn == 57)
    /* "ToY.y":353  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("> can only be done on INTs");
                            }
                            yyval.value = "BOOL";
                        };
  break;


  case 58: /* exp: exp LT exp  */
  if (yyn == 58)
    /* "ToY.y":359  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("< can only be done on INTs");
                            }
                            yyval.value = "BOOL";
                            
                        };
  break;


  case 59: /* exp: exp GE exp  */
  if (yyn == 59)
    /* "ToY.y":366  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error(">= can only be done on INTs");
                            }
                            yyval.value = "BOOL";
                        };
  break;


  case 60: /* exp: exp LE exp  */
  if (yyn == 60)
    /* "ToY.y":372  */
                        { 
                            if(!symbolTable.isCorrectType(yystack.valueAt (2).value, yystack.valueAt (0).value, "INT")) {
                                throw new Error("<= can only be done on INTs");
                            }
                            yyval.value = "BOOL";
                        };
  break;


  case 61: /* exp: exp NE exp  */
  if (yyn == 61)
    /* "ToY.y":378  */
                        { 
                            /*if(!symbolTable.isCorrectType($1.value, $3.value, "INT")) {
                                throw new Error("!= can only be done on INTs");
                            }*/
                            /* != can be used on any type */
                            yyval.value = "BOOL";
                        };
  break;



/* "ToY.java":1092  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    Yytoken yylval = null;



    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt(0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(ToY parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private ToY yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = ToY.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }




  private int yysyntaxErrorArguments(Context yyctx, SymbolKind[] yyarg, int yyargn) {
    /* There are many possibilities here to consider:
       - If this state is a consistent state with a default action,
         then the only way this function was invoked is if the
         default action is an error action.  In that case, don't
         check for expected tokens because there are none.
       - The only way there can be no lookahead present (in tok) is
         if this state is a consistent state with a default action.
         Thus, detecting the absence of a lookahead is sufficient to
         determine that there is no unexpected or expected token to
         report.  In that case, just report a simple "syntax error".
       - Don't assume there isn't a lookahead just because this
         state is a consistent state with a default action.  There
         might have been a previous inconsistent state, consistent
         state with a non-default action, or user semantic action
         that manipulated yychar.  (However, yychar is currently out
         of scope during semantic actions.)
       - Of course, the expected token list depends on states to
         have correct lookahead information, and it depends on the
         parser not to perform extra reductions after fetching a
         lookahead from the scanner and before detecting a syntax
         error.  Thus, state merging (from LALR or IELR) and default
         reductions corrupt the expected token list.  However, the
         list is correct for canonical LR with one exception: it
         will still contain any token that will not be accepted due
         to an error action in a later state.
    */
    int yycount = 0;
    if (yyctx.getToken() != null)
      {
        if (yyarg != null)
          yyarg[yycount] = yyctx.getToken();
        yycount += 1;
        yycount += yyctx.getExpectedTokens(yyarg, 1, yyargn);
      }
    return yycount;
  }


  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      if (yyErrorVerbose) {
          final int argmax = 5;
          SymbolKind[] yyarg = new SymbolKind[argmax];
          int yycount = yysyntaxErrorArguments(yyctx, yyarg, argmax);
          String[] yystr = new String[yycount];
          for (int yyi = 0; yyi < yycount; ++yyi) {
              yystr[yyi] = yyarg[yyi].getName();
          }
          String yyformat;
          switch (yycount) {
              default:
              case 0: yyformat = "syntax error"; break;
              case 1: yyformat = "syntax error, unexpected {0}"; break;
              case 2: yyformat = "syntax error, unexpected {0}, expecting {1}"; break;
              case 3: yyformat = "syntax error, unexpected {0}, expecting {1} or {2}"; break;
              case 4: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3}"; break;
              case 5: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3} or {4}"; break;
          }
          yyerror(new MessageFormat(yyformat).format(yystr));
      } else {
          yyerror("syntax error");
      }
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -51;
  private static final short yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     271,   -51,   -51,   -51,   -51,   -20,   -51,    12,   -51,   -51,
      -4,   271,   271,    10,   -51,    27,   -51,   -51,   271,   271,
      44,    44,   -51,   -51,    32,    39,    25,    34,    38,    45,
     -51,   -51,    44,   -51,    44,    47,   -51,    42,   -51,   268,
      44,    54,    58,    59,    70,   268,   -11,    41,    64,   -51,
      60,    70,    67,   -51,   -51,    70,   -51,   -51,    69,    70,
      70,    94,   268,    79,     1,    74,    96,    81,   -51,    83,
     182,    68,   198,    84,   -51,   -51,   -51,    70,    70,    70,
      70,    70,    70,    70,    70,    70,    70,    70,    70,    70,
     -51,   -51,    90,   214,    73,   -15,   112,   -51,    95,   102,
      70,   -51,   -51,   265,   265,   265,   276,   276,   276,   276,
     276,   276,   -22,   -22,   -51,   -51,   -51,    98,    70,    65,
     -51,   -51,   268,   130,   -51,   148,   117,   230,   107,    70,
     -51,   -51,   120,   268,   166,   -51,   -51,   268,   133,   268,
     -51
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,     8,     7,    13,     9,     0,    11,     0,    12,    10,
       0,     0,     4,     0,     1,     0,     3,     2,     4,     4,
       0,    19,     6,     5,     0,     0,    15,     0,    20,     0,
      17,    14,     0,    18,     0,     0,    16,    22,    21,     0,
       0,     0,     0,     0,     0,    38,    11,     0,     0,    23,
       0,     0,     0,    42,    43,     0,    40,    41,    46,     0,
       0,     0,    38,     0,     0,     0,     0,     0,    24,     0,
       0,     0,     0,     0,    44,    45,    29,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
      39,    30,     0,     0,     0,    46,     0,    31,     0,     0,
       0,    48,    47,    53,    54,    55,    56,    58,    57,    60,
      59,    61,    51,    52,    49,    50,    35,     0,     0,     0,
      32,    28,     0,     0,    34,     0,     0,     0,    26,     0,
      33,    36,     0,     0,     0,    37,    27,     0,     0,     0,
      25
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
     -51,   143,    26,    40,   -51,   -51,     2,   123,   -51,   135,
     -51,   131,    43,   -39,   110,   -50
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     7,    17,    47,     9,    10,    18,    25,    26,    37,
      29,    38,    19,    62,    63,    61
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short[] yytable_ = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      48,    70,    11,    13,   119,    72,    53,    54,    64,    74,
      75,    73,    14,    11,    93,    65,    96,    88,    89,    15,
      55,    92,    56,    57,    58,    66,    20,   103,   104,   105,
     106,   107,   108,   109,   110,   111,   112,   113,   114,   115,
       8,    59,    60,    12,    22,    23,    21,     1,     2,    32,
     123,     8,     8,     4,    12,    30,    31,    33,     8,     8,
      24,    27,    34,    39,    67,    35,    40,     6,   125,   127,
      53,    54,    24,    50,    27,    53,    54,    51,    52,   134,
      27,    68,    69,   128,    55,   126,    56,    57,    58,    55,
      71,    56,    57,    58,   136,    73,    91,    94,   138,    97,
     140,    53,    54,    98,   100,    59,    60,   102,   116,   118,
      59,    60,    76,   121,   122,    55,   124,    56,    57,    95,
     133,    77,    78,    79,    80,    81,    82,    83,    84,    85,
     120,    86,    87,    88,    89,   131,    59,    60,   135,    77,
      78,    79,    80,    81,    82,    83,    84,    85,   129,    86,
      87,    88,    89,   139,    16,    36,    28,    77,    78,    79,
      80,    81,    82,    83,    84,    85,   130,    86,    87,    88,
      89,    49,    90,     0,     0,    77,    78,    79,    80,    81,
      82,    83,    84,    85,   137,    86,    87,    88,    89,     0,
       0,     0,     0,    77,    78,    79,    80,    81,    82,    83,
      84,    85,    99,    86,    87,    88,    89,     0,     0,    77,
      78,    79,    80,    81,    82,    83,    84,    85,   101,    86,
      87,    88,    89,     0,     0,    77,    78,    79,    80,    81,
      82,    83,    84,    85,   117,    86,    87,    88,    89,     0,
       0,    77,    78,    79,    80,    81,    82,    83,    84,    85,
     132,    86,    87,    88,    89,     0,     0,    77,    78,    79,
      80,    81,    82,    83,    84,    85,     0,    86,    87,    88,
      89,     1,     2,     0,     1,     2,    41,     4,     3,    42,
       4,     5,    43,    44,    45,     0,     0,     0,     0,     0,
       0,    46,     0,     0,     6,    80,    81,    82,    83,    84,
      85,     0,    86,    87,    88,    89,    -1,    -1,    -1,    -1,
      -1,    -1,     0,    86,    87,    88,    89
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      39,    51,     0,    23,    19,    55,     5,     6,    19,    59,
      60,    26,     0,    11,    64,    26,    66,    39,    40,    23,
      19,    20,    21,    22,    23,    36,    16,    77,    78,    79,
      80,    81,    82,    83,    84,    85,    86,    87,    88,    89,
       0,    40,    41,     0,    18,    19,    19,     3,     4,    24,
     100,    11,    12,     9,    11,    23,    17,    23,    18,    19,
      20,    21,    24,    16,    23,    20,    24,    23,   118,   119,
       5,     6,    32,    19,    34,     5,     6,    19,    19,   129,
      40,    17,    22,   122,    19,    20,    21,    22,    23,    19,
      23,    21,    22,    23,   133,    26,    17,    23,   137,    18,
     139,     5,     6,    20,    36,    40,    41,    23,    18,    36,
      40,    41,    18,    18,    12,    19,    18,    21,    22,    23,
      13,    27,    28,    29,    30,    31,    32,    33,    34,    35,
      18,    37,    38,    39,    40,    18,    40,    41,    18,    27,
      28,    29,    30,    31,    32,    33,    34,    35,    18,    37,
      38,    39,    40,    20,    11,    32,    21,    27,    28,    29,
      30,    31,    32,    33,    34,    35,    18,    37,    38,    39,
      40,    40,    62,    -1,    -1,    27,    28,    29,    30,    31,
      32,    33,    34,    35,    18,    37,    38,    39,    40,    -1,
      -1,    -1,    -1,    27,    28,    29,    30,    31,    32,    33,
      34,    35,    20,    37,    38,    39,    40,    -1,    -1,    27,
      28,    29,    30,    31,    32,    33,    34,    35,    20,    37,
      38,    39,    40,    -1,    -1,    27,    28,    29,    30,    31,
      32,    33,    34,    35,    20,    37,    38,    39,    40,    -1,
      -1,    27,    28,    29,    30,    31,    32,    33,    34,    35,
      20,    37,    38,    39,    40,    -1,    -1,    27,    28,    29,
      30,    31,    32,    33,    34,    35,    -1,    37,    38,    39,
      40,     3,     4,    -1,     3,     4,     8,     9,     7,    11,
       9,    10,    14,    15,    16,    -1,    -1,    -1,    -1,    -1,
      -1,    23,    -1,    -1,    23,    30,    31,    32,    33,    34,
      35,    -1,    37,    38,    39,    40,    30,    31,    32,    33,
      34,    35,    -1,    37,    38,    39,    40
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     7,     9,    10,    23,    44,    46,    47,
      48,    49,    55,    23,     0,    23,    44,    45,    49,    55,
      16,    19,    45,    45,    46,    50,    51,    46,    52,    53,
      23,    17,    24,    23,    24,    20,    50,    52,    54,    16,
      24,     8,    11,    14,    15,    16,    23,    46,    56,    54,
      19,    19,    19,     5,     6,    19,    21,    22,    23,    40,
      41,    58,    56,    57,    19,    26,    36,    23,    17,    22,
      58,    23,    58,    26,    58,    58,    18,    27,    28,    29,
      30,    31,    32,    33,    34,    35,    37,    38,    39,    40,
      57,    17,    20,    58,    23,    23,    58,    18,    20,    20,
      36,    20,    23,    58,    58,    58,    58,    58,    58,    58,
      58,    58,    58,    58,    58,    58,    18,    20,    36,    19,
      18,    18,    12,    58,    18,    58,    20,    58,    56,    18,
      18,    18,    20,    13,    58,    18,    56,    18,    56,    20,
      56
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    43,    44,    44,    45,    45,    45,    46,    46,    46,
      46,    47,    48,    48,    49,    50,    50,    51,    52,    53,
      53,    53,    54,    54,    55,    56,    56,    56,    56,    56,
      56,    56,    56,    56,    56,    56,    56,    56,    57,    57,
      58,    58,    58,    58,    58,    58,    58,    58,    58,    58,
      58,    58,    58,    58,    58,    58,    58,    58,    58,    58,
      58,    58
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     0,     2,     2,     1,     1,     1,
       1,     1,     1,     1,     5,     1,     3,     2,     2,     0,
       1,     3,     1,     3,     8,    11,     6,     8,     5,     3,
       3,     3,     4,     6,     5,     4,     6,     7,     0,     2,
       1,     1,     1,     1,     2,     2,     1,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     3
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 297;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42
    };
  }


  private static final int YYLAST_ = 316;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 14;
  private static final int YYNTOKENS_ = 43;

/* Unqualified %code blocks.  */
/* "ToY.y":19  */

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

/* "ToY.java":1823  */

}
/* "ToY.y":411  */


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
