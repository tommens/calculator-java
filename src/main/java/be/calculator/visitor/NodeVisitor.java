package be.calculator.visitor;

import be.calculator.tree.BinaryOperationNode;
import be.calculator.tree.NumberNode;
import be.calculator.tree.UnaryOperationNode;

public interface NodeVisitor {
    double visitNumberNode(NumberNode node);
    double visitBinaryOperationNode(BinaryOperationNode node);
    double visitUnaryOperationNode(UnaryOperationNode node);
}