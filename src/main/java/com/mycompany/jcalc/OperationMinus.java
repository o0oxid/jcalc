package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public class OperationMinus extends ExpressionItem implements ExpressionOperation {
    public double perform(ExpressionOperand a) {
        return a.value * -1;
    }

    public double perform(ExpressionOperand a, ExpressionOperand b) {
        return a.value - b.value;
    }

    public String toString() {return "-"; }
}
