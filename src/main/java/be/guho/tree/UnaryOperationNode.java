package be.guho.tree;

import be.guho.visitor.NodeVisitor;

public final class UnaryOperationNode extends ExpressionNode {

    private final String operator;
    private final ExpressionNode operand;

    public UnaryOperationNode(String operator, ExpressionNode operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public String getOperator() {
        return operator;
    }

    public ExpressionNode getOperand() {
        return operand;
    }

    @Override
    public double accept(NodeVisitor visitor) {
        return visitor.visitUnaryOperationNode(this);
    }

    @Override
    public String toString() {
        return "UnaryOperationNode{" +
                "operator='" + operator + '\'' +
                ", operand=" + operand +
                '}';
    }
}

