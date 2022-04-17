package ToY;

import java.util.HashMap;
import java.util.ArrayList;

public class SymbolTable {
    public HashMap<String, Function> functionSymbolTable;
    public HashMap<String, Struct> structSymbolTable;
    
    public SymbolTable() {
        functionSymbolTable = new HashMap<String, Function>();
        structSymbolTable = new HashMap<String, Struct>();
    }

    public void printFunctionTable() {
        System.out.println("Function Symbol Table:");
        for (String key : functionSymbolTable.keySet()) {
            Function function = functionSymbolTable.get(key);
            System.out.print("Function Name: " + key + " | " + "Return Type: " + function.returnType);

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

    public boolean isVariableDeclared(String name, ArrayList<Variable> variableList) {
        for(int i = 0; i < variableList.size(); i++) {
            if(variableList.get(i).name.equals(name)) {
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

    public String getStructFieldType(String structName, String varName) {
        Struct struct = structSymbolTable.get(structName);
        for (int i = 0; i < struct.fields.size(); i++) {
            if(struct.fields.get(i).name.equals(varName)) {
                return struct.fields.get(i).type;
            }
        }
        return "";
    }

    public boolean isFunctionDeclared(String name) {
        return functionSymbolTable.containsKey(name);
    }

    public String getFunctionReturnType(String functionName) {
        Function function = functionSymbolTable.get(functionName);
        return function.returnType;
    }

    public boolean isCorrectType(String typeOne, String typeTwo, String expectedType) {
        if((!typeOne.equals(expectedType)) | (!typeTwo.equals(expectedType))) {
            return false;
        }
        return true;
    }

    public boolean checkForMain() {
        for (String key : functionSymbolTable.keySet()) {
            if(key.equals("main")) {
                Function function = functionSymbolTable.get(key);
                if(function.returnType.equals("VOID"))
                    return true;
            }
        }
        return false;
    }

    public class Function {
        public String name;
        public String returnType;

        // localVariables includes variables passed in as parameters AND variables declared within the function
        public ArrayList<Variable> localVariables = new ArrayList<Variable>();
        
        public Function() {
            this.name = "";
            this.returnType = "";
        }

        public Function(String name, String returnType, ArrayList<Variable> localVariables) {
            this.name = name;
            this.returnType = returnType;
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
