package com.mycompany.jcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by okhoruzhenko on 12/16/16.
 */
public class OptionParser {
    private static List<Character> operations = Arrays.asList('+', '-', '*', '\\', '(',')');
    public static LinkedList<ExpressionItem> parse (String[] options) {
        LinkedList<ExpressionItem> expression = new LinkedList<ExpressionItem>();
        for (String item: options) {
            char[] symbols = item.toCharArray();
            for (char c: symbols) {
                if (operations.contains(c)) {
                    switch(c) {
                        case '+':   expression.add(new OperationPlus());
                                    break;
                    }
                }
            }
        }
        return expression;
    }
}
