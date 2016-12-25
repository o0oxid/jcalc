package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/20/16.
 */
public abstract class ExpressionItem implements OperationInterface, ConstantInterface {
    private int weight;
    public int getWeight() {return weight;}
    public void setWeight(int weight) {this.weight = weight;}
}
