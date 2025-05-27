package be.guho.tree;

import be.guho.visitor.NodeVisitor;

public abstract sealed class ExpressionNode permits NumberNode, BinaryOperationNode, UnaryOperationNode {
    public abstract double accept(NodeVisitor visitor);
}
