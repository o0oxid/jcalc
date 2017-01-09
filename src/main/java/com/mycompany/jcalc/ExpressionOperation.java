package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/24/16.
 */
public class ExpressionOperation extends ExpressionItem {

    ExpressionOperation(Operation operation) {
        this.operation = operation;
        setWeight(operation.getWeight());
    }

    @Override
    public double perform() {
        throw new RuntimeException("Operation get value isn't supported for operations");
    }

    @Override
    public ExpressionItem perform(ExpressionItem a) { return operation.perform(a);}

    @Override
    public ExpressionItem perform(ExpressionItem a, ExpressionItem b) { return operation.perform(a, b);}

    @Override
    public String toString() {return operation.toString();}

    @Override
    public boolean isOperation() {return true;}

    public void setWeight(int weight) {super.weight = weight;}
}
