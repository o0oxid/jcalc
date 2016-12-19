package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public class OperationPriorityUp extends ExpressionItem {
    public int priority = 10;
    public int prioritize(ExpressionOperand o) {
        o.priority += 10;
    }
}
