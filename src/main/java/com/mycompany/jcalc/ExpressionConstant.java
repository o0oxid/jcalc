package com.mycompany.jcalc;

/**
 * Created by okhoruzhenko on 12/24/16.
 */
public class ExpressionConstant extends ExpressionItem {
    double value;
    public ExpressionConstant(double value) {
        setWeight(1);
        this.value = value;
    }
    @Override
    public double perform(){
        return this.value;
    }
    @Override
    public ExpressionItem perform(ExpressionItem a) {
        throw new RuntimeException("Constant doesn't support operations.");
    }
    @Override
    public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
        throw new RuntimeException("Constant doesn't support operations.");
    }

    @Override
    public String toString() {return String.valueOf(value);}
}
