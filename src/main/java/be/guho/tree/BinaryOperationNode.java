package be.guho.tree;

import be.guho.visitor.NodeVisitor;

public final class BinaryOperationNode extends ExpressionNode {

    private final String operator;
    private final ExpressionNode left;
    private final ExpressionNode right;

    public BinaryOperationNode(String operator, ExpressionNode left, ExpressionNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    @Override
    public double accept(NodeVisitor visitor) {
        return visitor.visitBinaryOperationNode(this);
    }

    @Override
    public String toString() {
        return "BinaryOperationNode{" +
                "operator='" + operator + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
