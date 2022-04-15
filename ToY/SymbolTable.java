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
            System.out.print("Function Name: " + key + " | " + "Return Type: " + function.returnType + " | ");
            
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
            System.out.print("Struct Name: " + key + " | ");
            System.out.print("Fields: ");
            for (int i = 0; i < struct.fields.size(); i++) {
                System.out.print(struct.fields.get(i).name + ":" + struct.fields.get(i).type + ", ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public boolean isVariableDeclared(String name, ArrayList<Variable> localVariables) {
        for(int i = 0; i < localVariables.size(); i++) {
            if(localVariables.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String getVariableType(String name, ArrayList<Variable> localVariables) {
        for(int i = 0; i < localVariables.size(); i++) {
            if(localVariables.get(i).name.equals(name)) {
                return localVariables.get(i).type;
            }
        }
        return "";
    }

    public boolean isStructDeclared(String name) {
        return structSymbolTable.containsKey(name);
    }

    public boolean isStructField(String structName, String varName) {
        Struct struct = structSymbolTable.get(structName);
        for (int i = 0; i < struct.fields.size(); i++) {
            if(struct.fields.get(i).name.equals(varName)) {
                return true;
            }
        }
        return false;
    }

    // public boolean isReturnType(String returnType, String returnType) {
    //     return func.returnType.equals(returnType);
    // }

    public boolean isCorrectType(String typeOne, String typeTwo, String expectedType) {
        if((!typeOne.equals(expectedType)) | (!typeTwo.equals(expectedType))) {
            return false;
        }
        return true;
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

    // public boolean returnTypeMatches() {
    //     return true;
    // }

    public class Function {
        public String name;
        public String returnType;
        public ArrayList<Variable> parameters = new ArrayList<Variable>();
        public ArrayList<Variable> localVariables = new ArrayList<Variable>();
        
        public Function() {
            this.name = "";
            this.returnType = "";
        }

        public Function(String name, String returnType, ArrayList<Variable> parameters) {
            this.name = name;
            this.returnType = returnType;
            this.parameters = parameters;
            this.localVariables = localVariables;
        }
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
    }

    public class Variable {
        public String name;
        public String type;

        public Variable() {
            this.name = "";
            this.type = "";
        }

        public Variable(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }
}
