package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public class OperationPlus extends OperationAbstract {
    public int priority = 1;

    public double perform(double a, double b) {
        return a + b;
    }
    public String toString() {return "+"; }
}
