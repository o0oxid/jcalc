package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/18/16.
 */
public interface OperationInterface {
    ExpressionItem perform(ExpressionItem a);
    ExpressionItem perform(ExpressionItem a, ExpressionItem b);
    int getWeight();
}