package com.mycompany.jcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.LinkedList;

/**
 * Unit test for jcalc App.
 */
class AppTest {
    @Test
    @DisplayName("My 1st JUnit 5 test! 😎 \uD83D\uDE31")
    void optionSimpleCalculateTest(TestInfo testInfo) {
        String expressionString = "1+2+((-380-1.3/3.15*577)+800)/2.3";
        OptionParser parser = new OptionParser(expressionString);
        LinkedList<ExpressionItem> expressionList = parser.getExpression();
        Calculate calculator = new Calculate();
        calculator.calculate(expressionList);
        assertEquals(82.07522429261562,expressionList.get(0).perform());
    }

    @Test
    @DisplayName("Priority operation test")
    void optionSimpleCalculateTest(TestInfo testInfo) {
        String expressionString = "1+2+((-380-1.3/3.15*577)+800)/2.3";
        OptionParser parser = new OptionParser(expressionString);
        LinkedList<ExpressionItem> expressionList = parser.getExpression();
        Calculate calculator = new Calculate();
        calculator.calculate(expressionList);
        assertEquals(82.07522429261562,expressionList.get(0).perform());
    }
}
