package com.mycompany.jcalc;

import org.apache.commons.lang3.ObjectUtils;

/**
 * Created by okhoruzhenko on 12/23/16.
 */
public enum Operation implements OperationInterface {
    ADD ('+', 10) {
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() + b.perform());
        }
    },
    SUB ('-', 10) {
        @Override
        public ExpressionItem perform(ExpressionItem a) {
            return new ExpressionConstant(a.perform() * -1 );
        }
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() - b.perform());
        }
    },
    DIV ('/', 100) {
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() / b.perform());
        }
    },
    MUL ('*', 100) {
        @Override
        public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
            return new ExpressionConstant(a.perform() * b.perform());
        }
    },
    WUP ('(', 1000) {
        @Override
        public ExpressionItem perform(ExpressionItem a) {
            a.setWeight(a.getWeight()  + getWeight());
            return a;
        }
    },
    WDOWN(')', 1000) {
        @Override
        public ExpressionItem perform(ExpressionItem a) {
            a.setWeight(a.getWeight()  - getWeight());
            return a;
        }
    },
    DONOTHING(' ', 0);

    private char sign;
    private int weight;

    Operation(char sign, int weight) {
        this.sign = sign;
        this.weight = weight;
    }

    public ExpressionItem perform(ExpressionItem a) {
        throw new RuntimeException("Unary operation isn't supported.");
    }

    public ExpressionItem perform(ExpressionItem a, ExpressionItem b) {
        throw new RuntimeException("Binary operation isn't supported.");
    }

    @Override
    public String toString() {return String.valueOf(sign);}
    public String getSign() {return String.valueOf(sign);}
    public int getWeight() {return weight;}

    public static Operation getOperation(String sign) {
        for (Operation o: values()) if (sign.equals(o.getSign())) return o;
        return Operation.DONOTHING;
    }
}
