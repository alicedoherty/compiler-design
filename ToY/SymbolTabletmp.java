package ToY;

import java.util.HashMap;
import java.util.ArrayList;
// https://github.com/hartikainen/simple-compiler/blob/master/SymbolTable.java

public class SymbolTabletmp {
    int currentLevel;
    public Scope globalScope;

    public SymbolTabletmp() {
        this.currentLevel = 0;
        this.globalScope = null;
    }

    public void printTable() {
        System.out.println("Symbol Table: ");
        Scope scope = this.globalScope;
    }

    // Need new scope for global, functions, and structs
    public class Scope {
        public Scope nextScope;
        public int returnType;
        // public int frameSize;
        public int scopeLevel;

        // Maps the variables
        public HashMap<String, Symbol> localSymbols = new HashMap<String, Symbol>();

        // Check if you need the returnType
        public Scope(int type, int level) {
            this.returnType = type;
            this.scopeLevel = level;
        }

        // This could be printing the wrong thing
        public void printLocalTable() {
            System.out.println("Local Table: ");
            for (String key : localSymbols.keySet()) {
                Symbol symbol = localSymbols.get(key);
                System.out.println(key + ": " + localSymbols.get(key).type);
            }
        }
    }

    // Symbol - subclasses are variables, functions, structs
    private class Symbol {
        String name;
        // type is returnType for functions
        int type;

        public Symbol(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }

    public class Variable extends Symbol {
        // public String name;
        // public int type;
        // public int level;

        public Variable(String name, int type) {
            // this.name = name;
            // this.type = type;
            super(name, type);
        }
    } 

    public class Function extends Symbol {
        // public String name;
        // public int returnType;
        // int label ?
        public ArrayList<Variable> parameters = new ArrayList<Variable>();

        public Function(String name, int returnType, int level) {
            // this.name = name;
            // this.returnType = type;
            super(name, returnType);
        }

        public void addParameter(Variable variable) {
            this.parameters.add(variable);
        }
    }

    public class Struct extends Symbol {
        // public String name;
        // public int type; // e.g struct type Car myCar
        public ArrayList<Variable> fields = new ArrayList<Variable>();
        public int size; // ?

        public Struct(String name, int type) {
            super(name, type);
        }
    }

    // openScope - creates a new scope
    public void enterScope(int type) {
        Scope scope = new Scope(type, currentLevel++);
        scope.nextScope = globalScope;
        globalScope = scope;
    }

    // closeScope - closes the current scope
    public void exitScope() {

    }

    public void findSymbol(String name) {

    }

    public void addSymbol(String x, String type) {
        // Adds all information we need to know about x in current scope
    }

    public void checkScope(String x) {
        // Check if x is in current scope
    }


    // // Variables: name, type
    // public static HashMap<String, Integer> variableSymbolTable = new HashMap<String, Integer>();

    // // Function: name, returnType, parameterTypes
    // public static HashMap<String, Integer[]> functionSymbolTable = new HashMap<String, Integer[]>();

    // // Struct: name, listFieldTypes, size
    // public static HashMap<String, Integer[]> structSymbolTable = new HashMap<String, Integer[]>();

    // public static void printTable() {
    //     System.out.println("Variable Symbol Table:");
    //     for (String key : variableSymbolTable.keySet()) {
    //         System.out.println(key + ": " + variableSymbolTable.get(key));
    //     }

    //     System.out.println();

    //     System.out.println("Function Symbol Table:");
    //     for (String key : functionSymbolTable.keySet()) {
    //         Integer[] values = functionSymbolTable.get(key);
    //         System.out.print(key + ": ");
    //         System.out.print("returnType = " + values[0] + ", parameterTypes = ");
    //         for (int i = 1; i < values.length; i++) {
    //             System.out.print(values[i] + " ");
    //         }
    //     }

    //     System.out.println();

    //     System.out.println("Struct Symbol Table:");
            
    //     System.out.println("Sym Table: ");

    //     Scope scope = SymbolTable.globalScope;
        
    //     while (scope != null) {
    //         System.out.println(scope);
    //         scope.printLocalTable();
    //         scope = scope.nextScope;
    // }
}