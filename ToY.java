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
    import ToY.AST;
    import ToY.SymbolTable;

/* "ToY.java":55  */

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
    S_IDENTIFIER(21),              /* IDENTIFIER  */
    S_INTEGER_LITERAL(22),         /* INTEGER_LITERAL  */
    S_STRING_LITERAL(23),          /* STRING_LITERAL  */
    S_COMMA(24),                   /* COMMA  */
    S_PERIOD(25),                  /* PERIOD  */
    S_MOD(26),                     /* MOD  */
    S_AND(27),                     /* AND  */
    S_OR(28),                      /* OR  */
    S_EQ(29),                      /* EQ  */
    S_LT(30),                      /* LT  */
    S_GT(31),                      /* GT  */
    S_LE(32),                      /* LE  */
    S_GE(33),                      /* GE  */
    S_NE(34),                      /* NE  */
    S_ASSIGN(35),                  /* ASSIGN  */
    S_TIMES(36),                   /* TIMES  */
    S_DIVIDE(37),                  /* DIVIDE  */
    S_PLUS(38),                    /* PLUS  */
    S_MINUS(39),                   /* MINUS  */
    S_NOT(40),                     /* NOT  */
    S_UMINUS(41),                  /* UMINUS  */
    S_YYACCEPT(42),                /* $accept  */
    S_pgm(43),                     /* pgm  */
    S_pgm1(44),                    /* pgm1  */
    S_type(45),                    /* type  */
    S_structName(46),              /* structName  */
    S_returnType(47),              /* returnType  */
    S_struct(48),                  /* struct  */
    S_declaration(49),             /* declaration  */
    S_declarationZeroPlus(50),     /* declarationZeroPlus  */
    S_declarationOnePlus(51),      /* declarationOnePlus  */
    S_proc(52),                    /* proc  */
    S_statement(53),               /* statement  */
    S_statementSeq(54),            /* statementSeq  */
    S_lExp(55),                    /* lExp  */
    S_exp(56);                     /* exp  */


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
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_INTEGER_LITERAL,
      SymbolKind.S_STRING_LITERAL,
      SymbolKind.S_COMMA,
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
      SymbolKind.S_declaration,
      SymbolKind.S_declarationZeroPlus,
      SymbolKind.S_declarationOnePlus,
      SymbolKind.S_proc,
      SymbolKind.S_statement,
      SymbolKind.S_statementSeq,
      SymbolKind.S_lExp,
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
  "IDENTIFIER", "INTEGER_LITERAL", "STRING_LITERAL", "COMMA", "PERIOD",
  "MOD", "AND", "OR", "EQ", "LT", "GT", "LE", "GE", "NE", "ASSIGN",
  "TIMES", "DIVIDE", "PLUS", "MINUS", "NOT", "UMINUS", "$accept", "pgm",
  "pgm1", "type", "structName", "returnType", "struct", "declaration",
  "declarationZeroPlus", "declarationOnePlus", "proc", "statement",
  "statementSeq", "lExp", "exp", null
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
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 276;
    /** Token INTEGER_LITERAL, to be returned by the scanner.  */
    static final int INTEGER_LITERAL = 277;
    /** Token STRING_LITERAL, to be returned by the scanner.  */
    static final int STRING_LITERAL = 278;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 279;
    /** Token PERIOD, to be returned by the scanner.  */
    static final int PERIOD = 280;
    /** Token MOD, to be returned by the scanner.  */
    static final int MOD = 281;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 282;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 283;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 284;
    /** Token LT, to be returned by the scanner.  */
    static final int LT = 285;
    /** Token GT, to be returned by the scanner.  */
    static final int GT = 286;
    /** Token LE, to be returned by the scanner.  */
    static final int LE = 287;
    /** Token GE, to be returned by the scanner.  */
    static final int GE = 288;
    /** Token NE, to be returned by the scanner.  */
    static final int NE = 289;
    /** Token ASSIGN, to be returned by the scanner.  */
    static final int ASSIGN = 290;
    /** Token TIMES, to be returned by the scanner.  */
    static final int TIMES = 291;
    /** Token DIVIDE, to be returned by the scanner.  */
    static final int DIVIDE = 292;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 293;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 294;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 295;
    /** Token UMINUS, to be returned by the scanner.  */
    static final int UMINUS = 296;

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
          case 15: /* declaration: type IDENTIFIER  */
  if (yyn == 15)
    /* "ToY.y":96  */
                            { SymbolTable.variableSymbolTable.put(yystack.valueAt (0).value, yystack.valueAt (1).type); };
  break;


  case 21: /* proc: returnType IDENTIFIER LEFT declarationZeroPlus RIGHT LEFTCURLY statement RIGHTCURLY  */
  if (yyn == 21)
    /* "ToY.y":111  */
                                                                                                { SymbolTable.functionSymbolTable.put(yystack.valueAt (6).value, new Integer[] {yystack.valueAt (7).type} ); };
  break;


  case 28: /* statement: type IDENTIFIER SEMICOLON  */
  if (yyn == 28)
    /* "ToY.y":124  */
                                        { SymbolTable.variableSymbolTable.put(yystack.valueAt (1).value, yystack.valueAt (2).type); };
  break;



/* "ToY.java":595  */

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

  private static final short yypact_ninf_ = -46;
  private static final short yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     218,   -46,   -46,   -46,   -46,   -17,   -46,     9,   -46,   -46,
       6,   218,   218,    32,   -46,    38,   -46,   -46,   218,   218,
      41,    41,   -46,   -46,    40,    42,    51,    45,    54,   -46,
      41,   -46,    41,    62,   -46,   -46,     4,    64,    66,    75,
      37,     4,    30,    60,    72,    76,    89,    37,    74,   -46,
     -46,    37,    85,   -46,   -46,    37,    37,   -46,    70,     4,
     110,    37,   107,   108,   126,   -46,    37,   125,   136,   111,
     151,   -46,   -46,   -46,    37,    37,    37,    37,    37,    37,
      37,    37,    37,    37,    37,    37,    37,   -46,   -46,   166,
     -46,   142,   -46,    87,   158,   179,    37,   -46,   204,   204,
     204,   215,   215,   215,   215,   215,   215,     8,     8,   -46,
     -46,   188,    37,   -46,   -46,     4,   104,   -46,   181,   203,
      37,   205,     4,   121,   -46,   -46,     4,   206,     4,   -46
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
       0,    16,     6,     5,     0,    19,     0,    17,     0,    15,
       0,    14,     0,     0,    20,    18,     0,     0,     0,     0,
       0,    32,    11,     0,     0,     0,     0,     0,     0,    38,
      39,     0,    34,    36,    37,     0,     0,    42,     0,    32,
       0,     0,     0,     0,     0,    21,     0,     0,     0,     0,
       0,    40,    41,    26,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    33,    27,     0,
      35,     0,    28,     0,     0,     0,     0,    43,    48,    49,
      50,    51,    53,    52,    55,    54,    56,    46,    47,    44,
      45,     0,     0,    29,    25,     0,     0,    30,     0,    23,
       0,     0,     0,     0,    31,    24,     0,     0,     0,    22
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
     -46,   213,    35,    52,   -46,   -46,     3,   208,   -46,    -8,
      17,   -35,   171,   -36,   -45
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     7,    17,    43,     9,    10,    18,    25,    28,    26,
      19,    59,    60,    57,    58
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
      45,    44,    68,    11,    13,    45,    70,     1,     2,    14,
      71,    72,    37,     4,    11,    38,    89,    12,    39,    40,
      41,    93,    34,    45,    35,    42,    90,    15,    12,    98,
      99,   100,   101,   102,   103,   104,   105,   106,   107,   108,
     109,   110,    49,    50,     1,     2,    85,    86,    20,    61,
       4,   116,     8,    22,    23,    62,    51,    21,    52,    53,
      54,    29,     6,     8,     8,    63,    30,   118,    31,    32,
       8,     8,    24,    24,    33,   123,    55,    56,    36,    45,
     119,    64,    24,    46,    24,    47,    45,   125,    73,    65,
      45,   127,    45,   129,    48,    69,    74,    75,    76,    77,
      78,    79,    80,    81,    82,   113,    83,    84,    85,    86,
      62,    66,    67,    74,    75,    76,    77,    78,    79,    80,
      81,    82,   120,    83,    84,    85,    86,    88,    52,    91,
      74,    75,    76,    77,    78,    79,    80,    81,    82,   126,
      83,    84,    85,    86,    92,    94,    96,    74,    75,    76,
      77,    78,    79,    80,    81,    82,    95,    83,    84,    85,
      86,   112,    74,    75,    76,    77,    78,    79,    80,    81,
      82,    97,    83,    84,    85,    86,   114,    74,    75,    76,
      77,    78,    79,    80,    81,    82,   111,    83,    84,    85,
      86,   115,    74,    75,    76,    77,    78,    79,    80,    81,
      82,   121,    83,    84,    85,    86,   117,    74,    75,    76,
      77,    78,    79,    80,    81,    82,   122,    83,    84,    85,
      86,     1,     2,   124,    16,     3,   128,     4,     5,    27,
      87,     0,     0,    77,    78,    79,    80,    81,    82,     6,
      83,    84,    85,    86,    -1,    -1,    -1,    -1,    -1,    -1,
       0,    83,    84,    85,    86
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      36,    36,    47,     0,    21,    41,    51,     3,     4,     0,
      55,    56,     8,     9,    11,    11,    61,     0,    14,    15,
      16,    66,    30,    59,    32,    21,    62,    21,    11,    74,
      75,    76,    77,    78,    79,    80,    81,    82,    83,    84,
      85,    86,     5,     6,     3,     4,    38,    39,    16,    19,
       9,    96,     0,    18,    19,    25,    19,    19,    21,    22,
      23,    21,    21,    11,    12,    35,    24,   112,    17,    24,
      18,    19,    20,    21,    20,   120,    39,    40,    16,   115,
     115,    21,    30,    19,    32,    19,   122,   122,    18,    17,
     126,   126,   128,   128,    19,    21,    26,    27,    28,    29,
      30,    31,    32,    33,    34,    18,    36,    37,    38,    39,
      25,    35,    23,    26,    27,    28,    29,    30,    31,    32,
      33,    34,    18,    36,    37,    38,    39,    17,    21,    21,
      26,    27,    28,    29,    30,    31,    32,    33,    34,    18,
      36,    37,    38,    39,    18,    20,    35,    26,    27,    28,
      29,    30,    31,    32,    33,    34,    20,    36,    37,    38,
      39,    19,    26,    27,    28,    29,    30,    31,    32,    33,
      34,    20,    36,    37,    38,    39,    18,    26,    27,    28,
      29,    30,    31,    32,    33,    34,    20,    36,    37,    38,
      39,    12,    26,    27,    28,    29,    30,    31,    32,    33,
      34,    20,    36,    37,    38,    39,    18,    26,    27,    28,
      29,    30,    31,    32,    33,    34,    13,    36,    37,    38,
      39,     3,     4,    18,    11,     7,    20,     9,    10,    21,
      59,    -1,    -1,    29,    30,    31,    32,    33,    34,    21,
      36,    37,    38,    39,    29,    30,    31,    32,    33,    34,
      -1,    36,    37,    38,    39
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     7,     9,    10,    21,    43,    45,    46,
      47,    48,    52,    21,     0,    21,    43,    44,    48,    52,
      16,    19,    44,    44,    45,    49,    51,    49,    50,    21,
      24,    17,    24,    20,    51,    51,    16,     8,    11,    14,
      15,    16,    21,    45,    53,    55,    19,    19,    19,     5,
       6,    19,    21,    22,    23,    39,    40,    55,    56,    53,
      54,    19,    25,    35,    21,    17,    35,    23,    56,    21,
      56,    56,    56,    18,    26,    27,    28,    29,    30,    31,
      32,    33,    34,    36,    37,    38,    39,    54,    17,    56,
      55,    21,    18,    56,    20,    20,    35,    20,    56,    56,
      56,    56,    56,    56,    56,    56,    56,    56,    56,    56,
      56,    20,    19,    18,    18,    12,    56,    18,    56,    53,
      18,    20,    13,    56,    18,    53,    18,    53,    20,    53
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    42,    43,    43,    44,    44,    44,    45,    45,    45,
      45,    46,    47,    47,    48,    49,    50,    50,    50,    51,
      51,    52,    53,    53,    53,    53,    53,    53,    53,    53,
      53,    53,    54,    54,    55,    55,    56,    56,    56,    56,
      56,    56,    56,    56,    56,    56,    56,    56,    56,    56,
      56,    56,    56,    56,    56,    56,    56
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     0,     2,     2,     1,     1,     1,
       1,     1,     1,     1,     5,     2,     0,     1,     3,     1,
       3,     8,    11,     6,     8,     5,     3,     3,     3,     4,
       5,     7,     0,     2,     1,     3,     1,     1,     1,     1,
       2,     2,     1,     3,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     3
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 296;
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
      35,    36,    37,    38,    39,    40,    41
    };
  }


  private static final int YYLAST_ = 254;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 14;
  private static final int YYNTOKENS_ = 42;

/* Unqualified %code blocks.  */
/* "ToY.y":20  */

	public static void main (String args[]) throws IOException {
        ToYLexer lexer = new ToYLexer(System.in);
        ToY parser = new ToY(lexer);

        if (parser.parse())
            System.out.println("VALID");
        else {
            System.out.println("ERROR");
        }
        SymbolTable.printTable();
	} 

/* "ToY.java":1278  */

}
/* "ToY.y":167  */


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
