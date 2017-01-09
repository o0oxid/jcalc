package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/20/16.
 */
public abstract class ExpressionItem implements OperationInterface, ConstantInterface {
    int weight;
    public OperationInterface operation;
    public int getWeight() {return weight;}
    public abstract void setWeight(int weight);
    public abstract boolean isOperation();
}
