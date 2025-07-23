package be.calculator.tree;

import be.calculator.visitor.NodeVisitor;

public non-sealed class NumberNode extends ExpressionNode {

    private final int value;

    public NumberNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public double accept(NodeVisitor visitor) {
        return visitor.visitNumberNode(this);
    }

    @Override
    public String toString() {
        return "NumberNode{" +
                "value=" + value +
                '}';
    }
}
