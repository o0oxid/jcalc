package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public interface ExpressionOperation {
    double perform(ExpressionOperand i);
    double perform(ExpressionOperand a, ExpressionOperand b);
    String toString();
}
