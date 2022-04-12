package ToY;

public class AST {
    int nodeType;
    AST left;
    AST right;

    public AST() {
        this.nodeType = 0;
        this.left = null;
        this.right = null;
    }

    public AST(int nodeType, AST left, AST right) {
        this.nodeType = nodeType;
        this.left = left;
        this.right = right;
    }
}