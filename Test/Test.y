%language "Java"

%define api.prefix {Test}
%define api.parser.class {Test}
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
        TestLexer lexer = new TestLexer(System.in);
        Test parser = new Test(lexer);
        if (parser.parse())
            System.out.println("VALID");
        else {
            System.out.println("ERROR");
        }
        return;
	} 
}

%token INT IDENTIFIER SEMICOLON

%%  

assignment
    : INT IDENTIFIER SEMICOLON
;

%%

class TestLexer implements Test.Lexer {
    InputStreamReader it;
    Yylex yylex;

    public TestLexer(InputStream is) {
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
    public int yylex() throws IOException {
        return yylex.yylex();
    }
}