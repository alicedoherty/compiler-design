package ToY;

import java.util.HashMap;

public class SymbolTable {
    // Variables: name, type
    public static HashMap<String, Integer> variableSymbolTable = new HashMap<String, Integer>();

    // Function: name, returnType, parameterTypes
    public static HashMap<String, Integer[]> functionSymbolTable = new HashMap<String, Integer[]>();

    // Struct: name, listFieldTypes, size
    public static HashMap<String, Integer[]> structSymbolTable = new HashMap<String, Integer[]>();

    public void enterScope() {

    }

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

    public static void printTable() {
        System.out.println("Variable Symbol Table:");
        for (String key : variableSymbolTable.keySet()) {
            System.out.println(key + ": " + variableSymbolTable.get(key));
        }

        System.out.println();

        System.out.println("Function Symbol Table:");
        for (String key : functionSymbolTable.keySet()) {
            Integer[] values = functionSymbolTable.get(key);
            System.out.print(key + ": ");
            System.out.print("returnType = " + values[0] + ", parameterTypes = ");
            for (int i = 1; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
        }

        System.out.println();

        System.out.println("Struct Symbol Table:");
    }
}