package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/20/16.
 */
public class OperationAbstract implements OperationInterface {
    public int priority;
    public double perform(double a, double b) throws Exception {
        throw new Exception("Binary operation is not supported.");
    }

    public double perform(double a) throws Exception {
        throw new Exception("Unary operation is not supported.");
    }
}
