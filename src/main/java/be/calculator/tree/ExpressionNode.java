package be.calculator.tree;

import be.calculator.visitor.NodeVisitor;

public abstract sealed class ExpressionNode permits NumberNode, BinaryOperationNode, UnaryOperationNode {
    public abstract double accept(NodeVisitor visitor);
}
