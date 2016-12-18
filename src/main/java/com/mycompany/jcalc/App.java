package com.mycompany.jcalc;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LinkedList<ExpressionItem> expression = OptionParser.parse(args);
        for (ExpressionItem i: expression) {System.out.println(i);}
    }
}
