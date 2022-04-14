package ToY;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class SymbolTable {
    public HashMap<String, Symbol> symbols;
    
    public SymbolTable() {
        symbols = new HashMap<String, Symbol>();
    }

    public void printTable() {
        System.out.println("Symbol Table:");
        for (String key : symbols.keySet()) {
            System.out.println("Symbol:" + key + ": " + symbols.get(key));
        }
        System.out.println();
    }

    // public void enterScope() {

    // }

    // public void exitScope() {

    // }

    public Symbol findSymbol(String name) {
        for (Map.Entry<String, Symbol> pair : symbols.entrySet()) {
            String symbolName = pair.getKey();
            Symbol symbol = pair.getValue();

            if (name.equals(symbolName)) {
                System.out.println("Symbol: " + symbolName + ": " + symbol);
                return symbol;
            }
        }
        return null;
    }

    // public void addSymbol(Function function) {
    //     symbols.put(function.name, function);
    // }
    
    // public void addSymbol(Variable variable) {
    //     symbols.put(variable.name, variable);
    // }

    public void addFunction(String name, int type) {
        Function function = new Function(name, type);
        symbols.put(name, function);
        System.out.println("Function Added: " + name + " + " + type);
    }

    public void addStruct(String name, int type) {
        Struct struct = new Struct(name, type);
        symbols.put(name, struct);
        System.out.println("Struct Added: " + name + " + " + type);
    }

    public Variable addVariable(String name, int type) {
        Variable variable = new Variable(name, type);
        return variable;
    }


    // public void checkScope() {

    // }

    public class Symbol {
        String name;
        int type;

        public Symbol(String name, int type) {
            this.name = name;
            this.type = type; // type is the return type for Function
        }
    }

    public class Function extends Symbol {
        public ArrayList<Variable> parameters = new ArrayList<Variable>();
        
        public Function(String name, int returnType) {
            super(name, returnType);
        }

        public void addParameter(Variable variable) {
            this.parameters.add(variable);
        }
    }

    public class Struct extends Symbol {
        public ArrayList<Variable> fields = new ArrayList<Variable>();
        
        public Struct(String name, int type) {
            super(name, type);
        }

        public void addField(Variable variable) {
            this.fields.add(variable);
        }
    }

    public class Variable extends Symbol {
        public int level;

        public Variable(String name, int type) {
            super(name, type);
        }
    }
}
