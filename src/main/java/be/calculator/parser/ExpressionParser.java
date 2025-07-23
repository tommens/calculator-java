package be.calculator.parser;


import be.calculator.tree.BinaryOperationNode;
import be.calculator.tree.ExpressionNode;
import be.calculator.tree.NumberNode;

import java.util.List;
import java.util.Stack;

public class ExpressionParser {

    public ExpressionNode parse(String expression) {

        List<Object> outputQueue = ShuntingYard.infixToRPN(expression);
        Stack<ExpressionNode> stack = new Stack<>();

        for (Object item : outputQueue) {
            if (item instanceof Integer) {
                stack.push(new NumberNode((Integer) item));
            } else if (item instanceof String op) {
                ExpressionNode right = stack.pop();
                ExpressionNode left = stack.pop();
                stack.push(new BinaryOperationNode(op, left, right));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return stack.pop();
    }

}
