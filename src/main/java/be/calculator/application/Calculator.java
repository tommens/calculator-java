package be.calculator.application;

import be.calculator.tree.ExpressionNode;
import be.calculator.parser.ExpressionParser;
import be.calculator.visitor.EvaluationVisitor;

public class Calculator implements HistoryMixin {

    private final ExpressionParser parser = new ExpressionParser();
    private final EvaluationVisitor visitor = new EvaluationVisitor();

    public double compute(String expression) {
        ExpressionNode ast = parser.parse(expression);
        double result = ast.accept(visitor);
        addToHistory(expression, result);
        return result;
    }

    public double compute(ExpressionNode ast) {
        double result = ast.accept(visitor);
        addToHistory("expression", result);
        return result;
    }
}