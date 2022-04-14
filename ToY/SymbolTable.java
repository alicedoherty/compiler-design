package ToY;

import java.util.HashMap;
import java.util.ArrayList;

public class SymbolTable {
    public HashMap<String, Function> functionSymbolTable;
    public HashMap<String, Struct> structSymbolTable;
    public HashMap<String, Variable> variableSymbolTable;
    
    public SymbolTable() {
        functionSymbolTable = new HashMap<String, Function>();
        structSymbolTable = new HashMap<String, Struct>();
        variableSymbolTable = new HashMap<String, Variable>();
    }

    public void printFunctionTable() {
        System.out.println("Function Symbol Table:");
        for (String key : functionSymbolTable.keySet()) {
            Function function = functionSymbolTable.get(key);
            System.out.print("FunctionName: " + function.name + " | " + "ReturnType: " + function.returnType + " | ");
            System.out.print("Parameters: ");
            for (int i = 0; i < function.parameters.size(); i++) {
                System.out.print(function.parameters.get(i).name + ":" + function.parameters.get(i).type + ", ");
            }
            System.out.println();
        }
        
    }

    public void printStructTable() {

    }

    public void printVariableTable() {
        System.out.println("Variable Symbol Table: ");
        for (String key: variableSymbolTable.keySet()) {
            Variable variable = variableSymbolTable.get(key);
            System.out.print(variable.name + " : " + variable.type + ", ");
        }
    }

    public boolean isVariableDeclared(String name) {
        if (variableSymbolTable.containsKey(name)) {
            return true;
        }
        return false;
    }

    // Is the variable of the given name of a passed in type?
    public boolean isType(String name, int type) {
        if (variableSymbolTable.containsKey(name)) {
            Variable variable = variableSymbolTable.get(name);
            if (variable.type == type) {
                return true;
            }
        }
        return false;
    }

    public boolean returnTypeMatches() {
        return true;
    }

    // public void enterScope() {

    // }

    // public void exitScope() {

    // }

    // public Symbol findSymbol(String name) {
    //     for (Map.Entry<String, Symbol> pair : symbols.entrySet()) {
    //         String symbolName = pair.getKey();
    //         Symbol symbol = pair.getValue();

    //         if (name.equals(symbolName)) {
    //             System.out.println("Symbol: " + symbolName + ": " + symbol);
    //             return symbol;
    //         }
    //     }
    //     return null;
    // }

    // public void addSymbol(Function function) {
    //     symbols.put(function.name, function);
    // }
    
    // public void addSymbol(Variable variable) {
    //     symbols.put(variable.name, variable);
    // }

    public Function addFunction(String name, int type, ArrayList<Variable> parameters) {
        Function function = new Function(name, type, parameters);
        functionSymbolTable.put(name, function);
        return function;
    }

    public void addStruct(String name) {
        Struct struct = new Struct(name);
        structSymbolTable.put(name, struct);
        System.out.println("Struct Added: " + name);
    }

    public Variable addVariable(String name, int type) {
        Variable variable = new Variable(name, type);
        variableSymbolTable.put(name, variable);
        return variable;
    }

    // public class Symbol {
    //     String name;
    //     int type;

    //     public Symbol(String name, int type) {
    //         this.name = name;
    //         this.type = type; // type is the return type for Function
    //     }
    // }

    public class Function {
        public String name;
        public int returnType;
        public ArrayList<Variable> parameters = new ArrayList<Variable>();
        
        public Function() {
            this.name = "";
            this.returnType = -1;
        }

        public Function(String name, int returnType, ArrayList<Variable> parameters) {
            this.name = name;
            this.returnType = returnType;
            this.parameters = parameters;
        }

        public void addParameter(Variable variable) {
            this.parameters.add(variable);
        }
    }

    public class Struct {
        public String name;
        public ArrayList<Variable> fields = new ArrayList<Variable>();
        
        public Struct(String name) {
           this.name = name;
        }

        public void addField(Variable variable) {
            this.fields.add(variable);
        }
    }

    public class Variable {
        public String name;
        public int type;
        public int level;

        public Variable() {
            this.name = "";
            this.type = -1;
            this.level = -1;
        }

        public Variable(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }
}
