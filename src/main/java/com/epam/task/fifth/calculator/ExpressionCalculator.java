package com.epam.task.fifth.calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator {

    private List<Interpreter> listExpression;
    private static final String WHITESPACE_CHARACTER = "\s";

    public Number calculate(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);

        ArrayDeque<Double> stack = new ArrayDeque<>();
        for (Interpreter currentExpression : listExpression) {
            currentExpression.interpret(stack);
        }

        return stack.pop();
    }

    private void parse(String expression) {
        String[] lexemes = expression.split(WHITESPACE_CHARACTER);

        for (String lexeme : lexemes) {
            if (lexeme.isEmpty()) {
                continue;
            }

            char charLexeme = lexeme.charAt(0);
            switch (charLexeme) {
                case '+': listExpression.add(new TerminalExpressionPlus());
                break;
                case '-': listExpression.add(new TerminalExpressionMinus());
                break;
                case '*': listExpression.add(new TerminalExpressionMultiply());
                break;
                case '/': listExpression.add(new TerminalExpressionDivide());
                break;
                default: Scanner scanner = new Scanner(lexeme);
                if (scanner.hasNextDouble()) {
                    double receivedNumber = scanner.nextDouble();
                    listExpression.add(new NonTerminalExpressionNumber(receivedNumber));
                }
                break;
            }
        }
    }
}
