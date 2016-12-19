package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public class OperationDivide extends ExpressionItem implements ExpressionOperation {
    public int priority = 5;
    public double perform(ExpressionOperand a, ExpressionOperand b) {
        return a.value / b.value;
    }
    public String toString() {return "/"; }
}
