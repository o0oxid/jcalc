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
        LinkedList<OperationAbstract> expression = OptionParser.parse(Arrays.toString(args));
        for (OperationInterface e: expression) {System.out.println(e);}
    }
}
