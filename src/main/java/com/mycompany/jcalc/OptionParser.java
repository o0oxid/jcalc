package com.mycompany.jcalc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by okhoruzhenko on 12/16/16.
 */
public class OptionParser {
    private static List<Character> operations = Arrays.asList('+', '-', '*', '/', '(',')');
    public static LinkedList<OperationAbstract> parse (String options) {
        LinkedList<OperationInterface> expression = new LinkedList<OperationInterface>();
        for (char item: options.toCharArray()) {
            
            char[] symbols = item.toCharArray();
            for (char c: symbols) {
                if (operations.contains(c)) {
                    switch(c) {
                        case '+':   expression.add(new OperationPlus());
                                    break;
                        case '-':   expression.add(new OperationMinus());
                                    break;
                        case '*':   expression.add(new OperationMultiply());
                            break;
                        case '/':   expression.add(new OperationDivide());
                            break;
                        case '(':    expression.add(new OperationPriority(true));
                            break;
                        case ')':    expression.add(new OperationPriority(false));
                            break;

                    }
                }
            }
        }
        return expression;
    }
}
