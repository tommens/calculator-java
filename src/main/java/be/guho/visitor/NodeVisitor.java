package be.guho.visitor;

import be.guho.tree.BinaryOperationNode;
import be.guho.tree.NumberNode;
import be.guho.tree.UnaryOperationNode;

public interface NodeVisitor {
    double visitNumberNode(NumberNode node);
    double visitBinaryOperationNode(BinaryOperationNode node);
    double visitUnaryOperationNode(UnaryOperationNode node);
}