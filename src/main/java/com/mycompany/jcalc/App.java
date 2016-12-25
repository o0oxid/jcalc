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
        StringBuilder strBuilder = new StringBuilder();
        for (String s: args) {strBuilder.append(s);}
        System.out.println(strBuilder.toString());
        String[] expression = OptionParser.parse(strBuilder.toString());
        System.out.println(expression);
    }
}
