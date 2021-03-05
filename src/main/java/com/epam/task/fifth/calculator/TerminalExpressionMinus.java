package com.epam.task.fifth.calculator;

import java.util.ArrayDeque;

public class TerminalExpressionMinus implements Interpreter {

    @Override
    public void interpret(ArrayDeque<Double> stack) {
        stack.push(stack.pop() - stack.pop());
    }
}
