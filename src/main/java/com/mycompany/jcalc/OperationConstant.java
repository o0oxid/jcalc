package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/19/16.
 */
public class OperationConstant extends OperationAbstract {
    private double value;
    public int priority = 0;
    public OperationConstant(double value) {
        this.value = value;
    }

    public double perform(double a) {
        this.value = a;
        return a;
    }

    public double perform() {
        return this.value;
    }
}
