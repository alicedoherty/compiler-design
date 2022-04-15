package ToY;

import java.util.HashMap;
import java.util.ArrayList;

public class SymbolTable {
    public HashMap<String, Function> functionSymbolTable;
    public HashMap<String, Struct> structSymbolTable;
    //public HashMap<String, Variable> variableSymbolTable;
    
    public SymbolTable() {
        functionSymbolTable = new HashMap<String, Function>();
        structSymbolTable = new HashMap<String, Struct>();
        //variableSymbolTable = new HashMap<String, Variable>();
    }

    public void printFunctionTable() {
        System.out.println("Function Symbol Table:");
        for (String key : functionSymbolTable.keySet()) {
            Function function = functionSymbolTable.get(key);
            System.out.print("Function Name: " + function.name + " | " + "Return Type: " + function.returnType + " | ");
            
            System.out.print("Parameters: ");
            for (int i = 0; i < function.parameters.size(); i++) {
                System.out.print(function.parameters.get(i).name + ":" + function.parameters.get(i).type + ", ");
            }

            System.out.print("| Local Variables: ");
            for(int i = 0; i < function.localVariables.size(); i++) {
                System.out.print(function.localVariables.get(i).name + ":" + function.localVariables.get(i).type + ", ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public void printStructTable() {
        System.out.println("Struct Symbol Table:");
        for (String key : structSymbolTable.keySet()) {
            Struct struct = structSymbolTable.get(key);
            System.out.print("Struct Name: " + struct.name + " | ");
            System.out.print("Fields: ");
            for (int i = 0; i < struct.fields.size(); i++) {
                System.out.print(struct.fields.get(i).name + ":" + struct.fields.get(i).type + ", ");
            }
            System.out.println();
        }
        System.out.println();

    }

    // public void printVariableTable() {
    //     System.out.println("Variable Symbol Table: ");
    //     for (String key: variableSymbolTable.keySet()) {
    //         Variable variable = variableSymbolTable.get(key);
    //         System.out.print(variable.name + " : " + variable.type + ", ");
    //     }
    // }

    public boolean isVariableDeclared(String name, ArrayList<Variable> localVariables) {
        for(int i = 0; i < localVariables.size(); i++) {
            if(localVariables.get(i).name.equals(name)) {
                return true;
            }
        }
        // if (variableSymbolTable.containsKey(name)) {
        //     return true;
        // }
        return false;
    }

    // Is the variable of the given name of a passed in type?
    // public boolean isType(String name, int type) {
    //     if (variableSymbolTable.containsKey(name)) {
    //         Variable variable = variableSymbolTable.get(name);
    //         if (variable.type == type) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean returnTypeMatches() {
        return true;
    }

    // public Function addFunction(String name, int type, ArrayList<Variable> parameters) {
    //     Function function = new Function(name, type, parameters);
    //     functionSymbolTable.put(name, function);
    //     return function;
    // }

    // public void addStruct(String name) {
    //     Struct struct = new Struct(name);
    //     structSymbolTable.put(name, struct);
    //     System.out.println("Struct Added: " + name);
    // }

    // public Variable createVariable(String name, int type) {
    //     Variable variable = new Variable(name, type);
    //     //variableSymbolTable.put(name, variable);
    //     return variable;
    // }

    public class Function {
        public String name;
        public int returnType;
        public ArrayList<Variable> parameters = new ArrayList<Variable>();
        public ArrayList<Variable> localVariables = new ArrayList<Variable>();
        
        public Function() {
            this.name = "";
            this.returnType = -1;
        }

        public Function(String name, int returnType, ArrayList<Variable> parameters) {
            this.name = name;
            this.returnType = returnType;
            this.parameters = parameters;
            this.localVariables = localVariables;
        }

        // public void addParameter(Variable variable) {
        //     this.parameters.add(variable);
        // }
    }

    public class Struct {
        public String name;
        public ArrayList<Variable> fields = new ArrayList<Variable>();
        
        public Struct() {
            this.name = "";
        }
        
        public Struct(String name) {
           this.name = name;
        }

        // public void addField(Variable variable) {
        //     this.fields.add(variable);
        // }
    }

    public class Variable {
        public String name;
        public int type;

        public Variable() {
            this.name = "";
            this.type = -1;
        }

        public Variable(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }
}
