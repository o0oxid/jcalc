package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public class ExpressionOperand extends ExpressionItem {
    public double value;
    public String toString() {
        return String.valueOf(value);
    }
}
