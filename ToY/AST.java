package ToY;

public class AST {
    String nodeType;
    AST left;
    AST right;

    public AST() {
        this.nodeType = null;
        this.left = null;
        this.right = null;
    }

    public AST(String nodeType, AST left, AST right) {
        this.nodeType = nodeType;
        this.left = left;
        this.right = right;
    }
}