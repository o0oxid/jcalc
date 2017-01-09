package com.mycompany.jcalc;

import java.util.LinkedList;

/**
 * Hello world!
 *
 */
class App
{
    public static void main( String[] args )
    {
        StringBuilder strBuilder = new StringBuilder();
        for (String s: args) {strBuilder.append(s);}
        System.out.println(strBuilder.toString());

        OptionParser parser = new OptionParser(strBuilder.toString());
        LinkedList<ExpressionItem> expression = parser.getExpression();
        Calculate calculator = new Calculate();
        calculator.calculate(expression);

        expression.forEach(System.out::println);
    }
}
