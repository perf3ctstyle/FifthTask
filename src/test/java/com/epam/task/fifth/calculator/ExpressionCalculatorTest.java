package com.epam.task.fifth.calculator;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {

    private final String SUMMATION_EXPRESSION = "2 5 + 6 +";
    private final String SUBTRACTION_EXPRESSION = "1 9 - 5 -";
    private final String MULTIPLICATION_EXPRESSION = "9 8 * 3 *";
    private final String DIVISION_EXPRESSION = "7 63 / 9 /";
    private final double DELTA = 0.1;
    private final ExpressionCalculator expressionCalculator = new ExpressionCalculator();

    @Test
    public void testShouldCalculateSummationExpressionWhenExpressionIsCorrect() {
        double expected = 13;

        double actual = (double) expressionCalculator.calculate(SUMMATION_EXPRESSION);

        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testShouldCalculateSubtractionExpressionWhenExpressionIsCorrect() {
        double expected = -3;
        
        double actual = (double) expressionCalculator.calculate(SUBTRACTION_EXPRESSION);
        
        Assert.assertEquals(expected, actual, DELTA);
    }
    
    @Test
    public void testShouldCalculateMultiplicationExpressionWhenExpressionIsCorrect() {
        double expected = 216;
        
        double actual = (double) expressionCalculator.calculate(MULTIPLICATION_EXPRESSION);
        
        Assert.assertEquals(expected, actual, DELTA);
    }
    
    @Test
    public void testShouldCalculateDivisionExpressionWhenExpressionIsCorrect() {
        double expected = 1;
        
        double actual = (double) expressionCalculator.calculate(DIVISION_EXPRESSION);
        
        Assert.assertEquals(expected, actual, DELTA);
    }
}
