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
/* "ToY.y":8  */

    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.Reader;
    import java.io.StreamTokenizer;
    import ToY.AST;

/* "ToY.java":53  */

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
    S_ASSIGN(16),                  /* ASSIGN  */
    S_LEFTCURLY(17),               /* LEFTCURLY  */
    S_RIGHTCURLY(18),              /* RIGHTCURLY  */
    S_SEMICOLON(19),               /* SEMICOLON  */
    S_LEFT(20),                    /* LEFT  */
    S_RIGHT(21),                   /* RIGHT  */
    S_IDENTIFIER(22),              /* IDENTIFIER  */
    S_INTEGER_LITERAL(23),         /* INTEGER_LITERAL  */
    S_STRING_LITERAL(24),          /* STRING_LITERAL  */
    S_COMMA(25),                   /* COMMA  */
    S_NOT(26),                     /* NOT  */
    S_PERIOD(27),                  /* PERIOD  */
    S_MOD(28),                     /* MOD  */
    S_AND(29),                     /* AND  */
    S_OR(30),                      /* OR  */
    S_EQ(31),                      /* EQ  */
    S_LT(32),                      /* LT  */
    S_GT(33),                      /* GT  */
    S_LE(34),                      /* LE  */
    S_GE(35),                      /* GE  */
    S_NE(36),                      /* NE  */
    S_PLUS(37),                    /* PLUS  */
    S_MINUS(38),                   /* MINUS  */
    S_TIMES(39),                   /* TIMES  */
    S_DIVIDE(40),                  /* DIVIDE  */
    S_YYACCEPT(41),                /* $accept  */
    S_pgm(42),                     /* pgm  */
    S_pgm1(43),                    /* pgm1  */
    S_type(44),                    /* type  */
    S_returnType(45),              /* returnType  */
    S_struct(46),                  /* struct  */
    S_declaration(47),             /* declaration  */
    S_declarationZeroPlus(48),     /* declarationZeroPlus  */
    S_declarationOnePlus(49),      /* declarationOnePlus  */
    S_proc(50),                    /* proc  */
    S_statement(51),               /* statement  */
    S_statementSeq(52),            /* statementSeq  */
    S_lExp(53),                    /* lExp  */
    S_exp(54),                     /* exp  */
    S_calcExp(55),                 /* calcExp  */
    S_logicalExp(56),              /* logicalExp  */
    S_comparisonExp(57);           /* comparisonExp  */


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
      SymbolKind.S_ASSIGN,
      SymbolKind.S_LEFTCURLY,
      SymbolKind.S_RIGHTCURLY,
      SymbolKind.S_SEMICOLON,
      SymbolKind.S_LEFT,
      SymbolKind.S_RIGHT,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_INTEGER_LITERAL,
      SymbolKind.S_STRING_LITERAL,
      SymbolKind.S_COMMA,
      SymbolKind.S_NOT,
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
      SymbolKind.S_PLUS,
      SymbolKind.S_MINUS,
      SymbolKind.S_TIMES,
      SymbolKind.S_DIVIDE,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_pgm,
      SymbolKind.S_pgm1,
      SymbolKind.S_type,
      SymbolKind.S_returnType,
      SymbolKind.S_struct,
      SymbolKind.S_declaration,
      SymbolKind.S_declarationZeroPlus,
      SymbolKind.S_declarationOnePlus,
      SymbolKind.S_proc,
      SymbolKind.S_statement,
      SymbolKind.S_statementSeq,
      SymbolKind.S_lExp,
      SymbolKind.S_exp,
      SymbolKind.S_calcExp,
      SymbolKind.S_logicalExp,
      SymbolKind.S_comparisonExp
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
  "FOR", "RETURN", "ASSIGN", "LEFTCURLY", "RIGHTCURLY", "SEMICOLON",
  "LEFT", "RIGHT", "IDENTIFIER", "INTEGER_LITERAL", "STRING_LITERAL",
  "COMMA", "NOT", "PERIOD", "MOD", "AND", "OR", "EQ", "LT", "GT", "LE",
  "GE", "NE", "PLUS", "MINUS", "TIMES", "DIVIDE", "$accept", "pgm", "pgm1",
  "type", "returnType", "struct", "declaration", "declarationZeroPlus",
  "declarationOnePlus", "proc", "statement", "statementSeq", "lExp", "exp",
  "calcExp", "logicalExp", "comparisonExp", null
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
    /** Token ASSIGN, to be returned by the scanner.  */
    static final int ASSIGN = 271;
    /** Token LEFTCURLY, to be returned by the scanner.  */
    static final int LEFTCURLY = 272;
    /** Token RIGHTCURLY, to be returned by the scanner.  */
    static final int RIGHTCURLY = 273;
    /** Token SEMICOLON, to be returned by the scanner.  */
    static final int SEMICOLON = 274;
    /** Token LEFT, to be returned by the scanner.  */
    static final int LEFT = 275;
    /** Token RIGHT, to be returned by the scanner.  */
    static final int RIGHT = 276;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 277;
    /** Token INTEGER_LITERAL, to be returned by the scanner.  */
    static final int INTEGER_LITERAL = 278;
    /** Token STRING_LITERAL, to be returned by the scanner.  */
    static final int STRING_LITERAL = 279;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 280;
    /** Token NOT, to be returned by the scanner.  */
    static final int NOT = 281;
    /** Token PERIOD, to be returned by the scanner.  */
    static final int PERIOD = 282;
    /** Token MOD, to be returned by the scanner.  */
    static final int MOD = 283;
    /** Token AND, to be returned by the scanner.  */
    static final int AND = 284;
    /** Token OR, to be returned by the scanner.  */
    static final int OR = 285;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 286;
    /** Token LT, to be returned by the scanner.  */
    static final int LT = 287;
    /** Token GT, to be returned by the scanner.  */
    static final int GT = 288;
    /** Token LE, to be returned by the scanner.  */
    static final int LE = 289;
    /** Token GE, to be returned by the scanner.  */
    static final int GE = 290;
    /** Token NE, to be returned by the scanner.  */
    static final int NE = 291;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 292;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 293;
    /** Token TIMES, to be returned by the scanner.  */
    static final int TIMES = 294;
    /** Token DIVIDE, to be returned by the scanner.  */
    static final int DIVIDE = 295;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

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
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Object value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Object[] newValueStack = new Object[size * 2];
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

    public final Object valueAt(int i) {
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
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 7: /* type: INT  */
  if (yyn == 7)
    /* "ToY.y":71  */
                    {System.out.println("INT");};
  break;


  case 8: /* type: BOOL  */
  if (yyn == 8)
    /* "ToY.y":72  */
                    {System.out.println("BOOL");};
  break;


  case 9: /* type: STRING  */
  if (yyn == 9)
    /* "ToY.y":73  */
                    {System.out.println("STRING");};
  break;


  case 10: /* type: STRUCT  */
  if (yyn == 10)
    /* "ToY.y":74  */
                    {System.out.println("STRUCT");};
  break;


  case 20: /* proc: returnType IDENTIFIER LEFT declarationZeroPlus RIGHT LEFTCURLY statement RIGHTCURLY  */
  if (yyn == 20)
    /* "ToY.y":111  */
                                                                                            {System.out.println("proc");};
  break;


  case 26: /* statement: IDENTIFIER ASSIGN exp SEMICOLON  */
  if (yyn == 26)
    /* "ToY.y":124  */
                                                        {System.out.println("statement IDENTIFIER ASSIGN exp SEMICOLON");};
  break;



/* "ToY.java":614  */

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
    Object yylval = null;



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

  private static final short yypact_ninf_ = -45;
  private static final short yytable_ninf_ = -48;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      81,   -45,   -45,   -45,   -45,   -10,    49,   -45,     8,    81,
      81,    23,   -45,    45,   -45,   -45,    81,    81,   103,   103,
     -45,   -45,   -45,    34,    46,    43,    52,    58,   -45,   103,
     -45,   103,    66,   -45,   -45,   116,    69,    83,    84,    21,
     116,     1,   100,    87,   112,   108,    21,   113,   -45,   -45,
      21,   -24,    14,    21,    21,   -45,   110,    36,   -45,   -45,
     116,   146,    40,    21,   114,   115,   -45,    21,   141,   178,
     174,   194,   153,   -45,   -45,    21,    21,    21,    21,    21,
      21,    21,    21,   -15,   -15,   -15,   -15,   -15,   -45,   -45,
      30,   118,   210,   193,   -45,   -45,   136,   187,   209,    21,
     -45,   125,   125,   169,   169,   169,   169,   169,   169,   -45,
     -45,   179,    41,    41,   -45,   -45,    21,   -45,   203,   -45,
     -45,   116,   144,   226,   -45,   219,    21,   214,   116,   162,
     -45,   -45,   116,   213,   116,   -45
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
       0,     8,     7,    12,     9,     0,     0,    11,     0,     0,
       4,     0,     1,     0,     3,     2,     4,     4,     0,    15,
       6,     5,    10,     0,    18,     0,    16,     0,    14,     0,
      13,     0,     0,    19,    17,     0,     0,     0,     0,     0,
      32,     0,     0,     0,     0,     0,     0,     0,    38,    39,
       0,    34,    36,     0,     0,    44,     0,    41,    42,    43,
      32,     0,     0,     0,     0,     0,    20,     0,     0,     0,
       0,     0,    55,    40,    25,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,    33,    27,
      34,     0,     0,    34,    35,    28,     0,     0,     0,     0,
      45,    53,    54,    56,    58,    57,    60,    59,    61,    47,
      46,    52,    48,    49,    50,    51,     0,    26,     0,    29,
      24,     0,     0,     0,    30,    22,     0,     0,     0,     0,
      31,    23,     0,     0,     0,    21
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
     -45,   227,    79,    92,   -45,    11,   216,   -45,    -7,    39,
     -34,   177,   -35,   -44,    31,   -45,   -45
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     6,    15,    42,     8,    16,    24,    27,    25,    17,
      60,    61,    55,    56,    57,    58,    59
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
      44,    43,    69,    64,   -47,    44,    71,   109,   110,    72,
      73,     9,    11,   -47,   -47,   -47,   -47,    62,    91,    92,
       9,    63,    33,    96,    34,    44,    48,    49,    64,    94,
      13,   101,   102,   103,   104,   105,   106,   107,   108,    10,
      18,    50,   -46,    51,    52,    48,    49,    53,    10,    12,
     116,   -46,   -46,   -46,   -46,   122,    28,    64,   -47,    54,
      50,    30,    90,    52,    83,    19,    53,   -47,   -47,   -47,
     -47,    29,   123,    84,    85,    86,    87,    31,    54,    32,
      86,    87,   129,    35,     1,     2,    44,   125,     3,    45,
       4,     5,     7,    44,   131,    20,    21,    44,   133,    44,
     135,     7,     7,    46,    47,    66,     1,     2,     7,     7,
      23,    23,     4,    22,   111,   112,   113,   114,   115,     1,
       2,    23,    65,    23,    36,     4,    22,    37,    67,    74,
      38,    39,    68,    40,    95,    70,    93,   117,    41,    75,
      76,    77,    78,    79,    80,    81,    82,    75,    76,    77,
      78,    79,    80,    81,    82,   119,    77,    78,    79,    80,
      81,    82,    97,   126,    89,    75,    76,    77,    78,    79,
      80,    81,    82,    75,    76,    77,    78,    79,    80,    81,
      82,   132,    75,    76,    77,    78,    79,    80,    81,    82,
      99,    75,    76,    77,    78,    79,    80,    81,    82,    98,
     -48,   -48,   -48,   -48,   -48,   -48,   120,    75,    76,    77,
      78,    79,    80,    81,    82,   100,    84,    85,    86,    87,
      64,   121,   124,    75,    76,    77,    78,    79,    80,    81,
      82,   118,   128,   130,   134,    26,    14,    88,     0,    75,
      76,    77,    78,    79,    80,    81,    82,   127,     0,     0,
       0,     0,     0,     0,     0,    75,    76,    77,    78,    79,
      80,    81,    82
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      35,    35,    46,    27,    28,    40,    50,    22,    23,    53,
      54,     0,    22,    37,    38,    39,    40,    16,    62,    63,
       9,    20,    29,    67,    31,    60,     5,     6,    27,    64,
      22,    75,    76,    77,    78,    79,    80,    81,    82,     0,
      17,    20,    28,    22,    23,     5,     6,    26,     9,     0,
      20,    37,    38,    39,    40,    99,    22,    27,    28,    38,
      20,    18,    22,    23,    28,    20,    26,    37,    38,    39,
      40,    25,   116,    37,    38,    39,    40,    25,    38,    21,
      39,    40,   126,    17,     3,     4,   121,   121,     7,    20,
       9,    10,     0,   128,   128,    16,    17,   132,   132,   134,
     134,     9,    10,    20,    20,    18,     3,     4,    16,    17,
      18,    19,     9,    10,    83,    84,    85,    86,    87,     3,
       4,    29,    22,    31,     8,     9,    10,    11,    16,    19,
      14,    15,    24,    17,    19,    22,    22,    19,    22,    29,
      30,    31,    32,    33,    34,    35,    36,    29,    30,    31,
      32,    33,    34,    35,    36,    19,    31,    32,    33,    34,
      35,    36,    21,    19,    18,    29,    30,    31,    32,    33,
      34,    35,    36,    29,    30,    31,    32,    33,    34,    35,
      36,    19,    29,    30,    31,    32,    33,    34,    35,    36,
      16,    29,    30,    31,    32,    33,    34,    35,    36,    21,
      31,    32,    33,    34,    35,    36,    19,    29,    30,    31,
      32,    33,    34,    35,    36,    21,    37,    38,    39,    40,
      27,    12,    19,    29,    30,    31,    32,    33,    34,    35,
      36,    21,    13,    19,    21,    19,     9,    60,    -1,    29,
      30,    31,    32,    33,    34,    35,    36,    21,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    29,    30,    31,    32,    33,
      34,    35,    36
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     7,     9,    10,    42,    44,    45,    46,
      50,    22,     0,    22,    42,    43,    46,    50,    17,    20,
      43,    43,    10,    44,    47,    49,    47,    48,    22,    25,
      18,    25,    21,    49,    49,    17,     8,    11,    14,    15,
      17,    22,    44,    51,    53,    20,    20,    20,     5,     6,
      20,    22,    23,    26,    38,    53,    54,    55,    56,    57,
      51,    52,    16,    20,    27,    22,    18,    16,    24,    54,
      22,    54,    54,    54,    19,    29,    30,    31,    32,    33,
      34,    35,    36,    28,    37,    38,    39,    40,    52,    18,
      22,    54,    54,    22,    53,    19,    54,    21,    21,    16,
      21,    54,    54,    54,    54,    54,    54,    54,    54,    22,
      23,    55,    55,    55,    55,    55,    20,    19,    21,    19,
      19,    12,    54,    54,    19,    51,    19,    21,    13,    54,
      19,    51,    19,    51,    21,    51
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    41,    42,    42,    43,    43,    43,    44,    44,    44,
      44,    45,    45,    46,    47,    48,    48,    48,    49,    49,
      50,    51,    51,    51,    51,    51,    51,    51,    51,    51,
      51,    51,    52,    52,    53,    53,    54,    54,    54,    54,
      54,    54,    54,    54,    54,    54,    55,    55,    55,    55,
      55,    55,    55,    56,    56,    56,    57,    57,    57,    57,
      57,    57
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     0,     2,     2,     1,     1,     1,
       1,     1,     1,     5,     2,     0,     1,     3,     1,     3,
       8,    11,     6,     8,     5,     3,     4,     3,     3,     4,
       5,     7,     0,     2,     1,     3,     1,     1,     1,     1,
       2,     1,     1,     1,     1,     3,     1,     1,     3,     3,
       3,     3,     3,     3,     3,     2,     3,     3,     3,     3,
       3,     3
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 295;
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
      35,    36,    37,    38,    39,    40
    };
  }


  private static final int YYLAST_ = 262;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 12;
  private static final int YYNTOKENS_ = 41;

/* Unqualified %code blocks.  */
/* "ToY.y":17  */

	public static void main (String args[]) throws IOException {
        ToYLexer lexer = new ToYLexer(System.in);
        ToY parser = new ToY(lexer);
        if (parser.parse())
            System.out.println("VALID");
        else {
            System.out.println("ERROR");
        }

        AST ast = new AST();

        return;
	} 

/* "ToY.java":1306  */

}
/* "ToY.y":203  */


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
