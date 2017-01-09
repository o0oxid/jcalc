package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/24/16.
 */
public class ExpressionConstant extends ExpressionItem {
    double value;
    public static final int expressionConstantWeight = 1;
    public ExpressionConstant(double value) {
        setWeight(expressionConstantWeight);
        this.value = value;
        operation = Operation.DONOTHING;
    }

    @Override
    public double perform(){
        return this.value;
    }

    @Override
    public ExpressionItem perform(ExpressionItem a) {
        throw new RuntimeException("Constant doesn't support operation method.");
    }

    @Override
    public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
        throw new RuntimeException("Constant doesn't support operation method.");
    }

    @Override
    public String toString() {return String.valueOf(value);}

    @Override
    public boolean isOperation() {return false;}

    @Override
    public void setWeight(int weight) {}
}
