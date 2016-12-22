package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public interface OperationInterface {
    double perform(double a) throws Exception;
    double perform(double a, double b) throws Exception;
    String toString();
}