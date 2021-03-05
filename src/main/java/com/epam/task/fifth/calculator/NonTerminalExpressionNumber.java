package com.epam.task.fifth.calculator;

import java.util.ArrayDeque;

public class NonTerminalExpressionNumber implements Interpreter {

    private final double number;

    public NonTerminalExpressionNumber(double number) {
        this.number = number;
    }

    @Override
    public void interpret(ArrayDeque<Double> stack) {
        stack.push(number);
    }
}
