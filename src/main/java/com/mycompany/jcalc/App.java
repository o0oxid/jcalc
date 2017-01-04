package com.mycompany.jcalc;

import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StringBuilder strBuilder = new StringBuilder();
        for (String s: args) {strBuilder.append(s);}
        System.out.println(strBuilder.toString());
        String[] expressionStringArray = OptionParser.parse(strBuilder.toString());
        LinkedList<ExpressionItem> expressionOperationList;
        expressionOperationList = OptionParser.stringToOperation(expressionStringArray);
        Calculate.ApplyPriorities(expressionOperationList);
        Calculate.CalculateExpression(expressionOperationList);
        expressionOperationList.forEach(System.out::println);
    }
}
